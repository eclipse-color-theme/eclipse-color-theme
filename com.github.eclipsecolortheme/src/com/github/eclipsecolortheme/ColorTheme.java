package com.github.eclipsecolortheme;

import java.util.Map;

public class ColorTheme {
    private String id;
    private String name;
    private String author;
    private String website;
    private Map<String, ColorThemeSetting> entries;
    private Map<String, Map<String, ColorThemeMapping>> mappings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Map<String, ColorThemeSetting> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, ColorThemeSetting> entries) {
        this.entries = entries;
    }

    public Map<String, Map<String, ColorThemeMapping>> getMappings() {
        return mappings;
    }

    public void setMappings(Map<String, Map<String, ColorThemeMapping>> mappings) {
        this.mappings = mappings;
    }
}
