package com.xwsd.android.myframework.modules.project.projectdetail;

import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.model.DataManager;
import com.xwsd.android.myframework.modules.discover.index.DiscoverContract;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2018/2/28.
 */

public class ProjectDetailPresenter extends RxPresenter<DiscoverContract.View> implements DiscoverContract.Presenter {

    private DataManager dataManager;

    @Inject
    public ProjectDetailPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

}
