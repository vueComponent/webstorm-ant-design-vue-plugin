package io.tooko.vue.antd.xml;

import com.intellij.codeInsight.completion.XmlTagInsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.impl.source.xml.XmlElementDescriptorProvider;
import com.intellij.psi.xml.XmlTag;
import com.intellij.xml.XmlElementDescriptor;
import com.intellij.xml.XmlNSDescriptor;
import com.intellij.xml.XmlTagNameProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标签自动完成
 *
 * @author Sendya
 */
public class AntTagNameProvider implements XmlElementDescriptorProvider, XmlTagNameProvider {

    /**
     * 获取标签描述
     * 在任意输入后执行, 需在 plugin.xml 中配置 xml.elementDescriptorProvider
     *
     * @param xmlTag
     * @return
     */
    @Nullable
    @Override
    public XmlElementDescriptor getDescriptor(XmlTag xmlTag) {
        final XmlNSDescriptor nsDescriptor = xmlTag.getNSDescriptor(xmlTag.getNamespace(), false);
        final XmlElementDescriptor descriptor = nsDescriptor != null ? nsDescriptor.getElementDescriptor(xmlTag) : null;
        // 判断是否包含在特定处理标签内
        boolean special = false;
        for (Map.Entry<String, HashMap<String, String[]>> next : AntTagConstant.TAG_CONSTANT.entrySet()) {
            if (next.getKey().equals(xmlTag.getName())) {
                special = true;
                break;
            }
        }
        if (!special) {
            return null;
        }
        return new AntAnyXmlElementDescriptor(descriptor, nsDescriptor, xmlTag.getName());
    }

    /**
     * 添加属性元素标签
     * 在输入 < 后执行，需要在 plugin.xml 中配置 xml.tagNameProvider
     *
     * @param list
     * @param xmlTag
     * @param s
     */
    @Override
    public void addTagNameVariants(List<LookupElement> list, @NotNull XmlTag xmlTag, String s) {
        for (Map.Entry<String, HashMap<String, String[]>> next : AntTagConstant.TAG_CONSTANT.entrySet()) {
            list.add(LookupElementBuilder.create(next.getKey()).withInsertHandler(XmlTagInsertHandler.INSTANCE));
        }
    }

}
