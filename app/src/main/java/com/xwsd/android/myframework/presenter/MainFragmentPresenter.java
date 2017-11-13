package com.xwsd.android.myframework.presenter;

import com.google.gson.JsonObject;
import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.contract.MainFragmentContract;
import com.xwsd.android.myframework.model.DataManager;

import javax.inject.Inject;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

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
