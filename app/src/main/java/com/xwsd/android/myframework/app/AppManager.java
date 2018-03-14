package com.xwsd.android.myframework.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;

import com.xwsd.android.myframework.utils.LogUtils;

import java.util.Stack;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by qiang.lin on 2017/8/7
 */
public class AppManager {
    private static Stack<Activity> stack;
    private static AppManager appManager;



    private AppManager() {
    }

    /**
     * 单一实例，线程安全
     */
    public static AppManager getInstance() {
        if (appManager == null) {
            synchronized (AppManager.class) {
                if (appManager == null) {
                    appManager = new AppManager();
                }
            }
        }
        return appManager;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (stack == null) {
            stack = new Stack();
        }
        stack.add(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            stack.remove(activity);
            activity.finish();
        }
    }


    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = stack.size(); i < size; i++) {
            if (null != stack.get(i)) {
                stack.get(i).finish();
            }
        }
        stack.clear();
    }

    /**
     * 结束指定 Activity
     *
     * @param clz Activity 类
     */
    public void finishActivity(@NonNull final Class<?> clz) {
        for (Activity activity : stack) {
            if (activity.getClass().equals(clz)) {
                activity.finish();
            }
        }
    }

    /**
     * 找到指定 Activity
     *
     * @param clz Activity 类
     */
    public Activity findActivity(@NonNull final Class<?> clz) {
        for (Activity activity : stack) {
            if (activity.getClass().equals(clz)) {
               return activity;
            }
        }
        return null;
    }

    /**
     * 退出应用程序
     */
    public void appExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }
    }

}
