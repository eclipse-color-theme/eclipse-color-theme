package com.github.fhd.eclipsecolortheme.mapper;

import java.util.Map;

/**
 * Maps color themes to preferences for Eclipse's PHP editor.
 * Based on PDT 2.1.1
 */
public class PhpEditorMapper extends ThemePreferenceMapper {

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
	}

	@Override
	protected void putDependentEntries(String key) {
		// NOOP
	}

}
