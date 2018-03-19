package com.xwsd.android.myframework.modules.myself.download;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;

import com.xwsd.android.myframework.app.AppManager;
import com.xwsd.android.myframework.app.MyApp;
import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.model.DataManager;
import com.xwsd.android.myframework.model.schedulers.BaseSchedulerProvider;
import com.xwsd.android.myframework.model.schedulers.SchedulerProvider;
import com.xwsd.android.myframework.modules.MainActivity;
import com.xwsd.android.myframework.utils.DownLoadCallBack;
import com.xwsd.android.myframework.utils.LogUtils;

import java.util.HashMap;

import javax.inject.Inject;
import io.reactivex.disposables.Disposable;
/**
 * Created by qiang.lin on 2018/3/5.
 */

public class DownLoadPresenter extends RxPresenter<DownLoadContract.View> implements DownLoadContract.Presenter {
    private DataManager dataManager;
    private Disposable disposable;
    private BaseSchedulerProvider schedulerProvider;



    @Inject
    public DownLoadPresenter(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;

    }


    @Override
    public void download(String downloadUrl, Activity activity) {
        LogUtils.i("开始");
        disposable = dataManager.download(downloadUrl)
//             发送事件线程
                .subscribeOn(schedulerProvider.io())
//             观察者线程
                .observeOn(schedulerProvider.io())
                .map(responseBody -> responseBody)
                .doOnNext(responseBody -> {
                    boolean flag= (Looper.getMainLooper().getThread()==Thread.currentThread());
                    Log.i("发送111111122222222222",flag+"");
                    DownLoadCallBack downLoadCallBack = new DownLoadCallBack(responseBody, AppManager.getInstance().findActivity(MainActivity.class),
                            progress -> {
//                          ui线程

                            });
                })
                .observeOn(schedulerProvider.ui())
                .subscribe(responseBody -> {
//                        onNext
//                    if (flag) {
//                        LogUtils.i("下载成功");
//                    } else {
//                        LogUtils.i("下载失败");
//                    }
                    MyApp.getInstance().unSubscribe();
                }, throwable -> {
//onError
                    MyApp.getInstance().unSubscribe();
                });
        MyApp.getInstance().addSubscribe(disposable);
    }
}
