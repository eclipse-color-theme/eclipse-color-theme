package com.github.eclipsecolortheme.mapping;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.ColorThemeSetting;

public class ColorThemeSemanticHighlightingWebMapping extends
		ColorThemeSemanticHighlightingMapping {

	public ColorThemeSemanticHighlightingWebMapping(String pluginKey,
			String themeKey) {
		super(pluginKey, themeKey);
	}
	
	@Override
	public void putPreferences(IEclipsePreferences preferences,
			ColorThemeSetting setting) {
		preferences.putBoolean(pluginKey + ".enabled", true);
		preferences.put(pluginKey + ".color", setting.getColor().asHex());
		if (setting.isBoldEnabled() != null)
			preferences.putBoolean(pluginKey + ".bold", setting.isBoldEnabled());
		if (setting.isItalicEnabled() != null)
			preferences.putBoolean(pluginKey + ".italic", setting.isItalicEnabled());
		if (setting.isUnderlineEnabled() != null)
			preferences.putBoolean(pluginKey + ".underline", setting.isUnderlineEnabled());
		if (setting.isStrikethroughEnabled() != null)
			preferences.putBoolean(pluginKey + ".strikethrough", setting.isStrikethroughEnabled());
	}

}
