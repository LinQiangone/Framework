package com.xwsd.android.myframework.modules.discover.index;

import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.model.DataManager;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2017/11/8.
 */

public class DiscoverPresenter extends RxPresenter<DiscoverContract.View> implements DiscoverContract.Presenter  {
    private DataManager dataManager;

    @Inject
    public DiscoverPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }
}
