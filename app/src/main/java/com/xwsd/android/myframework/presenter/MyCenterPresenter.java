package com.xwsd.android.myframework.presenter;

import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.contract.MyCenterContract;
import com.xwsd.android.myframework.model.DataManager;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2017/11/7.
 */

public class MyCenterPresenter extends RxPresenter<MyCenterContract.View> implements MyCenterContract.Presenter {
    private DataManager dataManager;

    @Inject
    public MyCenterPresenter(DataManager dataManager) {
        this.dataManager=dataManager;
    }
}
