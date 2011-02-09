package com.github.eclipsecolortheme.mapper;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;
import com.github.eclipsecolortheme.ColorThemeSemanticHighlightingMapping;


/**
 * Maps color themes to preferences for Eclipse's XML, HTML and CSS editors.
 */
public class WebEditorMapper extends GenericMapper {
    
    public WebEditorMapper(String pluginId) {
        super(pluginId);
    }
    
    @Override
    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
    	return new Mapping(pluginKey, themeKey);
    }
    
    @Override
    protected ColorThemeSemanticHighlightingMapping createSemanticHighlightingMapping(
    		String pluginKey, String themeKey) {
    	return new SemanticMapping(pluginKey, themeKey);
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
	
	private class SemanticMapping extends ColorThemeSemanticHighlightingMapping {
		
		public SemanticMapping(String pluginKey, String themeKey) {
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
    
}
