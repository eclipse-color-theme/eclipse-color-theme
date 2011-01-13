package com.github.fhd.eclipsecolortheme.mapper;

import java.util.*;

/** Maps color themes to preferences for Eclipse's Java editor. */
public class JavaEditorMapper extends ThemePreferenceMapper {
    /** Creates a new color theme mapper. */
    public JavaEditorMapper() {
        super("org.eclipse.jdt.ui");
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
        preferences.putBoolean("semanticHighlighting.localVariable.enabled",
                               false);
        preferences.putBoolean(
                "semanticHighlighting.localVariableDeclaration.enabled", false);

        putPreference("java_default", entry(theme.get("foreground")));
        putPreference("java_single_line_comment",
                      entry(theme.get("singleLineComment")));
        putPreference("java_multi_line_comment",
                      entry(theme.get("multiLineComment")));
        putPreference("java_comment_task_tag",
                      entry(theme.get("commentTaskTag")));
        putPreference("sourceHoverBackgroundColor",
                      entry(theme.get("sourceHoverBackground")));
        putPreference("semanticHighlighting.number.color",
                      entry(theme.get("number")));
        putPreference("java_string", entry(theme.get("string")));
        putPreference("java_bracket", entry(theme.get("bracket")));
        putPreference("java_operator", entry(theme.get("operator")));
        putPreference("java_keyword_return", entry(theme.get("keyword")));
        putPreference("java_keyword", entry(theme.get("keyword")));
        putPreference("semanticHighlighting.class.color",
                      entry(theme.get("class")));
        putPreference("semanticHighlighting.interface.color",
                      entry(theme.get("interface")));
        putPreference("semanticHighlighting.enum.color",
                      entry(theme.get("enum")));
        putPreference("semanticHighlighting.method.color",
                      entry(theme.get("method")));
        putPreference("semanticHighlighting.methodDeclarationName.color",
                      entry(theme.get("methodDeclarationName")));
        putPreference("semanticHighlighting.annotation.color",
                      entry(theme.get("annotation")));
        putPreference("java_doc_default", entry(theme.get("javadoc")));
        putPreference("java_doc_link", entry(theme.get("javadocLink")));
        putPreference("java_doc_keyword", entry(theme.get("javadocKeyword")));
        putPreference("java_doc_tag", entry(theme.get("javadocTag")));
        putPreference("semanticHighlighting.localVariable.color",
                      entry(theme.get("localVariable")));
        putPreference("semanticHighlighting.inheritedMethodInvocation.color",
                      entry(theme.get("inheritedMethodInvocation")));
        putPreference("semanticHighlighting.abstractMethodInvocation.color",
                      entry(theme.get("abstractMethodInvocation")));
        putPreference("semanticHighlighting.localVariableDeclaration.color",
                      entry(theme.get("localVariableDeclaration")));
        putPreference("semanticHighlighting.typeArgument.color",
                      entry(theme.get("typeArgument")));
        putPreference("semanticHighlighting.typeParameter.color",
                      entry(theme.get("typeParameter")));
        putPreference("semanticHighlighting.parameterVariable.color",
                      entry(theme.get("parameterVariable")));
        putPreference("semanticHighlighting.staticFinalField.color",
                      entry(theme.get("staticFinalField")));
    }

