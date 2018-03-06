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
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;

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
    public void download(String downloadUrl) {
        disposable = dataManager.download(downloadUrl)
//             发送事件线程
                .subscribeOn(schedulerProvider.io())
//             观察者线程
                .observeOn(schedulerProvider.io())
                .map(responseBody -> responseBody)
                .doOnNext(responseBody -> {
                    DownLoadUtils.saveFile(responseBody, AppManager.getInstance().handler);
                }).observeOn(schedulerProvider.ui())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
//                        onNext
                        LogUtils.i("下载","11111111111");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
//onError
                        LogUtils.i("下载","2222222222222222");
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
//                  onComplete,解除订阅
                        LogUtils.i("下载","3333333333333");
                        MyApp.getInstance().unSubscribe();
                    }
                });
        MyApp.getInstance().addSubscribe(disposable);
    }
}
