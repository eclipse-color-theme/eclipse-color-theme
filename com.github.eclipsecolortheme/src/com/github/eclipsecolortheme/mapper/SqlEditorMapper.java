package com.github.eclipsecolortheme.mapper;

import static com.github.eclipsecolortheme.ColorThemeKeys.*;

import java.util.Map;

/**
 * Maps color themes to preferences for Eclipse's SQL editor.
 * Based on Data Tools Platform 1.8.1
 */
public class SqlEditorMapper extends ThemePreferenceMapper {

	public SqlEditorMapper() {
		super("org.eclipse.datatools.sqltools.sqleditor");
	}
	
	@Override
	public void map(Map<String, String> theme) {
		putPreference("Type", entry(theme.get(CLASS)));
		putPreference("Keyword", entry(theme.get(KEYWORD)));
		putPreference("Double quoted string", entry(theme.get(STRING)));
		putPreference("Identifier", entry(theme.get(METHOD)));
		putPreference("Single quoted string", entry(theme.get(STRING)));
		putPreference("Single-line comment", entry(theme.get(SINGLE_LINE_COMMENT)));
		putPreference("Multi-line comment", entry(theme.get(MULTI_LINE_COMMENT)));
		putPreference("Others", entry(theme.get(FOREGROUND)));
	}

	@Override
	protected void putDependentEntries(String key) {
		// NOOP
	}

	@Override
	public void clear() {
		preferences.remove("Type");
		preferences.remove("Keyword");
		preferences.remove("Others");
		preferences.remove("Double quoted string");
		preferences.remove("Identifier");
		preferences.remove("Single quoted string");
		preferences.remove("Single-line comment");
		preferences.remove("Multi-line comment");
	}
	
	@Override
    protected String entry(String color) {
		String rgb = this.hexToRGB(color).replace(" ", "");
        return (color == null) ? null : "0,0,0,0,0," + rgb;
    }

}
