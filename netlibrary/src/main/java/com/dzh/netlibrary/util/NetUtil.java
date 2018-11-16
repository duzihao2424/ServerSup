package com.dzh.netlibrary.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

import com.dzh.netlibrary.Application.DzhApplication;


public class NetUtil {
    public NetUtil() {
    }

    public static boolean checkNet(Context context) {
        return checkWifi(context) || check2G3G4G(context);
    }

    public static boolean check2G3G4G(Context context) {
        return checkNet(context, 0);
    }

    public static boolean checkWifi(Context context) {
        return checkNet(context, 1);
    }

    public static boolean checkNet(Context context, int type) {
        @SuppressLint("WrongConstant") ConnectivityManager connectivity = (ConnectivityManager) DzhApplication.applicationContext.getSystemService("connectivity");
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo info = connectivity.getNetworkInfo(type);
            return info != null && info.getState().equals(State.CONNECTED);
        }
    }

    public static boolean isConnectNetwork(Context context) {
        return checkNet(context);
    }
}
