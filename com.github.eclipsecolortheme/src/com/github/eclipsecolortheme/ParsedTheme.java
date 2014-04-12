package com.github.eclipsecolortheme;

public class ParsedTheme {
    private ColorTheme theme;
    private String source;

    public ParsedTheme() {
        this(null, null);
    }

    public ParsedTheme(ColorTheme theme) {
        this(theme, null);
    }

    public ParsedTheme(ColorTheme theme, String source) {
        this.theme = theme;
        this.source = source;
    }

    public ColorTheme getTheme() {
        return theme;
    }

    public ParsedTheme setTheme(ColorTheme theme) {
        this.theme = theme;
        return this;
    }

    public String getSource() {
        return source;
    }

    public ParsedTheme setSource(String source) {
        this.source = source;
        return this;
    }
}
