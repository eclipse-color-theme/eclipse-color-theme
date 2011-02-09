package com.github.eclipsecolortheme.mapping;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.ColorThemeSetting;

public class ColorThemeSqlMapping extends ColorThemeMapping {

	public ColorThemeSqlMapping(String pluginKey, String themeKey) {
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
