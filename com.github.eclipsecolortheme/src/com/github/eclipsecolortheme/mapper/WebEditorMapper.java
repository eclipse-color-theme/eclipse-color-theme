package com.github.eclipsecolortheme.mapper;

import com.github.eclipsecolortheme.mapping.ColorThemeMapping;
import com.github.eclipsecolortheme.mapping.ColorThemeSemanticHighlightingMapping;
import com.github.eclipsecolortheme.mapping.ColorThemeSemanticHighlightingWebMapping;
import com.github.eclipsecolortheme.mapping.ColorThemeWebMapping;

/**
 * Maps color themes to preferences for Eclipse's XML, HTML and CSS editors.
 */
public class WebEditorMapper extends GenericMapper {
    
    public WebEditorMapper(String pluginId) {
        super(pluginId);
    }
    
    @Override
    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
    	return new ColorThemeWebMapping(pluginKey, themeKey);
    }
    
    @Override
    protected ColorThemeSemanticHighlightingMapping createSemanticHighlightingMapping(
    		String pluginKey, String themeKey) {
    	return new ColorThemeSemanticHighlightingWebMapping(pluginKey, themeKey);
    }
    
}
