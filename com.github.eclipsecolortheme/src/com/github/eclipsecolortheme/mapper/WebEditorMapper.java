package com.github.eclipsecolortheme.mapper;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

/**
 * Maps color themes to preferences for Eclipse's XML, HTML and CSS editors.
 */
public class WebEditorMapper extends GenericMapper {
    
    @Override
    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
    	return new Mapping(pluginKey, themeKey);
    }
    
    private class Mapping extends ColorThemeMapping {

		public Mapping(String pluginKey, String themeKey) {
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
    
}
