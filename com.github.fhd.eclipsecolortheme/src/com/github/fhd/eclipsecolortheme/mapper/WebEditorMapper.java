package com.github.fhd.eclipsecolortheme.mapper;

import static com.github.fhd.eclipsecolortheme.ColorThemeKeys.*;

import java.util.Map;

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
            putPreference("tagBorder", entry(theme.get(METHOD)));
            putPreference("tagName", entry(theme.get(METHOD)));
            putPreference("tagAttributeName", entry(theme.get(KEYWORD)));
            putPreference("tagAttributeEquals",
                          entry(theme.get(FOREGROUND)));
            putPreference("tagAttributeValue",
                          italicEntry(theme.get(STRING)));
            putPreference("xmlContent", entry(theme.get(FOREGROUND)));
            putPreference("commentBorder",
                          entry(theme.get(MULTI_LINE_COMMENT)));
            putPreference("commentText", entry(theme.get(MULTI_LINE_COMMENT)));
            putPreference("entityReference", entry(theme.get(KEYWORD)));
            putPreference("doctypeName", entry(theme.get(METHOD)));
            putPreference("doctypeExternalPubref", entry(theme.get(METHOD)));
            putPreference("doctypeExtrenalSysref", entry(theme.get(METHOD)));
            putPreference("doctypeExternalId", entry(theme.get(METHOD)));
            if (Type.XML.equals(editorType)) {
                putPreference("declBorder", entry(theme.get(METHOD)));
                putPreference("cdataBorder", entry(theme.get(METHOD)));
                putPreference("cdataText", entry(theme.get(FOREGROUND)));
                putPreference("piBorder", entry(theme.get(METHOD)));
                putPreference("piContent", entry(theme.get(FOREGROUND)));
            } else if (Type.HTML.equals(editorType))
                putPreference("declBoder", entry(theme.get(METHOD)));
            break;
        case CSS:
            putPreference("PROPERTY_NAME", entry(theme.get(FIELD)));
            putPreference("CLASS", italicEntry(theme.get(METHOD)));
            putPreference("ATTRIBUTE_VALUE", entry(theme.get(METHOD)));
            putPreference("UNIVERSAL", entry(theme.get(METHOD)));
            putPreference("COMBINATOR", entry(theme.get(METHOD)));
            putPreference("SEMI_COLON", entry(theme.get(FOREGROUND)));
            putPreference("ATTRIBUTE_DELIM", entry(theme.get(METHOD)));
            putPreference("SELECTOR", boldEntry(theme.get(METHOD)));
            putPreference("URI", italicEntry(theme.get(STRING)));
            putPreference("ATTRIBUTE_NAME", entry(theme.get(METHOD)));
            putPreference("COLON", entry(theme.get(FOREGROUND)));
            putPreference("ID", italicEntry(theme.get(METHOD)));
            putPreference("NORMAL", entry(theme.get(FOREGROUND)));
            putPreference("STRING", italicEntry(theme.get(STRING)));
            putPreference("CURLY_BRACE", entry(theme.get(BRACKET)));
            putPreference("PSEUDO", italicEntry(theme.get(METHOD)));
            putPreference("COMMENT", entry(theme.get(MULTI_LINE_COMMENT)));
            putPreference("PROPERTY_VALUE", italicEntry(theme.get(STRING)));
            putPreference("ATMARK_RULE", entry(theme.get(METHOD)));
            putPreference("ATTRIBUTE_OPERATOR", entry(theme.get(METHOD)));
            putPreference("MEDIA", entry(theme.get(KEYWORD)));
            break;
        }
    }

    @Override
    protected String entry(String color) {
        return (color == null) ? null 
                               : color.toLowerCase()
                                 + " | null | false | false | false | false";
    }

    private static String boldEntry(String color) {
        return (color == null) ? null
                               : color.toLowerCase()
                                 + " | null | true | false| false | false";
    }
    
    private static String italicEntry(String color) {
        return (color == null) ? null
                               : color.toLowerCase()
                                 + " | null | false | true | false | false";
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
