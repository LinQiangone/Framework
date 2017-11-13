package com.xwsd.android.myframework.presenter;

import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.contract.ImageViewContract;
import com.xwsd.android.myframework.model.DataManager;
import com.xwsd.android.myframework.model.schedulers.BaseSchedulerProvider;
import com.xwsd.android.myframework.model.schedulers.SchedulerProvider;
import com.xwsd.android.myframework.utils.LogUtils;
import javax.inject.Inject;

/**
 * Created by qiang.lin on 2017/11/8.
 */

public class ImageViewPresenter extends RxPresenter<ImageViewContract.View> implements ImageViewContract.Presenter {

    DataManager dataManager;
    BaseSchedulerProvider baseSchedulerProvider;


    @Inject
    public ImageViewPresenter(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.baseSchedulerProvider=schedulerProvider;
    }

    @Override
    public void getBannerList() {
        addSubscribe(dataManager.getBannerList("1")
                .subscribeOn(baseSchedulerProvider.computation())
                .observeOn(baseSchedulerProvider.ui())
                .subscribe(jsonObject -> {
                    //onNext
                    LogUtils.i("图片"+jsonObject.toString());
                }, throwable -> {
                     //onError
                }));



    }
}
