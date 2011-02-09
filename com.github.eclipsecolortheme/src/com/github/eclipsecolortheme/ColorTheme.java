package com.github.eclipsecolortheme;

import java.util.Map;

public class ColorTheme {
    private String name;
    private String author;
    private Map<String, ColorThemeSetting> entries;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public Map<String, ColorThemeSetting> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, ColorThemeSetting> entries) {
        this.entries = entries;
    }
}