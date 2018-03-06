package com.xwsd.android.myframework.modules.myself.download;

import com.xwsd.android.myframework.app.AppManager;
import com.xwsd.android.myframework.app.MyApp;
import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.model.DataManager;
import com.xwsd.android.myframework.model.schedulers.BaseSchedulerProvider;
import com.xwsd.android.myframework.model.schedulers.SchedulerProvider;
import com.xwsd.android.myframework.utils.DownLoadUtils;
import com.xwsd.android.myframework.utils.LogUtils;
import javax.inject.Inject;
import io.reactivex.disposables.Disposable;

/**
 * Created by qiang.lin on 2018/3/5.
 */

public class DownLoadPresenter extends RxPresenter<DownLoadContract.View> implements DownLoadContract.Presenter {
    private DataManager dataManager;
    private Disposable disposable;
    private BaseSchedulerProvider schedulerProvider;
    private boolean flag;


    @Inject
    public DownLoadPresenter(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }


    @Override
    public void download(String downloadUrl) {
        LogUtils.i("开始");
        disposable = dataManager.download(downloadUrl)
//             发送事件线程
                .subscribeOn(schedulerProvider.io())
//             观察者线程
                .observeOn(schedulerProvider.io())
                .map(responseBody -> responseBody)
                .doOnNext(responseBody -> flag = DownLoadUtils.saveFile(responseBody, MyApp.getInstance().handler))
                .observeOn(schedulerProvider.ui())
                .subscribe(responseBody -> {
//                        onNext
                    if (flag) {
                        LogUtils.i("下载成功");
                    } else {
                        LogUtils.i("下载失败");
                    }
                    MyApp.getInstance().unSubscribe();
                }, throwable -> {
//onError
                    MyApp.getInstance().unSubscribe();
                });
        MyApp.getInstance().addSubscribe(disposable);
    }
}
