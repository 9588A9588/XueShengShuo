package com.se7entina.xueshengshuo.widgets;

import android.util.Log;

/**
 * Class:
 * Created by se7enTina on 2016/3/26.
 * Description: 日志工具类
 */
public class LogCat {

    public static final boolean ISDEBUG = true;

    public static final String TAG = "LogCat";

    private static final String EXCEPTION_MESSAGE = "报错喽~~~~~~~~~~~";

    public static void i(String message) {
        i(TAG, message);
    }

    public static void d(String tag, String msg, Object... args) {
        if (ISDEBUG) {
            return;
        }
        if (args.length > 0) {
            msg = String.format(msg, args);
        }
        Log.d(tag, msg);
    }

    public static void i(String tag, String message) {
        if (ISDEBUG)
            if (message == null)
                Log.i(tag, "null");
            else
                Log.i(tag, message);
    }

    public static void i(int message) {

        i(TAG, message);

    }

    public static void i(String tag, int message) {
        if (ISDEBUG) Log.i(tag, Integer.toString(message));
    }

    public static void i(short message) {
        i(TAG, message);
    }

    public static void i(String tag, short message) {
        if (ISDEBUG) Log.i(tag, Short.toString(message));
    }

    public static void i(long message) {
        i(TAG, message);
    }

    public static void i(String tag, Long message) {
        if (ISDEBUG) Log.i(tag, Long.toString(message));
    }


    public static void i(byte message) {
        i(TAG, message);
    }

    public static void i(String tag, byte message) {
        if (ISDEBUG) Log.i(tag, Byte.toString(message));
    }

    public static void i(char message) {
        i(TAG, message);
    }

    public static void i(String tag, char message) {
        if (ISDEBUG) Log.i(tag, Character.toString(message));
    }


    public static void i(float message) {
        i(TAG, message);
    }

    public static void i(String tag, float message) {
        if (ISDEBUG) Log.i(tag, Float.toString(message));
    }

    public static void i(double message) {
        i(TAG, message);
    }

    public static void i(String tag, double message) {
        if (ISDEBUG) Log.i(tag, Double.toString(message));
    }

    public static void i(boolean message) {
        i(TAG, message);
    }

    public static void i(String tag, boolean message) {
        if (ISDEBUG) Log.i(tag, Boolean.toString(message));
    }

    public static void i(Object message) {
        i(TAG, message);
    }

    public static void i(String tag, Object message) {
        if (ISDEBUG) Log.i(tag, String.valueOf(message));
    }


    public static void e(String tag, String message, Exception e) {
        if (ISDEBUG) Log.e(tag, message, e.getCause());
    }

    public static void e(String message, Exception e) {
        e(TAG, message, e);
    }

    public static void e(Exception e) {
        e(EXCEPTION_MESSAGE, e);
    }
}
