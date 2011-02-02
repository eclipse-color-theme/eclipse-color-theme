package com.github.eclipsecolortheme.mapper;


/**
 * Maps color themes to preferences for Eclipse's XML, HTML and CSS editors.
 */
public class WebEditorMapper extends GenericMapper {
    
    public WebEditorMapper(String pluginId) {
        super(pluginId);
    }

    @Override
    protected String entry(String color) {
        return (color == null) ? null 
                               : color.toLowerCase()
                                 + " | null | false | false | false | false";
    }
    
}
