package com.xwsd.android.myframework.app;

/**
 * Created by qiang.lin on 2017/10/20.
 */

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.xwsd.android.myframework.di.component.AppComponent;
import com.xwsd.android.myframework.di.component.DaggerAppComponent;
import com.xwsd.android.myframework.di.module.AppModule;
import com.xwsd.android.myframework.utils.Utils;

import java.util.Stack;

/**
 * Created by qiang.lin on 2017/11/5.
 */

public class MyApp extends Application {
    private static MyApp myApp;
    public static AppComponent appComponent;
    private RefWatcher refWatcher;
    private static Stack<Activity> stack;
    public static synchronized MyApp getInstance(){
        return myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
        Utils.init(this);
        setupLeakCanary();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    public static AppComponent getAppComponent(){
        if (appComponent == null){
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(MyApp.getInstance())).build();
        }
        return appComponent;
    }

    /**
     *
     * @return
     */
    protected RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            refWatcher= RefWatcher.DISABLED;
            return refWatcher;
        }
        refWatcher=LeakCanary.install(this);
        return refWatcher;
    }

    public static RefWatcher getRefWatcher(Context context) {
        myApp = (MyApp) context.getApplicationContext();
        return myApp.refWatcher;
    }






}

