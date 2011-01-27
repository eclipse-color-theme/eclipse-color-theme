package com.github.eclipsecolortheme.mapper;

import static com.github.eclipsecolortheme.ColorThemeKeys.*;

import java.util.Map;

/** Maps color themes to preferences for Eclipse's Java editor. */
public class CppEditorMapper extends ThemePreferenceMapper {
    /** Creates a new color theme mapper. */
    public CppEditorMapper() {
        super("org.eclipse.cdt.ui");
    }

    @Override
    public void map(Map<String, String> theme) {
        preferences.putBoolean("semanticHighlighting.function.enabled", false);
        preferences.putBoolean(
                "semanticHighlighting.functionDeclaration.enabled", false);
        preferences.putBoolean("semanticHighlighting.class.enabled", false);
        preferences.putBoolean("semanticHighlighting.staticField.enabled",
                               false);
        preferences.putBoolean("semanticHighlighting.interface.enabled", false);
        preferences.putBoolean("semanticHighlighting.enum.enabled", false);
        preferences.putBoolean("semanticHighlighting.staticMethod.enabled",
                               false);
        preferences.putBoolean("semanticHighlighting.method.enabled", false);
        preferences.putBoolean(
                "semanticHighlighting.methodDeclaration.enabled", false);
        preferences.putBoolean("semanticHighlighting.annotation.enabled",
                               false);
        preferences.putBoolean("semanticHighlighting.field.enabled", false);
        preferences.putBoolean("semanticHighlighting.deprecatedMember.enabled",
                               false);
        preferences.putBoolean("semanticHighlighting.number.enabled", false);
        preferences.putBoolean("semanticHighlighting.localVariable.enabled",
                               false);
        preferences.putBoolean(
                "semanticHighlighting.localVariableDeclaration.enabled", false);
        preferences.putBoolean("semanticHighlighting.typeArgument.enabled",
                               false);
        preferences.putBoolean("semanticHighlighting.typeParameter.enabled",
                               false);
        preferences.putBoolean("semanticHighlighting.parameterVariable.enabled",
                               false);

        putPreference("c_default", entry(theme.get(FOREGROUND)));
        putPreference("c_braces", entry(theme.get(BRACKET)));
        putPreference("c_type", entry(theme.get(KEYWORD)));
        putPreference("c_keyword", entry(theme.get(KEYWORD)));
        putPreference("c_numbers", entry(theme.get(NUMBER)));
        putPreference("c_operators", entry(theme.get(OPERATOR)));
        putPreference("c_string", entry(theme.get(STRING)));
        putPreference("c_multi_line_comment",
                      entry(theme.get(MULTI_LINE_COMMENT)));
        putPreference("c_single_line_comment",
                      entry(theme.get(SINGLE_LINE_COMMENT)));
        putPreference("c_comment_task_tag", entry(theme.get(COMMENT_TASK_TAG)));
        putPreference("asm_directive", entry(theme.get(KEYWORD)));
        putPreference("asm_label", entry(theme.get(FOREGROUND)));
        putPreference("pp_directive", entry(theme.get(KEYWORD)));
        putPreference("pp_header", entry(theme.get(STRING)));
        putPreference("pp_default", entry(theme.get(FOREGROUND)));
        putPreference("semanticHighlighting.class.color",
                      entry(theme.get(CLASS)));
        putPreference("semanticHighlighting.enum.color",
                      entry(theme.get(ENUM)));
        putPreference("semanticHighlighting.enumerator.color",
                      entry(theme.get(STATIC_FINAL_FIELD)));
        putPreference("semanticHighlighting.externalSDK.color",
                      entry(theme.get(STATIC_METHOD)));
        putPreference("semanticHighlighting.field.color",
                      entry(theme.get(FIELD)));
        putPreference("semanticHighlighting.functionDeclaration.color",
                      entry(theme.get(METHOD_DECLARATION)));
        putPreference("semanticHighlighting.function.color",
                      entry(theme.get(STATIC_METHOD)));
        putPreference("semanticHighlighting.localVariableDeclaration.color",
                      entry(theme.get(LOCAL_VARIABLE_DECLARATION)));
        putPreference("semanticHighlighting.localVariable.color",
                      entry(theme.get(LOCAL_VARIABLE)));
        putPreference("semanticHighlighting.typeParameter.color",
                      entry(theme.get(TYPE_PARAMETER)));
        putPreference("semanticHighlighting.parameterVariable.color",
                      entry(theme.get(PARAMETER_VARIABLE)));
        putPreference("semanticHighlighting.macroDefinition.color",
                      entry(theme.get(METHOD_DECLARATION)));
        putPreference("semanticHighlighting.methodDeclaration.color",
                      entry(theme.get(METHOD_DECLARATION)));
        putPreference("semanticHighlighting.method.color",
                      entry(theme.get(METHOD)));
        putPreference("semanticHighlighting.namespace.color",
                      entry(theme.get(INTERFACE)));
        putPreference("semanticHighlighting.staticMethod.color",
                      entry(theme.get(STATIC_METHOD)));
        putPreference("semanticHighlighting.staticField.color",
                      entry(theme.get(STATIC_FIELD)));
        putPreference("semanticHighlighting.typedef.color",
                      entry(theme.get(CLASS)));
        putPreference("org.eclipse.cdt.internal.ui.text.doctools.multi",
                      entry(theme.get(JAVADOC)));
        putPreference("org.eclipse.cdt.internal.ui.text.doctools.single",
                      entry(theme.get(JAVADOC)));
        putPreference("org.eclipse.cdt.internal.ui.text.doctools.recognizedTag",
                      entry(theme.get(JAVADOC_TAG)));
    }

