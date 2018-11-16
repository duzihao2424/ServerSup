//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dzh.netlibrary.network;

import com.google.gson.GsonBuilder;

import retrofit2.Converter.Factory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DzhConverterFactory {
    private static GsonConverterFactory factory = null;

    public DzhConverterFactory() {
    }

    public static Factory getFactory() {
        if (factory == null) {
            factory = GsonConverterFactory.create((new GsonBuilder()).create());
        }

        return factory;
    }
}
