package com.github.fhd.eclipsecolortheme.mapper;

import static com.github.fhd.eclipsecolortheme.ColorThemeKeys.*;

import java.util.Map;

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

        putPreference("java_default", entry(theme.get(FOREGROUND)));
        putPreference("java_single_line_comment",
                      entry(theme.get(SINGLE_LINE_COMMENT)));
        putPreference("java_multi_line_comment",
                      entry(theme.get(MULTI_LINE_COMMENT)));

        putPreference("java_comment_task_tag",
                      entry(theme.get(COMMENT_TASK_TAG)));
        putPreference("java_string", entry(theme.get(STRING)));
        putPreference("java_bracket", entry(theme.get(BRACKET)));
        putPreference("java_operator", entry(theme.get(OPERATOR)));
        putPreference("java_keyword_return", entry(theme.get(KEYWORD)));
        putPreference("java_keyword", entry(theme.get(KEYWORD)));
        putPreference("semanticHighlighting.methodDeclarationName.color",
                      entry(theme.get(METHOD_DECLARATION_NAME)));
        putPreference("java_doc_default", entry(theme.get(JAVADOC)));
        putPreference("java_doc_link", entry(theme.get(JAVADOC_LINK)));
        putPreference("java_doc_keyword", entry(theme.get(JAVADOC_KEYWORD)));
        putPreference("java_doc_tag", entry(theme.get(JAVADOC_TAG)));
        putPreference("semanticHighlighting.localVariable.color",
                      entry(theme.get(LOCAL_VARIABLE)));
        putPreference("semanticHighlighting.localVariableDeclaration.color",
                      entry(theme.get(LOCAL_VARIABLE_DECLARATION)));
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