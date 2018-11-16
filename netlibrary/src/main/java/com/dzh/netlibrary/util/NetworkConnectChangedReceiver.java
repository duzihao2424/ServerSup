package com.dzh.netlibrary.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

import java.util.ArrayList;
import java.util.Iterator;

public class NetworkConnectChangedReceiver extends BroadcastReceiver {
    private static ArrayList<DzhNetworkRegister> networkRegisters = new ArrayList();

    public NetworkConnectChangedReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            NetworkInfo info = (NetworkInfo)intent.getParcelableExtra("networkInfo");
            if (info != null) {
                Iterator var4;
                DzhNetworkRegister register;
                if (State.CONNECTED == info.getState() && info.isAvailable()) {
                    if (info.getType() == 1) {
                        var4 = networkRegisters.iterator();

                        while(var4.hasNext()) {
                            register = (DzhNetworkRegister)var4.next();
                            register.wifiNetConnect();
                        }
                    } else if (info.getType() == 0) {
                        var4 = networkRegisters.iterator();

                        while(var4.hasNext()) {
                            register = (DzhNetworkRegister)var4.next();
                            register.mobileNetConnect();
                        }
                    }
                } else if (info.getType() == 1) {
                    var4 = networkRegisters.iterator();

                    while(var4.hasNext()) {
                        register = (DzhNetworkRegister)var4.next();
                        register.wifiNetDisConnect();
                    }
                } else if (info.getType() == 0) {
                    var4 = networkRegisters.iterator();

                    while(var4.hasNext()) {
                        register = (DzhNetworkRegister)var4.next();
                        register.mobileNetDisConnect();
                    }
                }
            }
        }

    }

    public static void addRegisterNetwork(DzhNetworkRegister register) {
        networkRegisters.add(register);
    }
}
