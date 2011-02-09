package com.github.eclipsecolortheme.mapping;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.Color;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class ColorThemeMapping {
	
	protected String pluginKey;
	protected String themeKey;

	public ColorThemeMapping(String pluginKey, String themeKey) {
		this.pluginKey = pluginKey;
		this.themeKey = themeKey;
	}
	
	public void putPreferences(IEclipsePreferences preferences, ColorThemeSetting setting) {
		Color color = setting.getColor();
		preferences.put(pluginKey, color.toString());
	}

	public void removePreferences(IEclipsePreferences preferences) {
		preferences.remove(pluginKey);
	}

	public Object getThemeKey() {
		return themeKey;
	}
	
}
