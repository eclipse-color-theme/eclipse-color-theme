package com.github.fhd.eclipsecolortheme.themepreferencemapper;

import java.util.*;

public class XMLHTMLEditorMapper extends ThemePreferenceMapper {
    public enum Type {
        XML("org.eclipse.wst.xml.ui"),
        HTML("org.eclipse.wst.html.ui");

        private String plugin;

        private Type(String plugin) {
            this.plugin = plugin;
        }

        public String getPlugin() {
            return plugin;
        }
    }

    private Type editorType;
    
    public XMLHTMLEditorMapper(Type editorType) {
        super(editorType.getPlugin());
        this.editorType = editorType;
    }

    @Override
    public void map(Map<String, String> theme) {
        putPreference("tagBorder", entry(theme.get("method")));
        putPreference("tagName", entry(theme.get("method")));
        putPreference("tagAttributeName", entry(theme.get("field")));
        putPreference("tagAttributeEquals", entry(theme.get("foreground")));
        putPreference("tagAttributeValue", italicEntry(theme.get("string")));
        putPreference("xmlContent", entry(theme.get("foreground")));
        putPreference("commentBorder", entry(theme.get("multiLineComment")));
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
    }

    private static String entry(String rgb) {
        return (rgb == null) ? null 
                             : "#" + rgbToHex(rgb)
                               + " | null | false | false | false | false";
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
        preferences.remove("cdataBorder");
        preferences.remove("cdataText");
        preferences.remove("piBorder");
        preferences.remove("piContent");
        preferences.remove("declBorder");
    }
}
