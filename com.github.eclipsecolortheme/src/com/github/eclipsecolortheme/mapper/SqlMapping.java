package com.github.eclipsecolortheme.mapper;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class SqlMapping extends ColorThemeMapping {

	public SqlMapping(String pluginKey, String themeKey) {
		super(pluginKey, themeKey);
	}
	
	@Override
	public void putPreferences(IEclipsePreferences preferences,
			ColorThemeSetting setting) {
		// TODO: Add support for bold, italic, etc.
		String value = "0,0,0,0,0," + setting.getColor().asRGB();
		preferences.put(pluginKey, value);
	}

}
