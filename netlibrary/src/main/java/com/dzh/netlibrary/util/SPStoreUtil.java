//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dzh.netlibrary.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.io.Serializable;
import java.util.Set;

public class SPStoreUtil {
    public static String STORE_NAME_SETTING = "Wdk12Study";

    public SPStoreUtil() {
    }

    private static SharedPreferences getSettingPreferences(Context context, String storeName) {
        SharedPreferences setting = null;
        setting = context.getSharedPreferences(storeName, 0);
        return setting;
    }

    public static String getString(Context ctx, String storeName, String key) {
        String value = null;
        getSettingPreferences(ctx, storeName).edit();
        if (getSettingPreferences(ctx, storeName).contains(key)) {
            value = getSettingPreferences(ctx, storeName).getString(key, (String)null);
        }

        return value;
    }

    public static String getString(Context ctx, String storeName, String key, String defaultValue) {
        String value = null;
        getSettingPreferences(ctx, storeName).edit();
        if (getSettingPreferences(ctx, storeName).contains(key)) {
            value = getSettingPreferences(ctx, storeName).getString(key, defaultValue);
        } else {
            value = defaultValue;
        }

        return value;
    }

    public static String getString(Context ctx, String key) {
        return getString(ctx, STORE_NAME_SETTING, key);
    }

    public static String getStringWithDefault(Context ctx, String key, String defaultValue) {
        return getString(ctx, STORE_NAME_SETTING, key, defaultValue);
    }

    public static void putString(Context ctx, String storeName, String key, Serializable value) {
        Editor edit = getSettingPreferences(ctx, storeName).edit();
        edit.putString(key, "" + value);
        edit.commit();
    }

    public static void putString(Context ctx, String key, Serializable value) {
        putString(ctx, STORE_NAME_SETTING, key, value);
    }

    public static int getInt(Context ctx, String storeName, String key) {
        int value = -1;
        getSettingPreferences(ctx, storeName).edit();
        if (getSettingPreferences(ctx, storeName).contains(key)) {
            value = getSettingPreferences(ctx, storeName).getInt(key, -1);
        }

        return value;
    }

    public static int getInt(Context ctx, String storeName, String key, int defaultValue) {
        int value = 1;
        getSettingPreferences(ctx, storeName).edit();
        if (getSettingPreferences(ctx, storeName).contains(key)) {
            value = getSettingPreferences(ctx, storeName).getInt(key, defaultValue);
        } else {
            value = defaultValue;
        }

        return value;
    }

    public static int getInt(Context ctx, String key) {
        return getInt(ctx, STORE_NAME_SETTING, key);
    }

    public static int getInt(Context ctx, String key, int defaultValue) {
        return getInt(ctx, STORE_NAME_SETTING, key, defaultValue);
    }

    public static void putInt(Context ctx, String storeName, String key, int value) {
        Editor edit = getSettingPreferences(ctx, storeName).edit();
        edit.putInt(key, value);
        edit.commit();
    }

    public static void putInt(Context ctx, String key, int value) {
        putInt(ctx, STORE_NAME_SETTING, key, value);
    }

    public static long getLong(Context ctx, String storeName, String key) {
        long value = -1L;
        getSettingPreferences(ctx, storeName).edit();
        if (getSettingPreferences(ctx, storeName).contains(key)) {
            value = getSettingPreferences(ctx, storeName).getLong(key, -1L);
        }

        return value;
    }

    public static long getLong(Context ctx, String storeName, String key, long defaultValue) {
        long value = -1L;
        getSettingPreferences(ctx, storeName).edit();
        if (getSettingPreferences(ctx, storeName).contains(key)) {
            value = getSettingPreferences(ctx, storeName).getLong(key, defaultValue);
        } else {
            value = defaultValue;
        }

        return value;
    }

    public static long getLong(Context ctx, String key) {
        return getLong(ctx, STORE_NAME_SETTING, key);
    }

    public static long getLong(Context ctx, String key, long defaultValue) {
        return getLong(ctx, STORE_NAME_SETTING, key, defaultValue);
    }

    public static void putLong(Context ctx, String storeName, String key, long value) {
        Editor edit = getSettingPreferences(ctx, storeName).edit();
        edit.putLong(key, value);
        edit.commit();
    }

