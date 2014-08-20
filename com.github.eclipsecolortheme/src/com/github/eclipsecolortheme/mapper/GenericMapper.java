package com.github.eclipsecolortheme.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.jface.preference.IPreferenceStore;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.github.eclipsecolortheme.Activator;
import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;
import com.github.eclipsecolortheme.ColorThemeSemanticHighlightingMapping;

public class GenericMapper extends ThemePreferenceMapper {
    private Map<String, ColorThemeMapping> mappings = new HashMap<String, ColorThemeMapping>();
    protected ColorThemeSetting defaultBackground;

    /**
     * Parse mapping from input file.
     * @param input InputStream for an XML file
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public void parseMappings(InputStream input)
            throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(input);
        parseMappings(document.getDocumentElement());
    }

    /**
     * Parse mapping from input file.
     * @param root Root element for parsing
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public void parseMappings(Element root)
            throws SAXException, IOException, ParserConfigurationException {
        parseMappings(root, mappings);
    }

    /**
     * Parse mapping from input file.
     * @param root Root element for parsing
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public void parseMappings(Element root, Map<String, ColorThemeMapping> mappings)
            throws SAXException, IOException, ParserConfigurationException {
        parseStandardMappings(root, mappings);
        parseSemanticHighlightingMappings(root, mappings);
    }

    private void parseStandardMappings(Element root, Map<String, ColorThemeMapping> mappings) {
        Node mappingsNode = root.getElementsByTagName("mappings").item(0);
        NodeList mappingNodes = mappingsNode.getChildNodes();
        for (int i = 0; i < mappingNodes.getLength(); i++) {
            Node mappingNode = mappingNodes.item(i);
            if (mappingNode.hasAttributes()) {
                String pluginKey = extractAttribute(mappingNode, "pluginKey");
                String themeKey = extractAttribute(mappingNode, "themeKey");
                mappings.put(pluginKey, createMapping(pluginKey, themeKey));
            }
        }
    }

    private void parseSemanticHighlightingMappings(Element root, Map<String, ColorThemeMapping> mappings) {
        Node mappingsNode = root.getElementsByTagName("semanticHighlightingMappings").item(0);
        if (mappingsNode != null) {
            NodeList mappingNodes = mappingsNode.getChildNodes();
            for (int i = 0; i < mappingNodes.getLength(); i++) {
                Node mappingNode = mappingNodes.item(i);
                if (mappingNode.hasAttributes()) {
                    String pluginKey = extractAttribute(mappingNode, "pluginKey");
                    String themeKey = extractAttribute(mappingNode, "themeKey");
                    mappings.put(pluginKey, createSemanticHighlightingMapping(pluginKey, themeKey));
                }
            }
        }
    }

    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
        return new ColorThemeMapping(pluginKey, themeKey);
    }

    protected ColorThemeSemanticHighlightingMapping createSemanticHighlightingMapping(String pluginKey, String themeKey) {
        return new ColorThemeSemanticHighlightingMapping(pluginKey, themeKey);
    }

    private static String extractAttribute(Node node, String name) {
        return node.getAttributes().getNamedItem(name).getNodeValue();
    }

    @Override
    public void map(Map<String, ColorThemeSetting> theme, Map<String, ColorThemeMapping> overrideMappings) {
        // put preferences according to mappings
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        if (store.getBoolean("forceDefaultBG")) {
            defaultBackground = theme.get("background");
        } else {
            defaultBackground = new ColorThemeSetting();
        }
        for (String pluginKey : mappings.keySet()) {
            ColorThemeMapping mapping = (overrideMappings != null && overrideMappings.containsKey(pluginKey)) ? 
                    overrideMappings.get(pluginKey) : mappings.get(pluginKey);
            ColorThemeSetting setting = theme.get(mapping.getThemeKey());
            if (setting != null) {
                mapping.putPreferences(preferences, setting);
            }
        }
    }

    @Override
    public void clear() {
        for (String pluginKey : mappings.keySet()) {
            ColorThemeMapping mapping = mappings.get(pluginKey);
            mapping.removePreferences(preferences);
        }
    }
}
