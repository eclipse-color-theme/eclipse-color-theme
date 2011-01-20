package com.github.fhd.eclipsecolortheme.mapper;

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
		putPreference("Type", entry(theme.get("class")));
		putPreference("Keyword", entry(theme.get("keyword")));
		putPreference("Double quoted string", entry(theme.get("string")));
		putPreference("Identifier", entry(theme.get("method")));
		putPreference("Single quoted string", entry(theme.get("string")));
		putPreference("Single-line comment", entry(theme.get("singleLineComment")));
		putPreference("Multi-line comment", entry(theme.get("multiLineComment")));
		putPreference("Others", entry(theme.get("foreground")));
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
