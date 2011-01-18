package com.github.fhd.eclipsecolortheme.mapper;

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
		putPreference("codeStyleNormal", entry(theme.get("foreground")));
		putPreference("editorColorKeyword", entry(theme.get("keyword")));
		putPreference("editorColorBoundarymaker", entry(theme.get("foreground")));
		putPreference("editorColorNumber", entry(theme.get("number")));
		putPreference("editorColorComment", entry(theme.get("multiLineComment")));
		putPreference("editorColorPhpdoc", entry(theme.get("javadoc")));
		putPreference("editorColorHeredoc", entry(theme.get("javadoc")));
		putPreference("editorColorVariable", entry(theme.get("localVariable")));
		putPreference("editorColorString", entry(theme.get("string")));
		putPreference("editorColorTask", entry(theme.get("commentTaskTag")));
		// since PDT 2.2.1
		putPreference("editorColorLineComment", entry(theme.get("singleLineComment")));
		putPreference("editorColorPhpdocComment", entry(theme.get("javadoc")));
		putPreference(basePath + "InternalFunctionHighlighting.color", entry(theme.get("method")));
		putPreference(basePath + "InternalConstantHighlighting.color", entry(theme.get("staticFinalField")));
		putPreference(basePath + "InternalClassHighlighting.color", entry(theme.get("class")));
		putPreference(basePath + "ConstantHighlighting.color", entry(theme.get("staticFinalField")));
		putPreference(basePath + "FieldHighlighting.color", entry(theme.get("field")));
		putPreference(basePath + "StaticFieldHighlighting.color", entry(theme.get("staticField")));
		putPreference(basePath + "StaticMethodHighlighting.color", entry(theme.get("method")));
		putPreference(basePath + "ClassHighlighting.color", entry(theme.get("class")));
		putPreference(basePath + "ParameterVariableHighlighting.color", entry(theme.get("parameterVariable")));
		putPreference(basePath + "SuperGlobalHighlighting.color", entry(theme.get("variable")));
		putPreference(basePath + "MethodHighlighting.color", entry(theme.get("method")));
		putPreference(basePath + "FunctionHighlighting.color", entry(theme.get("method")));
		putPreference(basePath + "DeprecatedHighlighting.color", entry(theme.get("deprecatedMember")));
		
		
		
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

}
