package com.xwsd.android.myframework.modules.home.index;

import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.contract.MainContract;
import com.xwsd.android.myframework.model.DataManager;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2017/11/7.
 *
 */

public class HomePresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{
    private DataManager dataManager;
    @Inject
    public HomePresenter(DataManager dataManager) {
        this.dataManager=dataManager;
    }
}
