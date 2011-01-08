package com.github.fhd.eclipsecolortheme.themepreferencemapper;

import java.util.*;

/** Maps color themes to preferences for Eclipse's JavaScript editor. */
public class JavaScriptEditorMapper extends ThemePreferenceMapper {
    /** Creates a new color theme mapper. */
    public JavaScriptEditorMapper() {
        super("org.eclipse.wst.jsdt.ui");
    }

    @Override
    public void map(Map<String, String> theme) {
        preferences.putBoolean(
                "semanticHighlighting.methodDeclarationName.enabled", false);
        preferences.putBoolean("semanticHighlighting.localVariable.enabled",
                               false);
        preferences.putBoolean(
                "semanticHighlighting.localVariableDeclaration.enabled", false);

        putPreference("java_default", theme.get("foreground"));
        putPreference("java_single_line_comment",
                      theme.get("singleLineComment"));
        putPreference("java_multi_line_comment", theme.get("multiLineComment"));

        putPreference("java_comment_task_tag", theme.get("commentTaskTag"));
        putPreference("java_string", theme.get("string"));
        putPreference("java_bracket", theme.get("bracket"));
        putPreference("java_operator", theme.get("operator"));
        putPreference("java_keyword_return", theme.get("keyword"));
        putPreference("java_keyword", theme.get("keyword"));
        putPreference("semanticHighlighting.methodDeclarationName.color",
                      theme.get("methodDeclarationName"));
        putPreference("java_doc_default", theme.get("javadoc"));
        putPreference("java_doc_link", theme.get("javadocLink"));
        putPreference("java_doc_keyword", theme.get("javadocKeyword"));
        putPreference("java_doc_tag", theme.get("javadocTag"));
        putPreference("semanticHighlighting.localVariable.color",
                      theme.get("localVariable"));
        putPreference("semanticHighlighting.localVariableDeclaration.color",
                      theme.get("localVariableDeclaration"));
    }

    @Override
    protected void putDependentEntries(String key) {
        if ("semanticHighlighting.methodDeclarationName.color".equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.methodDeclarationName.enabled", true);
        else if ("semanticHighlighting.localVariable.color".equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.localVariable.enabled", true);
        else if ("semanticHighlighting.localVariableDeclaration.color"
                         .equals(key))
            preferences.putBoolean(
                    "semanticHighlighting.localVariableDeclaration.enabled",
                    true);
    }

    @Override
    public void clear() {
        preferences.remove(
                "semanticHighlighting.methodDeclarationName.enabled");
        preferences.remove("semanticHighlighting.localVariable.enabled");
        preferences.remove(
                "semanticHighlighting.localVariableDeclaration.enabled");
        preferences.remove("java_default");
        preferences.remove("java_single_line_comment");
        preferences.remove("java_multi_line_comment");
        preferences.remove("java_comment_task_tag");
        preferences.remove("java_string");
        preferences.remove("java_bracket");
        preferences.remove("java_operator");
        preferences.remove("java_keyword_return");
        preferences.remove("java_keyword");
        preferences.remove("semanticHighlighting.methodDeclarationName.color");
        preferences.remove("java_doc_default");
        preferences.remove("java_doc_link");
        preferences.remove("java_doc_keyword");
        preferences.remove("java_doc_tag");
        preferences.remove("semanticHighlighting.localVariable.color");
        preferences.remove(
                "semanticHighlighting.localVariableDeclaration.color");
    }        
}