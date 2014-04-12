package com.github.eclipsecolortheme.test.mock;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IPreferenceNodeVisitor;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

public class MockEclipsePreferences implements IEclipsePreferences {
    private Map<String, String> store = new HashMap<String, String>();

    public void put(String key, String value) {
        store.put(key, value);
    }

    public String get(String key, String def) {
        if (store.containsKey(key)) {
            return store.get(key);
        } else {
            return def;
        }
    }

    public void remove(String key) {
        store.remove(key);
    }

    public void clear() throws BackingStoreException {
        store.clear();
    }

    public void putInt(String key, int value) {
        store.put(key, String.valueOf(value));
    }

    public int getInt(String key, int def) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void putLong(String key, long value) {
        // TODO Auto-generated method stub

    }

    public long getLong(String key, long def) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void putBoolean(String key, boolean value) {
        store.put(key, String.valueOf(value));
    }

    public boolean getBoolean(String key, boolean def) {
        return Boolean.parseBoolean(get(key, String.valueOf(def)));
    }

    public void putFloat(String key, float value) {
        // TODO Auto-generated method stub

    }

    public float getFloat(String key, float def) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void putDouble(String key, double value) {
        // TODO Auto-generated method stub

    }

    public double getDouble(String key, double def) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void putByteArray(String key, byte[] value) {
        // TODO Auto-generated method stub

    }

    public byte[] getByteArray(String key, byte[] def) {
        // TODO Auto-generated method stub
        return null;
    }

    public String[] keys() throws BackingStoreException {
        // TODO Auto-generated method stub
        return null;
    }

    public String[] childrenNames() throws BackingStoreException {
        // TODO Auto-generated method stub
        return null;
    }

    public Preferences parent() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean nodeExists(String pathName) throws BackingStoreException {
        // TODO Auto-generated method stub
        return false;
    }

    public String name() {
        // TODO Auto-generated method stub
        return null;
    }

    public String absolutePath() {
        // TODO Auto-generated method stub
        return null;
    }

    public void flush() throws BackingStoreException {
        // TODO Auto-generated method stub

    }

    public void sync() throws BackingStoreException {
        // TODO Auto-generated method stub

    }

    public void addNodeChangeListener(INodeChangeListener listener) {
        // TODO Auto-generated method stub

    }

    public void removeNodeChangeListener(INodeChangeListener listener) {
        // TODO Auto-generated method stub

    }

    public void addPreferenceChangeListener(IPreferenceChangeListener listener) {
        // TODO Auto-generated method stub

    }

    public void removePreferenceChangeListener(
            IPreferenceChangeListener listener) {
        // TODO Auto-generated method stub

    }

    public void removeNode() throws BackingStoreException {
        // TODO Auto-generated method stub

    }

    public Preferences node(String path) {
        // TODO Auto-generated method stub
        return null;
    }

    public void accept(IPreferenceNodeVisitor visitor)
            throws BackingStoreException {
        // TODO Auto-generated method stub

    }
}
