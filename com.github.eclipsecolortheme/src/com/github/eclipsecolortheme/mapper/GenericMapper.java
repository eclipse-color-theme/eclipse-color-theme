package com.github.eclipsecolortheme.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GenericMapper extends ThemePreferenceMapper {
    private Map<String, String> mappings = new HashMap<String, String>();
    private Map<String, String> dependentMappings =
            new HashMap<String, String>();

    public GenericMapper(String pluginId) {
        super(pluginId);
        InputStream input =  Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/github/eclipsecolortheme/mapper/"
                                     + pluginId + ".xml");
        try {
            parseMapping(input);
        } catch (Exception e) {
            System.err.println("Failed to parse mapping for " + pluginId);
            e.printStackTrace();
        }
    }

    private void parseMapping(InputStream input)
            throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(input);
        Element root = document.getDocumentElement();
        Node mappingsNode = root.getElementsByTagName("mappings").item(0);
        NodeList mappingNodes = mappingsNode.getChildNodes();
        for (int i = 0; i < mappingNodes.getLength(); i++) {
            Node mappingNode = mappingNodes.item(i);
            if (mappingNode.hasAttributes())
                mappings.put(extractAttribute(mappingNode, "pluginKey"),
                             extractAttribute(mappingNode, "themeKey"));
        }

        Node dependentMappingsNode =
                root.getElementsByTagName("dependentMappings").item(0);
        NodeList dependentMappingNodes = dependentMappingsNode.getChildNodes();
        for (int i = 0; i < dependentMappingNodes.getLength(); i++) {
            Node dependentMappingNode = dependentMappingNodes.item(i);
            if (dependentMappingNode.hasAttributes()) {
            	String pluginKey = extractAttribute(dependentMappingNode,
            	                                    "pluginKey");
            	String dependentPluginKey = extractAttribute(
                        dependentMappingNode, "dependentPluginKey");
            	dependentMappings.put(pluginKey, dependentPluginKey);
            }
        }
    }

    private static String extractAttribute(Node node, String name) {
        return node.getAttributes().getNamedItem(name).getNodeValue();
    }

    @Override
    public void map(Map<String, String> theme) {
        for (String dependentPluginKey : dependentMappings.values())
            activateDependentEntry(dependentPluginKey, false);

        for (String pluginKey : mappings.keySet()) {
            String themeValue = theme.get(mappings.get(pluginKey));
            if (themeValue != null) {
                preferences.put(pluginKey, entry(themeValue));
                String dependentPluginKey = dependentMappings.get(pluginKey);
                if (dependentPluginKey != null)
                    activateDependentEntry(dependentPluginKey, true);
            }
        }
    }

    private void activateDependentEntry(String dependentPluginKey,
                                        boolean active) {
        // TODO: Don't hard code this.
        if (dependentPluginKey.endsWith("SystemDefault"))
            preferences.putBoolean(dependentPluginKey, !active);
        else
            preferences.putBoolean(dependentPluginKey, active);
    }

    @Override
    public void clear() {
        for (String pluginKey : mappings.keySet())
            preferences.remove(pluginKey);

        for (String dependentPluginKey : dependentMappings.values())
            preferences.remove(dependentPluginKey);
    }
}
