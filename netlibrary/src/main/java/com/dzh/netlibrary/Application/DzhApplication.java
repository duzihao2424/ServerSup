package com.dzh.netlibrary.Application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;

import com.dzh.netlibrary.util.AppUtil;
import com.dzh.netlibrary.util.NetworkConnectChangedReceiver;


public class DzhApplication extends Application {
    public static DzhApplication application = null;
    public static Context applicationContext = null;
    /** @deprecated */
    @Deprecated
    public static Activity currentActivity = null;

    public DzhApplication() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        application = (DzhApplication)this.getApplicationContext();
        applicationContext = this.getApplicationContext();
        AppUtil.init(applicationContext);
        this.initNetworkConnect();

    }
    private void initNetworkConnect() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        filter.addAction("android.net.wifi.STATE_CHANGE");
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.registerReceiver(new NetworkConnectChangedReceiver(), filter);
    }


}
