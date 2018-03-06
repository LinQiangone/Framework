package com.xwsd.android.myframework.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

import com.xwsd.android.myframework.utils.LogUtils;

import java.util.Stack;

/**
 * Created by qiang.lin on 2017/8/7
 */
public class AppManager {
    private static Stack<Activity> stack;
    private static AppManager appManager;


    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Bundle bundle = msg.getData();
                    int progress = bundle.getInt("progress");
                    LogUtils.i("下载-----",progress);
//                更新进度
                    break;
                case 2:
                    break;
            }
        }
    };


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
