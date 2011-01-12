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
        preferences.putBoolean("semanticHighlighting.function.enabled", false);
        preferences.putBoolean(
                "semanticHighlighting.localVariableDeclaration.enabled", false);
        preferences.putBoolean("semanticHighlighting.localVariable.enabled",
                               false);
        preferences.putBoolean("semanticHighlighting.macroDefinition.enabled",
                               false);
        preferences.putBoolean("semanticHighlighting.namespace.enabled", false);        
        preferences.putBoolean("semanticHighlighting.templateParameter.enabled",
                               false);
        
        putPreference("c_default", theme.get("foreground"));
        putPreference("c_braces", theme.get("bracket"));
        putPreference("c_type", theme.get("keyword"));
        putPreference("c_keyword", theme.get("keyword"));
        putPreference("c_numbers", theme.get("number"));
        putPreference("c_operators", theme.get("operator"));
        putPreference("c_string", theme.get("string"));
        putPreference("c_multi_line_comment", theme.get("multiLineComment"));
        putPreference("c_single_line_comment", theme.get("singleLineComment"));
        putPreference("c_comment_task_tag", theme.get("commentTaskTag"));
        putPreference("asm_directive", theme.get("keyword"));
        putPreference("asm_label", theme.get("foreground"));
        putPreference("pp_directive", theme.get("keyword"));
        putPreference("pp_header", theme.get("string"));
        putPreference("pp_default", theme.get("foreground"));
        putPreference("semanticHighlighting.class.color", theme.get("class"));
        putPreference("semanticHighlighting.enumerator.color",
                      theme.get("staticFinalField"));
        putPreference("semanticHighlighting.externalSDK.color",
                      theme.get("staticMethodInvocation"));
        putPreference("semanticHighlighting.field.color", theme.get("field"));
        putPreference("semanticHighlighting.functionDeclaration.color",
                      theme.get("methodDeclarationName"));
        putPreference("semanticHighlighting.function.color",
                      theme.get("staticMethodInvocation"));
        putPreference("semanticHighlighting.localVariableDeclaration.color",
                      theme.get("localVariableDeclaration"));
        putPreference("semanticHighlighting.localVariable.color",
                      theme.get("localVariable"));
        putPreference("semanticHighlighting.macroDefinition.color",
                      theme.get("methodDeclarationName"));
        putPreference("semanticHighlighting.methodDeclaration.color",
                      theme.get("methodDeclarationName"));
        putPreference("semanticHighlighting.method.color", theme.get("method"));
        putPreference("semanticHighlighting.namespace.color",
                      theme.get("class"));
        putPreference("semanticHighlighting.staticMethod.color",
                      theme.get("staticMethodInvocation"));
        putPreference("semanticHighlighting.staticField.color",
                      theme.get("staticField"));
        putPreference("semanticHighlighting.typedef.color", theme.get("class"));
        putPreference("org.eclipse.cdt.internal.ui.text.doctools.multi",
                      theme.get("javadoc"));
        putPreference("org.eclipse.cdt.internal.ui.text.doctools.single",
                      theme.get("javadoc"));
        putPreference("org.eclipse.cdt.internal.ui.text.doctools.recognizedTag",
                      theme.get("javadocTag"));
    }

    @Override
    protected void putDependentEntries(String key) {
        if ("semanticHighlighting.function.color".equals(key))
            preferences.putBoolean("semanticHighlighting.function.enabled",
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
    }

    @Override
    public void clear() {
        preferences.remove("semanticHighlighting.function.enabled");
        preferences.remove(
                "semanticHighlighting.localVariableDeclaration.enabled");
        preferences.remove("semanticHighlighting.localVariable.enabled");
        preferences.remove("semanticHighlighting.macroDefinition.enabled");
        preferences.remove("semanticHighlighting.namespace.enabled");
        preferences.remove("semanticHighlighting.templateParameter.enabled");
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
        preferences.remove("semanticHighlighting.typedef.color");
        preferences.remove("org.eclipse.cdt.internal.ui.text.doctools.multi");
        preferences.remove("org.eclipse.cdt.internal.ui.text.doctools.single");
        preferences.remove(
                "org.eclipse.cdt.internal.ui.text.doctools.recognizedTag");
    }        
}