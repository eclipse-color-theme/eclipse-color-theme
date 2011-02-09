package com.github.eclipsecolortheme.mapper;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class SemanticHighlightingMapping extends ColorThemeMapping {

	public SemanticHighlightingMapping(String pluginKey,
			String themeKey) {
		super(pluginKey, themeKey);
	}
	
	@Override
	public void putPreferences(IEclipsePreferences preferences,
			ColorThemeSetting setting) {
		preferences.putBoolean(pluginKey + ".enabled", true);
		preferences.put(pluginKey + ".color", setting.getColor().asRGB());
		if (setting.isBoldEnabled() != null)
			preferences.putBoolean(pluginKey + ".bold", setting.isBoldEnabled());
		if (setting.isItalicEnabled() != null)
			preferences.putBoolean(pluginKey + ".italic", setting.isItalicEnabled());
		if (setting.isUnderlineEnabled() != null)
			preferences.putBoolean(pluginKey + ".underline", setting.isUnderlineEnabled());
		if (setting.isStrikethroughEnabled() != null)
			preferences.putBoolean(pluginKey + ".strikethrough", setting.isStrikethroughEnabled());
	}

	public void removePreferences(IEclipsePreferences preferences) {
		preferences.remove(pluginKey + ".enabled");
        preferences.remove(pluginKey + ".color");
    	preferences.remove(pluginKey + ".bold");
    	preferences.remove(pluginKey + ".italic");
    	preferences.remove(pluginKey + ".underline");
    	preferences.remove(pluginKey + ".strikethrough");
	}
	
}
