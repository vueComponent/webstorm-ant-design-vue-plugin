package io.tooko.vue.antd.document;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;

public class DocumentProvider extends AbstractDocumentationProvider {

    @Override
    public String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
        // return super.generateDoc(element, originalElement);
        String text = originalElement.getText();

        if (text != null) {
            String doc = "doc: " + text;
            String textHandle = text.replaceAll("-", "").replaceAll("\n|\r\n", "");
            Class clazz = DocumentConstant.class;
            Field[] fields = clazz.getFields();

            for (Field field : fields) {
                if (textHandle.equals(field.getName()) &&
                        field.getType().toGenericString().endsWith("java.lang.String")) {
                    try {
                        doc = (String) field.get(DocumentConstant.class);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            if ("doc: ".equals(doc)) {
                return null;
            }
            return doc;
        }
        return null;
    }

}
