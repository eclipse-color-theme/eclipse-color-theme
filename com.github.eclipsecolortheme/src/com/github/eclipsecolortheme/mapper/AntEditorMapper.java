package com.github.eclipsecolortheme.mapper;

import static com.github.eclipsecolortheme.ColorThemeKeys.*;

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
		putPreference(basePath + "textColor", entry(theme.get(FOREGROUND)));
		putPreference(basePath + "tagsColor", entry(theme.get(METHOD)));
		putPreference(basePath + "dtdColor", entry(theme.get(METHOD)));
		putPreference(basePath + "commentsColor", entry(theme.get(MULTI_LINE_COMMENT)));
		putPreference(basePath + "constantStringsColor", entry(theme.get(STRING)));
		putPreference(basePath + "processingInstructionsColor", entry(theme.get(FOREGROUND)));
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
