package com.github.fhd.eclipsecolortheme.mapper;

import java.util.*;

/** Maps color themes to preferences for Eclipse's Java editor. */
public class CppEditorMapper extends ThemePreferenceMapper {
    /** Creates a new color theme mapper. */
    public CppEditorMapper() {
        super("org.eclipse.cdt.ui");
    }

    @Override
    public void map(Map<String, String> theme) {
        preferences.putBoolean("semanticHighlighting.class.enabled", false);
        preferences.putBoolean("semanticHighlighting.staticField.enabled",
                               false);
        preferences.putBoolean("semanticHighlighting.interface.enabled", false);
        preferences.putBoolean("semanticHighlighting.enum.enabled", false);
        preferences.putBoolean(
                "semanticHighlighting.staticMethodInvocation.enabled", false);
        preferences.putBoolean("semanticHighlighting.method.enabled", false);
        preferences.putBoolean(
                "semanticHighlighting.methodDeclarationName.enabled", false);
        preferences.putBoolean("semanticHighlighting.annotation.enabled",
                               false);
        preferences.putBoolean("semanticHighlighting.field.enabled", false);
        preferences.putBoolean("semanticHighlighting.deprecatedMember.enabled",
                               false);
        preferences.putBoolean("semanticHighlighting.number.enabled", false);
        preferences.putBoolean(
                "semanticHighlighting.inheritedMethodInvocation.enabled",
                false);
        preferences.putBoolean(
                "semanticHighlighting.abstractMethodInvocation.enabled", false);
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

        putPreference("c_default", entry(theme.get("foreground")));
        putPreference("c_braces", entry(theme.get("bracket")));
        putPreference("c_type", entry(theme.get("keyword")));
        putPreference("c_keyword", entry(theme.get("keyword")));
        putPreference("c_numbers", entry(theme.get("number")));
        putPreference("c_operators", entry(theme.get("operator")));
        putPreference("c_string", entry(theme.get("string")));
        putPreference("c_multi_line_comment",
                      entry(theme.get("multiLineComment")));
        putPreference("c_single_line_comment",
                      entry(theme.get("singleLineComment")));
        putPreference("c_comment_task_tag", entry(theme.get("commentTaskTag")));
        putPreference("asm_directive", entry(theme.get("keyword")));
        putPreference("asm_label", entry(theme.get("foreground")));
        putPreference("pp_directive", entry(theme.get("keyword")));
        putPreference("pp_header", entry(theme.get("string")));
        putPreference("pp_default", entry(theme.get("foreground")));
        putPreference("semanticHighlighting.class.color",
                      entry(theme.get("class")));
        putPreference("semanticHighlighting.enum.color",
                      entry(theme.get("enum")));
        putPreference("semanticHighlighting.enumerator.color",
                      entry(theme.get("staticFinalField")));
        putPreference("semanticHighlighting.externalSDK.color",
                      entry(theme.get("staticMethodInvocation")));
        putPreference("semanticHighlighting.field.color",
                      entry(theme.get("field")));
        putPreference("semanticHighlighting.functionDeclaration.color",
                      entry(theme.get("methodDeclarationName")));
        putPreference("semanticHighlighting.function.color",
                      entry(theme.get("staticMethodInvocation")));
        putPreference("semanticHighlighting.localVariableDeclaration.color",
                      entry(theme.get("localVariableDeclaration")));
        putPreference("semanticHighlighting.localVariable.color",
                      entry(theme.get("localVariable")));
        putPreference("semanticHighlighting.typeParameter.color",
                      entry(theme.get("typeParameter")));
        putPreference("semanticHighlighting.parameterVariable.color",
                      entry(theme.get("parameterVariable")));
        putPreference("semanticHighlighting.macroDefinition.color",
                      entry(theme.get("methodDeclarationName")));
        putPreference("semanticHighlighting.methodDeclaration.color",
                      entry(theme.get("methodDeclarationName")));
        putPreference("semanticHighlighting.method.color",
                      entry(theme.get("method")));
        putPreference("semanticHighlighting.namespace.color",
                      entry(theme.get("interface")));
        putPreference("semanticHighlighting.staticMethod.color",
                      entry(theme.get("staticMethodInvocation")));
        putPreference("semanticHighlighting.staticField.color",
                      entry(theme.get("staticField")));
        putPreference("semanticHighlighting.typedef.color",
                      entry(theme.get("class")));
        putPreference("org.eclipse.cdt.internal.ui.text.doctools.multi",
                      entry(theme.get("javadoc")));
        putPreference("org.eclipse.cdt.internal.ui.text.doctools.single",
                      entry(theme.get("javadoc")));
        putPreference("org.eclipse.cdt.internal.ui.text.doctools.recognizedTag",
                      entry(theme.get("javadocTag")));
    }

    @Override
    protected void putDependentEntries(String key) {
        if ("semanticHighlighting.function.color".equals(key))
            preferences.putBoolean("semanticHighlighting.function.enabled",
                                   true);
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