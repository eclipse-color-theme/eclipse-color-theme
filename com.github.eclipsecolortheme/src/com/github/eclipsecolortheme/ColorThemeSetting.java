package com.github.eclipsecolortheme;

public class ColorThemeSetting {

	private Color color;
	private Boolean boldEnabled;
	private Boolean italicEnabled;
	private Boolean underlineEnabled;
	private Boolean strikethroughEnabled;

	public ColorThemeSetting(String color) {
		this.color = new Color(color);
	}

	public void setBoldEnabled(Boolean boldEnabled) {
		this.boldEnabled = boldEnabled;
	}
	
	public void setItalicEnabled(Boolean italicEnabled) {
		this.italicEnabled = italicEnabled;
	}
	
	public void setStrikethroughEnabled(Boolean strikethroughEnabled) {
		this.strikethroughEnabled = strikethroughEnabled;
	}
	
	public void setUnderlineEnabled(Boolean underlineEnabled) {
		this.underlineEnabled = underlineEnabled;
	}
	
	public Color getColor() {
		return color;
	}

	public Boolean isBoldEnabled() {
		return boldEnabled;
	}

	public Boolean isItalicEnabled() {
		return italicEnabled;
	}

	public Boolean isUnderlineEnabled() {
		return underlineEnabled;
	}

	public Boolean isStrikethroughEnabled() {
		return strikethroughEnabled;
	}

}
