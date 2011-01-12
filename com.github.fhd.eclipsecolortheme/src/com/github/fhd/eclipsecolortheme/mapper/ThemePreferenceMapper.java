package com.github.fhd.eclipsecolortheme.mapper;

import java.util.*;

import org.eclipse.core.runtime.preferences.*;
import org.osgi.service.prefs.*;

/**
 * Maps color themes to Eclipse preferences.
 * XXX: Subject to refactoring/rewrite, mappings require way too much code.
 */
public abstract class ThemePreferenceMapper {
    /** The associated Eclipse preferences. */
    protected IEclipsePreferences preferences;

    /**
     * Creates a new mapper.
     * @param plugin The ID of the Eclipse plugin whose preferences should be
     *               altered.
     */
    public ThemePreferenceMapper(String plugin) {
        preferences = new InstanceScope().getNode(plugin);
    }

    /**
     * Writes and applies the modified preferences.
     * @throws BackingStoreException
     */
    public void flush() throws BackingStoreException {
        preferences.flush();
    }

    /**
     * Maps the @a theme to the associated Eclipse preferences.
     * @param theme The color theme to map.
     */
    public abstract void map(Map<String, String> theme);

    /**
     * Sets @a key to @a value in the associated Eclipse preferences and sets
     * all dependent preferences.
     * @param key The preferences key.
     * @param value The preferences value. Ignored if <code>null</code>.
     */
    protected void putPreference(String key, String value) {
        if (value == null)
            return;

        putDependentEntries(key);
        preferences.put(key, value);
    }

    /**
     * Modifies the associated Eclipse preferences to set any values required
     * for @a key to take effect.
     * @param key The key whose dependent should be movied. 
     */
    protected abstract void putDependentEntries(String key);

    /**
     * Clears the associated Eclipse preferences.
     * This resets every preference to its default value.
     */
    public abstract void clear();
}