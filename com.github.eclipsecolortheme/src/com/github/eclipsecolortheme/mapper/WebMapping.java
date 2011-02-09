package com.github.eclipsecolortheme.mapper;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class WebMapping extends ColorThemeMapping {

	public WebMapping(String pluginKey, String themeKey) {
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
