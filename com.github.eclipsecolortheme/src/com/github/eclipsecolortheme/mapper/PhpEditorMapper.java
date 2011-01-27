package com.github.eclipsecolortheme.mapper;

import static com.github.eclipsecolortheme.ColorThemeKeys.*;

import java.util.Map;

/**
 * Maps color themes to preferences for Eclipse's PHP editor.
 * Based on PDT 2.2.1
 */
public class PhpEditorMapper extends ThemePreferenceMapper {

	private String basePath = "semanticHighlighting.org.eclipse.php.internal.ui.editor.highlighters.";
	
	public PhpEditorMapper() {
		super("org.eclipse.php.ui");
	}

	@Override
	public void clear() {
		preferences.remove("codeStyleNormal");
		preferences.remove("editorColorKeyword");
		preferences.remove("editorColorBoundarymaker");
		preferences.remove("editorColorNumber");
		preferences.remove("editorColorComment");
		preferences.remove("editorColorPhpdoc");
		preferences.remove("editorColorHeredoc");
		preferences.remove("editorColorVariable");
		preferences.remove("editorColorString");
		preferences.remove("editorColorTask");
		// since PDT 2.2.1
		preferences.remove("editorColorLineComment");
		preferences.remove("editorColorPhpdocComment");
		preferences.remove(basePath + "InternalFunctionHighlighting.color");
		preferences.remove(basePath + "InternalConstantHighlighting.color");
		preferences.remove(basePath + "InternalClassHighlighting.color");
		preferences.remove(basePath + "ConstantHighlighting.color");
		preferences.remove(basePath + "FieldHighlighting.color");
		preferences.remove(basePath + "StaticFieldHighlighting.color");
		preferences.remove(basePath + "StaticMethodHighlighting.color");
		preferences.remove(basePath + "ClassHighlighting.color");
		preferences.remove(basePath + "ParameterVariableHighlighting.color");
		preferences.remove(basePath + "SuperGlobalHighlighting.color");
		preferences.remove(basePath + "MethodHighlighting.color");
		preferences.remove(basePath + "FunctionHighlighting.color");
		preferences.remove(basePath + "DeprecatedHighlighting.color");
	}

	@Override
	public void map(Map<String, String> theme) {
		putPreference("codeStyleNormal", entry(theme.get(FOREGROUND)));
		putPreference("editorColorKeyword", entry(theme.get(KEYWORD)));
		putPreference("editorColorBoundarymaker", entry(theme.get(FOREGROUND)));
		putPreference("editorColorNumber", entry(theme.get(NUMBER)));
		putPreference("editorColorComment", entry(theme.get(MULTI_LINE_COMMENT)));
		putPreference("editorColorPhpdoc", entry(theme.get(JAVADOC)));
		putPreference("editorColorHeredoc", entry(theme.get(JAVADOC)));
		putPreference("editorColorVariable", entry(theme.get(LOCAL_VARIABLE)));
		putPreference("editorColorString", entry(theme.get(STRING)));
		putPreference("editorColorTask", entry(theme.get(COMMENT_TASK_TAG)));
		// since PDT 2.2.1
		putPreference("editorColorLineComment", entry(theme.get(SINGLE_LINE_COMMENT)));
		putPreference("editorColorPhpdocComment", entry(theme.get(JAVADOC)));
		putPreference(basePath + "InternalFunctionHighlighting.color", entry(theme.get(METHOD)));
		putPreference(basePath + "InternalConstantHighlighting.color", entry(theme.get(STATIC_FINAL_FIELD)));
		putPreference(basePath + "InternalClassHighlighting.color", entry(theme.get(CLASS)));
		putPreference(basePath + "ConstantHighlighting.color", entry(theme.get(STATIC_FINAL_FIELD)));
		putPreference(basePath + "FieldHighlighting.color", entry(theme.get(FIELD)));
		putPreference(basePath + "StaticFieldHighlighting.color", entry(theme.get(STATIC_FIELD)));
		putPreference(basePath + "StaticMethodHighlighting.color", entry(theme.get(METHOD)));
		putPreference(basePath + "ClassHighlighting.color", entry(theme.get(CLASS)));
		putPreference(basePath + "ParameterVariableHighlighting.color", entry(theme.get(PARAMETER_VARIABLE)));
		putPreference(basePath + "SuperGlobalHighlighting.color", entry(theme.get(LOCAL_VARIABLE)));
		putPreference(basePath + "MethodHighlighting.color", entry(theme.get(METHOD)));
		putPreference(basePath + "FunctionHighlighting.color", entry(theme.get(METHOD)));
		putPreference(basePath + "DeprecatedHighlighting.color", entry(theme.get(DEPRECATED_MEMBER)));
		
		
		
	}

	@Override
	protected void putDependentEntries(String key) {
		if ((basePath + "InternalFunctionHighlighting.color").equals(key)) {
			preferences.putBoolean(basePath + "InternalFunctionHighlighting.enabled", true);
		} else if ((basePath + "ConstantHighlighting.color").equals(key)) {
			preferences.putBoolean(basePath + "ConstantHighlighting.enabled", true);
		} else if ((basePath + "ClassHighlighting.color").equals(key)) {
			preferences.putBoolean(basePath + "ClassHighlighting.enabled", true);
		} else if ((basePath + "InternalClassHighlighting.color").equals(key)) {
			preferences.putBoolean(basePath + "InternalClassHighlighting.enabled", true);
		} else if ((basePath + "FunctionHighlighting.color").equals(key)) {
			preferences.putBoolean(basePath + "FunctionHighlighting.enabled", true);
		} else if ((basePath + "SuperGlobalHighlighting.color").equals(key)) {
			preferences.putBoolean(basePath + "SuperGlobalHighlighting.enabled", true);
		} else if ((basePath + "MethodHighlighting.color").equals(key)) {
			preferences.putBoolean(basePath + "MethodHighlighting.enabled", true);
		} else if ((basePath + "ParameterVariableHighlighting.color").equals(key)) {
			preferences.putBoolean(basePath + "ParameterVariableHighlighting.enabled", true);
		} else if ((basePath + "InternalConstantHighlighting.color").equals(key)) {
			preferences.putBoolean(basePath + "InternalConstantHighlighting.enabled", true);
		}
	}
	
	@Override
    protected String entry(String color) {
        return (color == null) ? null 
                               : color.toLowerCase()
                                 + " | null | false | false | false | false";
    }

}
