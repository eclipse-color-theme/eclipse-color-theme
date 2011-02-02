package com.github.eclipsecolortheme.mapper;


/**
 * Maps color themes to preferences for Eclipse's SQL editor.
 * Based on Data Tools Platform 1.8.1
 */
public class SqlEditorMapper extends GenericMapper {

	public SqlEditorMapper() {
		super("org.eclipse.datatools.sqltools.sqleditor");
	}
	
	@Override
    protected String entry(String color) {
		String rgb = this.hexToRGB(color).replace(" ", "");
        return (color == null) ? null : "0,0,0,0,0," + rgb;
    }

}
