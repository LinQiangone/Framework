package com.xwsd.android.myframework.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

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
            stack = new Stack<Activity>();
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
            activity = null;
        }
    }

    /**
     * 获得当前的activity
     */
    public Activity currentActivity() {
        Activity activity = null;
        if (!stack.empty()) activity = stack.lastElement();
        return activity;
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
