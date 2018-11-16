package com.dzh.serversup.baseserver;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.dzh.netlibrary.Application.DzhApplication;

public class Application extends DzhApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