    public static void putLong(Context ctx, String key, long value) {
        putLong(ctx, STORE_NAME_SETTING, key, value);
    }

    public static float getFloat(Context ctx, String storeName, String key) {
        float value = -1.0F;
        getSettingPreferences(ctx, storeName).edit();
        if (getSettingPreferences(ctx, storeName).contains(key)) {
            value = getSettingPreferences(ctx, storeName).getFloat(key, -1.0F);
        }

        return value;
    }

    public static float getFloat(Context ctx, String storeName, String key, float defaultValue) {
        float value = -1.0F;
        getSettingPreferences(ctx, storeName).edit();
        if (getSettingPreferences(ctx, storeName).contains(key)) {
            value = getSettingPreferences(ctx, storeName).getFloat(key, defaultValue);
        } else {
            value = defaultValue;
        }

        return value;
    }

    public static float getFloat(Context ctx, String key) {
        return getFloat(ctx, STORE_NAME_SETTING, key);
    }

    public static float getFloat(Context ctx, String key, float defaultValue) {
        return getFloat(ctx, STORE_NAME_SETTING, key, defaultValue);
    }

    public static void putFloat(Context ctx, String storeName, String key, float value) {
        Editor edit = getSettingPreferences(ctx, storeName).edit();
        edit.putFloat(key, value);
        edit.commit();
    }

    public static void putFloat(Context ctx, String key, float value) {
        putFloat(ctx, STORE_NAME_SETTING, key, value);
    }

    public static boolean getBoolean(Context ctx, String storeName, String key) {
        boolean value = false;
        getSettingPreferences(ctx, storeName).edit();
        if (getSettingPreferences(ctx, storeName).contains(key)) {
            value = getSettingPreferences(ctx, storeName).getBoolean(key, false);
        }

        return value;
    }

    public static boolean getBoolean(Context ctx, String storeName, String key, boolean defaultValue) {
        boolean value = false;
        getSettingPreferences(ctx, storeName).edit();
        if (getSettingPreferences(ctx, storeName).contains(key)) {
            value = getSettingPreferences(ctx, storeName).getBoolean(key, defaultValue);
        } else {
            value = defaultValue;
        }

        return value;
    }

    public static boolean getBoolean(Context ctx, String key) {
        return getBoolean(ctx, STORE_NAME_SETTING, key);
    }

    public static boolean getBoolean(Context ctx, String key, boolean defaultValue) {
        return getBoolean(ctx, STORE_NAME_SETTING, key, defaultValue);
    }

    public static void putBoolean(Context ctx, String storeName, String key, boolean value) {
        Editor edit = getSettingPreferences(ctx, storeName).edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public static void putBoolean(Context ctx, String key, boolean value) {
        putBoolean(ctx, STORE_NAME_SETTING, key, value);
    }

    public static Set<String> getStringSet(Context ctx, String storeName, String key) {
        Set<String> value = null;
        getSettingPreferences(ctx, storeName).edit();
        if (getSettingPreferences(ctx, storeName).contains(key)) {
            value = getSettingPreferences(ctx, storeName).getStringSet(key, (Set)null);
        }

        return value;
    }

    public static Set<String> getStringSet(Context ctx, String key) {
        return getStringSet(ctx, STORE_NAME_SETTING, key);
    }

    public static void putStringSet(Context ctx, String storeName, String key, Set<String> value) {
        Editor edit = getSettingPreferences(ctx, storeName).edit();
        edit.putStringSet(key, value);
        edit.commit();
    }

    public static void putStringSet(Context ctx, String key, Set<String> value) {
        putStringSet(ctx, STORE_NAME_SETTING, key, value);
    }

    public static Set<String> getAllKey(Context context) {
        return getSettingPreferences(context, STORE_NAME_SETTING).getAll().keySet();
    }

    public static Set<String> getAllKey(Context context, String storeName) {
        return getSettingPreferences(context, storeName).getAll().keySet();
    }

    public static void clearStoreName(Context context, String storeName) {
        Editor edit = getSettingPreferences(context, storeName).edit();
        edit.clear();
        edit.apply();
    }
}
