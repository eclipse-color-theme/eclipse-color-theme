package com.github.fhd.eclipsecolortheme.mapper;

import java.util.Map;

/**
 * Maps color themes to preferences for Eclipse's Ant editor.
 * Based on org.eclipse.ant.ui 3.5.0
 */
public class AntEditorMapper extends ThemePreferenceMapper {

	private String basePath = "org.eclipse.ant.ui.";
	
	public AntEditorMapper() {
		super("org.eclipse.ant.ui");
	}
	
	@Override
	public void map(Map<String, String> theme) {
		putPreference(basePath + "textColor", entry(theme.get("foreground")));
		putPreference(basePath + "tagsColor", entry(theme.get("method")));
		putPreference(basePath + "dtdColor", entry(theme.get("method")));
		putPreference(basePath + "commentsColor", entry(theme.get("multiLineComment")));
		putPreference(basePath + "constantStringsColor", entry(theme.get("string")));
		putPreference(basePath + "processingInstructionsColor", entry(theme.get("foreground")));
	}

	@Override
	protected void putDependentEntries(String key) {
		// NOOP
	}

	@Override
	public void clear() {
		preferences.remove(basePath + "textColor");
		preferences.remove(basePath + "tagsColor");
		preferences.remove(basePath + "dtdColor");
		preferences.remove(basePath + "commentsColor");
		preferences.remove(basePath + "constantStringsColor");
		preferences.remove(basePath + "processingInstructionsColor");

	}

}
