package com.github.fhd.eclipsecolortheme;

import org.eclipse.jface.resource.*;
import org.eclipse.ui.plugin.*;
import org.osgi.framework.*;

/** This plugin's activator. */
public class Activator extends AbstractUIPlugin {
    public static final String PLUGIN_ID = "eclipse-color-theme";
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