    @Override
    protected void putDependentEntries(String key) {
        if ("semanticHighlighting.class.color".equals(key))
            preferences.putBoolean("semanticHighlighting.class.enabled", true);
        else if ("semanticHighlighting.staticField.color".equals(key))
            preferences.putBoolean("semanticHighlighting.staticField.enabled",
                                   true);
        else if ("semanticHighlighting.interface.color".equals(key))
            preferences.putBoolean("semanticHighlighting.interface.enabled",
                                   true);
        else if ("semanticHighlighting.enum.color".equals(key))
            preferences.putBoolean("semanticHighlighting.enum.enabled",
                                   true);
        else if ("semanticHighlighting.staticMethodInvocation.color"
                .equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.staticMethodInvocation.enabled",
                    true);
        else if ("semanticHighlighting.method.color".equals(key))
            preferences.putBoolean("semanticHighlighting.method.enabled", true);
        else if ("semanticHighlighting.methodDeclarationName.color".equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.methodDeclarationName.enabled", true);
        else if ("semanticHighlighting.annotation.color".equals(key))
            preferences.putBoolean("semanticHighlighting.annotation.enabled",
                                   true);
        else if ("semanticHighlighting.field.color".equals(key))
            preferences.putBoolean("semanticHighlighting.field.enabled", true);
        else if ("semanticHighlighting.deprecatedMember.color".equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.deprecatedMember.enabled", true);
        else if ("semanticHighlighting.number.color".equals(key))
            preferences.putBoolean("semanticHighlighting.number.enabled", true);
        else if ("semanticHighlighting.inheritedMethodInvocation.color"
                         .equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.inheritedMethodInvocation.enabled",
                    true);
        else if ("semanticHighlighting.abstractMethodInvocation.color"
                         .equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.abstractMethodInvocation.enabled",
                    true);
        else if ("semanticHighlighting.localVariable.color".equals(key))
            preferences.putBoolean("semanticHighlighting.localVariable.enabled",
                                   true);
        else if ("semanticHighlighting.localVariableDeclaration.color"
                .equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.localVariableDeclaration.enabled",
                    true);
        else if ("semanticHighlighting.typeArgument.color".equals(key))
            preferences.putBoolean("semanticHighlighting.typeArgument.enabled",
                                   true);
        else if ("semanticHighlighting.typeParameter.color".equals(key))
            preferences.putBoolean("semanticHighlighting.typeParameter.enabled",
                                   true);
        else if ("semanticHighlighting.parameterVariable.color".equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.parameterVariable.enabled",
                    true);
    }

    @Override
    public void clear() {
        preferences.remove("semanticHighlighting.class.enabled");
        preferences.remove("semanticHighlighting.staticField.enabled");
        preferences.remove("semanticHighlighting.interface.enabled");
        preferences.remove("semanticHighlighting.enum.enabled");
        preferences.remove(
                "semanticHighlighting.staticMethodInvocation.enabled");
        preferences.remove("semanticHighlighting.method.enabled");
        preferences.remove(
                "semanticHighlighting.methodDeclarationName.enabled");
        preferences.remove("semanticHighlighting.annotation.enabled");
        preferences.remove("semanticHighlighting.field.enabled");
        preferences.remove("semanticHighlighting.deprecatedMember.enabled");
        preferences.remove("semanticHighlighting.number.enabled");
        preferences.remove("semanticHighlighting.localVariable.enabled");
        preferences.remove(
                "semanticHighlighting.localVariableDeclaration.enabled");
        preferences.remove("semanticHighlighting.methodDeclarationName.bold");
        preferences.remove("java_default");
        preferences.remove("java_single_line_comment");
        preferences.remove("java_multi_line_comment");
        preferences.remove("java_comment_task_tag");
        preferences.remove("sourceHoverBackgroundColor");
        preferences.remove("semanticHighlighting.number.color");
        preferences.remove("java_string");
        preferences.remove("java_bracket");
        preferences.remove("java_operator");
        preferences.remove("java_keyword_return");
        preferences.remove("java_keyword");
        preferences.remove("semanticHighlighting.class.color");
        preferences.remove("semanticHighlighting.interface.color");
        preferences.remove("semanticHighlighting.method.color");
        preferences.remove("semanticHighlighting.methodDeclarationName.color");
        preferences.remove("java_doc_default");
        preferences.remove("java_doc_link");
        preferences.remove("java_doc_keyword");
        preferences.remove("java_doc_tag");
        preferences.remove(
                "semanticHighlighting.inheritedMethodInvocation.color");
        preferences.remove(
                "semanticHighlighting.abstractMethodInvocation.color");
        preferences.remove("semanticHighlighting.localVariable.color");
        preferences.remove(
                "semanticHighlighting.localVariableDeclaration.color");
        preferences.remove("semanticHighlighting.staticFinalField.color");
        preferences.remove("semanticHighlighting.typeArgument.color");
        preferences.remove("semanticHighlighting.typeParameter.color");
        preferences.remove("semanticHighlighting.parameterVariable.color");
    }        
}