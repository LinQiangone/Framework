package com.xwsd.android.myframework.modules;

import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.model.DataManager;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2017/11/7.
 * 对应MainActivity下的第一个fragment（MainFragment）
 * 构造器可以做一些初始化
 */

public class MainFragmentPresenter extends RxPresenter<MainFragmentContract.View> implements MainFragmentContract.Presenter {

    DataManager dataManager;

    @Inject
    public MainFragmentPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }







}
