package com.se7entina.xueshengshuo.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;

import com.se7entina.xueshengshuo.widgets.LogCat;

/**
 * Class:
 * Created by se7enTina on 2016/3/26.
 * Description:
 */
public class AppUtil {
    public static final String TAG = "AppUtil";

    /**
     * @param packageName 判断本地是否存在的包名
     */
    public static boolean isLocal(Context context, String packageName) {
        try {
            context.getPackageManager().getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            LogCat.e(TAG, "没找到这个应用程序: " + packageName, e);
            return false;
        }
    }

    /**
     * @param packageName 要打开应用的包名
     */
    public static void startApp(Activity activity, String packageName) {
        activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage(packageName));
    }


    /**
     * 封装的打开应用单击事件
     */
    public static class StartAppOnClickListener implements View.OnClickListener {

        private Activity activity;
        private String packageName;


        public StartAppOnClickListener(Activity activity, String packageName) {
            this.activity = activity;
            this.packageName = packageName;
        }


        @Override
        public void onClick(View v) {
            startApp(activity, packageName);
        }

    }

    /**
     * 获取应用名称
     */
    public static String getApplicationName(Context context) {

        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        String applicationName =
                (String) packageManager.getApplicationLabel(applicationInfo);
        return applicationName;

    }

    public static int getMyVersionCode(Context context) {
        return getMyPackageInfo(context).versionCode;
    }


    public static PackageInfo getMyPackageInfo(Context context) {

        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return packInfo;
    }
}
