package com.github.eclipsecolortheme;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/** This plugin's activator. */
public class Activator extends AbstractUIPlugin {
    public static final String PLUGIN_ID = "com.github.eclipsecolortheme";
    public static final String EXTENSION_POINT_ID_MAPPER = PLUGIN_ID + ".mapper";
    public static final String EXTENSION_POINT_ID_THEME = PLUGIN_ID + ".theme";

    private static Activator plugin;

    /** Creates a new activator. */
    public Activator() {
    }

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    public static Activator getDefault() {
        return plugin;
    }

    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }
}
