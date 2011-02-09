package com.github.eclipsecolortheme.mapper;

import com.github.eclipsecolortheme.ColorThemeMapping;


/**
 * Maps color themes to preferences for Eclipse's XML, HTML and CSS editors.
 */
public class WebEditorMapper extends GenericMapper {
    
    public WebEditorMapper(String pluginId) {
        super(pluginId);
    }
    
    @Override
    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
    	return new WebMapping(pluginKey, themeKey);
    }
    
    @Override
    protected SemanticHighlightingMapping createSemanticHighlightingMapping(
    		String pluginKey, String themeKey) {
    	return new SemanticHighlightingWebMapping(pluginKey, themeKey);
    }
    
}