    @Override
    protected void putDependentEntries(String key) {
        if ("semanticHighlighting.function.color".equals(key))
            preferences.putBoolean("semanticHighlighting.function.enabled",
                                   true);
        else if ("semanticHighlighting.functionDeclaration.color".equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.functionDeclaration.enabled", true);
        else if ("semanticHighlighting.enum.color".equals(key))
            preferences.putBoolean("semanticHighlighting.enum.enabled",
                                   true);
        else if ("semanticHighlighting.localVariableDeclaration.color"
                .equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.localVariableDeclaration.enabled",
                    true);
        else if ("semanticHighlighting.localVariable.color".equals(key))
            preferences.putBoolean("semanticHighlighting.localVariable.enabled",
                                   true);
        else if ("semanticHighlighting.macroDefinition.color".equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.macroDefinition.enabled", true);
        else if ("semanticHighlighting.namespace.color".equals(key))
            preferences.putBoolean("semanticHighlighting.namespace.enabled",
                                   true);
        else if ("semanticHighlighting.typeParameter.color".equals(key))
            preferences.putBoolean("semanticHighlighting.typeParameter.enabled",
                                   true);
        else if ("semanticHighlighting.parameterVariable.color".equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.parameterVariable.enabled", true);
    }

    @Override
    public void clear() {
        preferences.remove("semanticHighlighting.function.enabled");
        preferences.remove("semanticHighlighting.functionDeclaration.enabled");
        preferences.remove(
                "semanticHighlighting.localVariableDeclaration.enabled");
        preferences.remove("semanticHighlighting.localVariable.enabled");
        preferences.remove("semanticHighlighting.macroDefinition.enabled");
        preferences.remove("semanticHighlighting.namespace.enabled");
        preferences.remove("semanticHighlighting.typeParameter.enabled");
        preferences.remove("c_default");
        preferences.remove("c_braces");
        preferences.remove("c_type");
        preferences.remove("c_keyword");
        preferences.remove("c_numbers");
        preferences.remove("c_operators");
        preferences.remove("c_string");
        preferences.remove("c_multi_line_comment");
        preferences.remove("c_single_line_comment");
        preferences.remove("c_comment_task_tag");
        preferences.remove("asm_directive");
        preferences.remove("asm_label");
        preferences.remove("pp_directive");
        preferences.remove("pp_header");
        preferences.remove("pp_default");
        preferences.remove("semanticHighlighting.class.color");
        preferences.remove("semanticHighlighting.enum.color");
        preferences.remove("semanticHighlighting.enumerator.color");
        preferences.remove("semanticHighlighting.externalSDK.color");
        preferences.remove("semanticHighlighting.field.color");
        preferences.remove("semanticHighlighting.functionDeclaration.color");
        preferences.remove("semanticHighlighting.function.color");
        preferences.remove(
                "semanticHighlighting.localVariableDeclaration.color");
        preferences.remove("semanticHighlighting.localVariable.color");
        preferences.remove("semanticHighlighting.macroDefinition.color");
        preferences.remove("semanticHighlighting.methodDeclaration.color");
        preferences.remove("semanticHighlighting.method.color");
        preferences.remove("semanticHighlighting.namespace.color");
        preferences.remove("semanticHighlighting.staticMethod.color");
        preferences.remove("semanticHighlighting.staticField.color");
        preferences.remove("semanticHighlighting.typeParameter.color");
        preferences.remove("semanticHighlighting.parameterVariable.color");
        preferences.remove("semanticHighlighting.typedef.color");
        preferences.remove("org.eclipse.cdt.internal.ui.text.doctools.multi");
        preferences.remove("org.eclipse.cdt.internal.ui.text.doctools.single");
        preferences.remove(
                "org.eclipse.cdt.internal.ui.text.doctools.recognizedTag");
    }        
}