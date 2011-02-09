package com.github.eclipsecolortheme.mapping;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.ColorThemeSetting;

public class ColorThemeWebMapping extends ColorThemeMapping {

	public ColorThemeWebMapping(String pluginKey, String themeKey) {
		super(pluginKey, themeKey);
	}

	@Override
	public void putPreferences(IEclipsePreferences preferences,
			ColorThemeSetting setting) {
		String value = setting.getColor().asHex() + " | null | "
				+ setting.isBoldEnabled() + " | " 
				+ setting.isItalicEnabled() + " | " 
				+ setting.isStrikethroughEnabled() + " | "
				+ setting.isUnderlineEnabled();
		preferences.put(pluginKey, value);
	}

}
