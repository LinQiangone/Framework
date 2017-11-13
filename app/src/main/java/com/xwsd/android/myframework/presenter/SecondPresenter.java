package com.xwsd.android.myframework.presenter;

import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.contract.MainFragmentContract;
import com.xwsd.android.myframework.contract.SecondContract;
import com.xwsd.android.myframework.model.DataManager;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2017/11/8.
 */

public class SecondPresenter extends RxPresenter<SecondContract.View> implements SecondContract.Presenter {
    private DataManager dataManager;

    @Inject
    public SecondPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }


}
