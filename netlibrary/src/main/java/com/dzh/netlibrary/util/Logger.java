//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dzh.netlibrary.util;



import com.dzh.netlibrary.util.logger.LoggerPrinter;
import com.dzh.netlibrary.util.logger.Printer;
import com.dzh.netlibrary.util.logger.Settings;

import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class Logger {
    private static final String DEFAULT_TAG = "wdcloud";
    private static int logLevel = 3;
    private static Logger inst;
    private Lock lock = new ReentrantLock();
    private static Printer printer = null;

    private Logger() {
        init("wdcloud");
    }

    public static synchronized Logger getLogger() {
        if (inst == null) {
            inst = new Logger();
        }

        return inst;
    }

    public static Settings init(String tag) {
        printer = new LoggerPrinter();
        return printer.init(tag);
    }

    public static void clear() {
        printer.clear();
        printer = null;
    }

    private static Printer tLog(String tag) {
        return printer.t(tag, printer.getSettings().getMethodCount());
    }

    private static Printer tLog(int methodCount) {
        return printer.t((String)null, methodCount);
    }

    private static Printer tLog(String tag, int methodCount) {
        return printer.t(tag, methodCount);
    }

    private static void dLog(String message, StackTraceElement[] sts, Object... args) {
        printer.d(message, sts, args);
    }

    private static void eLog(String message, StackTraceElement[] sts, Object... args) {
        printer.e((Throwable)null, message, sts, args);
    }

    private static void eLog(Throwable throwable, String message, StackTraceElement[] sts, Object... args) {
        printer.e(throwable, message, sts, args);
    }

    private static void iLog(String message, StackTraceElement[] sts, Object... args) {
        printer.i(message, sts, args);
    }

    private static void vLog(String message, StackTraceElement[] sts, Object... args) {
        printer.v(message, sts, args);
    }

    private static void wLog(String message, StackTraceElement[] sts, Object... args) {
        printer.w(message, sts, args);
    }

    private static void wtfLog(String message, StackTraceElement[] sts, Object... args) {
        printer.wtf(message, sts, args);
    }

    private static void jsonLog(String json, StackTraceElement[] sts) {
        printer.json(json, sts);
    }

    private static void xmlLog(String xml, StackTraceElement[] sts) {
        printer.xml(xml, sts);
    }

    private String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return null;
        } else {
            StackTraceElement[] var2 = sts;
            int var3 = sts.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                StackTraceElement st = var2[var4];
                if (!st.isNativeMethod() && !st.getClassName().equals(Thread.class.getName()) && !st.getClassName().equals(this.getClass().getName())) {
                    return "[" + st.getFileName() + ":" + st.getLineNumber() + "]";
                }
            }

            return null;
        }
    }

    private String createMessage(String msg) {
        return msg;
    }

    public void i(String message) {
        if (logLevel <= 4) {
            this.lock.lock();

            try {
                LoggerFactory.getLogger("wdcloud").info(message);
                iLog(message, Thread.currentThread().getStackTrace());
            } catch (Exception var6) {
                var6.printStackTrace();
            } finally {
                this.lock.unlock();
            }
        }

    }

    public void v(String message) {
        if (logLevel <= 2) {
            this.lock.lock();

            try {
                vLog(message, Thread.currentThread().getStackTrace());
            } catch (Exception var6) {
                var6.printStackTrace();
            } finally {
                this.lock.unlock();
            }
        }

    }

    public void d(String message) {
        if (logLevel <= 3) {
            this.lock.lock();

            try {
                LoggerFactory.getLogger("wdcloud").debug(message);
                dLog(message, Thread.currentThread().getStackTrace());
            } catch (Exception var6) {
                var6.printStackTrace();
            } finally {
                this.lock.unlock();
            }
        }

    }

    public void e(String message) {
        if (logLevel <= 6) {
            this.lock.lock();

            try {
                LoggerFactory.getLogger("wdcloud").error(message);
                eLog(message, Thread.currentThread().getStackTrace());
            } catch (Exception var6) {
                var6.printStackTrace();
            } finally {
                this.lock.unlock();
            }
        }

    }

    private String getInputString(String format, Object... args) {
        return format == null ? "null log format" : String.format(format, args);
    }

    private void error(Exception e) {
        if (logLevel <= 6) {
            StringBuffer sb = new StringBuffer();
            this.lock.lock();

            try {
                String name = this.getFunctionName();
                StackTraceElement[] sts = e.getStackTrace();
                if (name != null) {
                    sb.append(name + " - " + e + "\r\n");
                } else {
                    sb.append(e + "\r\n");
                }

                if (sts != null && sts.length > 0) {
                    StackTraceElement[] var5 = sts;
                    int var6 = sts.length;

                    for(int var7 = 0; var7 < var6; ++var7) {
                        StackTraceElement st = var5[var7];
                        if (st != null) {
                            sb.append("[ " + st.getFileName() + ":" + st.getLineNumber() + " ]\r\n");
                        }
                    }
                }

                LoggerFactory.getLogger("wdcloud").error(sb.toString());
                eLog(sb.toString(), Thread.currentThread().getStackTrace());
            } finally {
                this.lock.unlock();
            }
        }

    }

    private void w(String message) {
        if (logLevel <= 5) {
            this.lock.lock();

            try {
                LoggerFactory.getLogger("wdcloud").warn(message);
                wLog(message, Thread.currentThread().getStackTrace());
            } finally {
                this.lock.unlock();
            }
        }

    }
}
