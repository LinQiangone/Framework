package com.xwsd.android.myframework.modules;

import android.content.Intent;

import com.xwsd.android.myframework.app.AppManager;
import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.model.DataManager;
import com.xwsd.android.myframework.model.schedulers.SchedulerProvider;
import com.xwsd.android.myframework.modules.welcome.SplashActivity;
import com.xwsd.android.myframework.modules.welcome.WelcomeActivity;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/**
 * Created by qiang.lin on 2017/11/7.
 * 对应MainActivity
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {
    private DataManager dataManager;

    @Inject
    public MainPresenter(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
    }


}
