package com.github.fhd.eclipsecolortheme.themepreferencemapper;

import java.util.*;

/**
 * Maps color themes to preferences for Eclipse's XML, HTML and CSS editors.
 */
public class WebEditorMapper extends ThemePreferenceMapper {
    public enum Type {
        XML("org.eclipse.wst.xml.ui"),
        HTML("org.eclipse.wst.html.ui"),
        CSS("org.eclipse.wst.css.ui");

        private String plugin;

        private Type(String plugin) {
            this.plugin = plugin;
        }

        public String getPlugin() {
            return plugin;
        }
    }

    private Type editorType;
    
    public WebEditorMapper(Type editorType) {
        super(editorType.getPlugin());
        this.editorType = editorType;
    }

    @Override
    public void map(Map<String, String> theme) {
        switch (editorType) {
        case XML:
        case HTML:
            putPreference("tagBorder", entry(theme.get("method")));
            putPreference("tagName", entry(theme.get("method")));
            putPreference("tagAttributeName", entry(theme.get("field")));
            putPreference("tagAttributeEquals",
                          entry(theme.get("foreground")));
            putPreference("tagAttributeValue",
                          italicEntry(theme.get("string")));
            putPreference("xmlContent", entry(theme.get("foreground")));
            putPreference("commentBorder",
                          entry(theme.get("multiLineComment")));
            putPreference("commentText", entry(theme.get("multiLineComment")));
            putPreference("entityReference", entry(theme.get("keyword")));
            putPreference("doctypeName", entry(theme.get("method")));
            putPreference("doctypeExternalPubref", entry(theme.get("method")));
            putPreference("doctypeExtrenalSysref", entry(theme.get("method")));
            putPreference("doctypeExternalId",
                          entry(theme.get("staticFinalField")));
            if (Type.XML.equals(editorType)) {
                putPreference("declBorder", entry(theme.get("method")));
                putPreference("cdataBorder", entry(theme.get("method")));
                putPreference("cdataText", entry(theme.get("foreground")));
                putPreference("piBorder", entry(theme.get("method")));
                putPreference("piContent", entry(theme.get("foreground")));
            } else if (Type.HTML.equals(editorType))
                putPreference("declBoder", entry(theme.get("method")));
            break;
        case CSS:
            putPreference("PROPERTY_NAME", entry(theme.get("field")));
            putPreference("CLASS", italicEntry(theme.get("method")));
            putPreference("ATTRIBUTE_VALUE", entry(theme.get("method")));
            putPreference("UNIVERSAL", entry(theme.get("method")));
            putPreference("COMBINATOR", entry(theme.get("method")));
            putPreference("SEMI_COLON", entry(theme.get("foreground")));
            putPreference("ATTRIBUTE_DELIM", entry(theme.get("method")));
            putPreference("SELECTOR", boldEntry(theme.get("method")));
            putPreference("URI", italicEntry(theme.get("string")));
            putPreference("ATTRIBUTE_NAME", entry(theme.get("method")));
            putPreference("COLON", entry(theme.get("foreground")));
            putPreference("ID", italicEntry(theme.get("method")));
            putPreference("NORMAL", entry(theme.get("foreground")));
            putPreference("STRING", italicEntry(theme.get("string")));
            putPreference("CURLY_BRACE", entry(theme.get("bracket")));
            putPreference("PSEUDO", italicEntry(theme.get("method")));
            putPreference("COMMENT", entry(theme.get("multiLineComment")));
            putPreference("PROPERTY_VALUE", italicEntry(theme.get("string")));
            putPreference("ATMARK_RULE", entry(theme.get("method")));
            putPreference("ATTRIBUTE_OPERATOR", entry(theme.get("method")));
            putPreference("MEDIA", entry(theme.get("keyword")));
            break;
        }
    }

    private static String entry(String rgb) {
        return (rgb == null) ? null 
                             : "#" + rgbToHex(rgb)
                               + " | null | false | false | false | false";
    }

    private static String boldEntry(String rgb) {
        return (rgb == null) ? null
                             : "#" + rgbToHex(rgb)
                               + " | null | true | false| false | false";
    }
    
    private static String italicEntry(String rgb) {
        return (rgb == null) ? null
                             : "#" + rgbToHex(rgb)
                               + " | null | false | true | false | false";
    }
    
    private static String rgbToHex(String rgb) {
        String[] channels = rgb.split(",");
        int r = Integer.parseInt(channels[0]);
        int g = Integer.parseInt(channels[1]);
        int b = Integer.parseInt(channels[2]);
        return Integer.toHexString(r << 16 | g << 8 | b);
    }

    @Override
    protected void putDependentEntries(String key) {
    }

    @Override
    public void clear() {
        switch (editorType) {
        case XML:
        case HTML:
            preferences.remove("tagBorder");
            preferences.remove("tagName");
            preferences.remove("tagAttributeName");
            preferences.remove("tagAttributeEquals");
            preferences.remove("tagAttributeValue");
            preferences.remove("xmlContent");
            preferences.remove("commentBorder");
            preferences.remove("commentText");
            preferences.remove("entityReference");
            preferences.remove("doctypeName");
            preferences.remove("doctypeExternalPubref");
            preferences.remove("doctypeExtrenalSysref");
            preferences.remove("doctypeExternalId");
            if (Type.XML.equals(editorType)) {
                preferences.remove("declBorder");
                preferences.remove("cdataBorder");
                preferences.remove("cdataText");
                preferences.remove("piBorder");
                preferences.remove("piContent");
            } else if (Type.HTML.equals(editorType))
                preferences.remove("declBoder");
            break;
        case CSS:
            preferences.remove("PROPERTY_NAME");
            preferences.remove("CLASS");
            preferences.remove("ATTRIBUTE_VALUE");
            preferences.remove("UNIVERSAL");
            preferences.remove("COMBINATOR");
            preferences.remove("SEMI_COLON");
            preferences.remove("ATTRIBUTE_DELIM");
            preferences.remove("SELECTOR");
            preferences.remove("URI");
            preferences.remove("ATTRIBUTE_NAME");
            preferences.remove("COLON");
            preferences.remove("ID");
            preferences.remove("NORMAL");
            preferences.remove("STRING");
            preferences.remove("CURLY_BRACE");
            preferences.remove("PSEUDO");
            preferences.remove("COMMENT");
            preferences.remove("PROPERTY_VALUE");
            preferences.remove("ATMARK_RULE");
            preferences.remove("ATTRIBUTE_OPERATOR");
            preferences.remove("MEDIA");
            break;
        }
    }
}
