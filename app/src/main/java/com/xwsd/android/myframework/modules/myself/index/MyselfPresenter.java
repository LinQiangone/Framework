package com.xwsd.android.myframework.modules.myself.index;

import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.model.DataManager;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2017/11/7.
 */

public class MyselfPresenter extends RxPresenter<MyselfContract.View> implements MyselfContract.Presenter {
    private DataManager dataManager;

    @Inject
    public MyselfPresenter(DataManager dataManager) {
        this.dataManager=dataManager;
    }
}
