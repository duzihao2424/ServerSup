//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dzh.netlibrary.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

public class LanguageUtil {
    public static final String Chinese = "zh";
    public static final String English = "en";
    public static final int LANGUAGE_CHINA = 1001;
    public static final int LANGUAGE_ENGLISH = 1002;
    public static final String LANGUAGE_TYPE_KEY = "language_type";

    public LanguageUtil() {
    }

    public static String getCurrentLanguage(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return locale.getLanguage();
    }

    public static boolean isChinese(Context context) {
        String language = getCurrentLanguage(context);
        return language.equalsIgnoreCase("zh");
    }

    public static boolean isEnglish(Context context) {
        String language = getCurrentLanguage(context);
        return language.equalsIgnoreCase("en");
    }

    public static void updateLanguage(Context context, Locale type) {
        Resources resources = context.getApplicationContext().getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration fg = resources.getConfiguration();
        fg.locale = type;
        resources.updateConfiguration(fg, dm);
    }

    public static Locale getLocaleType(Context context) {
        Resources resources = context.getApplicationContext().getResources();
        Configuration fg = resources.getConfiguration();
        return fg.locale;
    }
}
