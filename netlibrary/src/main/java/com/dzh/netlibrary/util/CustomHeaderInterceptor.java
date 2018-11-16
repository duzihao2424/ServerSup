//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dzh.netlibrary.util;

import android.content.Context;
import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class CustomHeaderInterceptor implements Interceptor {
    @NonNull
    private final Context context;

    public CustomHeaderInterceptor(@NonNull Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().addHeader("Lang-Code", LanguageUtil.getCurrentLanguage(this.context)).build());
    }
}
