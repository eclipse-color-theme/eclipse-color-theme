package com.github.eclipsecolortheme.mapper;

import com.github.eclipsecolortheme.mapping.ColorThemeMapping;
import com.github.eclipsecolortheme.mapping.ColorThemeSqlMapping;

/**
 * Maps color themes to preferences for Eclipse's SQL editor.
 * Based on Data Tools Platform 1.8.1
 */
public class SqlEditorMapper extends GenericMapper {

	public SqlEditorMapper() {
		super("org.eclipse.datatools.sqltools.sqleditor");
	}
	
	@Override
    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
    	return new ColorThemeSqlMapping(pluginKey, themeKey);
    }

}
