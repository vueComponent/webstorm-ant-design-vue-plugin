package io.tooko.vue.antd.xml;

import com.intellij.openapi.project.Project;
import com.intellij.psi.xml.XmlTag;
import com.intellij.xml.XmlAttributeDescriptor;
import com.intellij.xml.XmlAttributeDescriptorsProvider;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class AntAttributesProvider implements XmlAttributeDescriptorsProvider {

    /**
     * 给标签加属性
     * @param xmlTag
     * @return
     */
    @Override
    public XmlAttributeDescriptor[] getAttributeDescriptors(XmlTag xmlTag) {
        final Project project = xmlTag.getProject();
        for (Map.Entry<String, HashMap<String, String[]>> next : AntTagConstant.TAG_CONSTANT.entrySet()) {
            if (next.getKey().equals(xmlTag.getName())) {
                HashMap<String, String[]> attrsMap = next.getValue();
                XmlAttributeDescriptor[] attrs = new AntAttributeDescriptor[attrsMap.size()];
                int i = 0;
                for (Map.Entry<String, String[]> attr : attrsMap.entrySet()) {
                    attrs[i] = new AntAttributeDescriptor(project, attr.getKey(), attr.getValue());
                    i++;
                }
                return attrs;
            }
        }
        return XmlAttributeDescriptor.EMPTY;
    }

    @Nullable
    @Override
    public XmlAttributeDescriptor getAttributeDescriptor(String s, XmlTag xmlTag) {
        return null;
    }
}
