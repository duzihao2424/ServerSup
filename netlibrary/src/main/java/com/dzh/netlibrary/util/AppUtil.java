//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dzh.netlibrary.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;


public class AppUtil {
    public static Context applicationContext = null;

    public AppUtil() {
    }

    public static void init(Context context) {
        applicationContext = context;
    }

    public static int getVersionCode(Context context) {
        int versionCode = 0;
        if (context == null) {
            return versionCode;
        } else {
            PackageManager manager = context.getPackageManager();

            try {
                PackageInfo packageInfo = manager.getPackageInfo(context.getPackageName(), 0);
                versionCode = packageInfo.versionCode;
                return versionCode;
            } catch (NameNotFoundException var4) {
                Logger.getLogger().e("获取 app 版本失败");
                return versionCode;
            }
        }
    }

    public static String getVersionName(Context context) {
        String versionName = "";
        if (context == null) {
            return versionName;
        } else {
            PackageManager manager = context.getPackageManager();

            try {
                PackageInfo packageInfo = manager.getPackageInfo(context.getPackageName(), 0);
                versionName = packageInfo.versionName;
                return versionName;
            } catch (NameNotFoundException var4) {
                Logger.getLogger().e("获取 app 版本失败");
                return versionName;
            }
        }
    }

    public static String getPackageName(Context context) {
        String packageName = "";
        if (context == null) {
            return packageName;
        } else {
            PackageManager manager = context.getPackageManager();

            try {
                PackageInfo packageInfo = manager.getPackageInfo(context.getPackageName(), 0);
                packageName = packageInfo.packageName;
                return packageName;
            } catch (NameNotFoundException var4) {
                Logger.getLogger().e("获取 app 包名失败");
                return packageName;
            }
        }
    }

    public static String getAppName(Context context) {
        String appName = "";
        if (context == null) {
            return appName;
        } else {
            PackageManager manager = context.getPackageManager();

            try {
                ApplicationInfo applicationInfo = manager.getApplicationInfo(context.getPackageName(), 0);
                appName = (String)manager.getApplicationLabel(applicationInfo);
                return appName;
            } catch (NameNotFoundException var4) {
                Logger.getLogger().e("获取 app 包名失败");
                return appName;
            }
        }
    }

}
