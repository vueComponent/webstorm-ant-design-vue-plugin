package io.tooko.vue.antd;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AntFileType extends LanguageFileType {

    public static final AntFileType INSTANCE = new AntFileType();

    private AntFileType() {
        super(AntLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Ant";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Ant Design Vue language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "vueComponent";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return AntIcons.FILE;
    }
}
