//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dzh.netlibrary.util.logger;

public interface Printer {
    Printer t(String var1, int var2);

    Settings init(String var1);

    Settings getSettings();

    void d(String var1, StackTraceElement[] var2, Object... var3);

    void e(String var1, StackTraceElement[] var2, Object... var3);

    void e(Throwable var1, String var2, StackTraceElement[] var3, Object... var4);

    void w(String var1, StackTraceElement[] var2, Object... var3);

    void i(String var1, StackTraceElement[] var2, Object... var3);

    void v(String var1, StackTraceElement[] var2, Object... var3);

    void wtf(String var1, StackTraceElement[] var2, Object... var3);

    void json(String var1, StackTraceElement[] var2);

    void xml(String var1, StackTraceElement[] var2);

    void clear();
}
