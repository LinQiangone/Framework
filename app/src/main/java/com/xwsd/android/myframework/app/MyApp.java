package com.xwsd.android.myframework.app;

/**
 * Created by qiang.lin on 2017/10/20.
 */

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.smtt.sdk.QbSdk;
import com.xwsd.android.myframework.di.component.AppComponent;
import com.xwsd.android.myframework.di.component.DaggerAppComponent;
import com.xwsd.android.myframework.di.module.AppModule;
import com.xwsd.android.myframework.utils.Utils;

import java.util.Stack;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by qiang.lin on 2017/11/5.
 */

public class MyApp extends Application {
    private static MyApp myApp;
    public static AppComponent appComponent;
    private RefWatcher refWatcher;
    public CompositeDisposable compositeDisposable;

    public static synchronized MyApp getInstance() {
        return myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        Utils.init(this);
        setupLeakCanary();
        initX5WebView();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(MyApp.getInstance())).build();
        }
        return appComponent;
    }

    /**
     * @return
     */
    protected RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            refWatcher = RefWatcher.DISABLED;
            return refWatcher;
        }
        refWatcher = LeakCanary.install(this);
        return refWatcher;
    }

    public static RefWatcher getRefWatcher(Context context) {
        myApp = (MyApp) context.getApplicationContext();
        return myApp.refWatcher;
    }

    /**
     * x5WebView初始化配置
     */
    private void initX5WebView() {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
//            Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }

    /**
     * 订阅
     * @param disposable
     */

    public void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null)
            compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(disposable);

    }

    /**
     * 解绑
     */
    public void unSubscribe(){
        if (compositeDisposable!=null)
            compositeDisposable.clear();
    }
}





