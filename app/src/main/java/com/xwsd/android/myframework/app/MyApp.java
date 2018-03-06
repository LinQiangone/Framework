package com.xwsd.android.myframework.app;

/**
 * Created by qiang.lin on 2017/10/20.
 */

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.multidex.MultiDex;
import android.support.v4.app.NotificationCompat;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.smtt.sdk.QbSdk;
import com.xwsd.android.myframework.R;
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
//        setupLeakCanary();
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


    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Bundle bundle = msg.getData();
                    int progress = bundle.getInt("progress");
//                更新进度
                    break;
                case 2:
                    break;
            }
        }
    };

    public void createNotification(){
        NotificationManager mNotificationManager = (NotificationManager) MyApp.getInstance().getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MyApp.getInstance());
        mBuilder.setContentTitle("下载中...")//设置通知栏标题
                .setContentText("")
//  .setNumber(number) //设置通知集合的数量
                .setPriority(Notification.PRIORITY_DEFAULT) //设置该通知优先级
//  .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                .setOngoing(false)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                .setDefaults(Notification.DEFAULT_VIBRATE)//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合
                //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND 添加声音 // requires VIBRATE permission
                .setSmallIcon(R.mipmap.fragment_icon);//设置通知小ICON




    }


}





