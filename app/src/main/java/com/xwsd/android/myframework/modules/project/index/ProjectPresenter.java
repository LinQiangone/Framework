package com.xwsd.android.myframework.modules.project.index;

import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.contract.SecondContract;
import com.xwsd.android.myframework.model.DataManager;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2017/11/8.
 */

public class ProjectPresenter extends RxPresenter<SecondContract.View> implements SecondContract.Presenter {
    private DataManager dataManager;

    @Inject
    public ProjectPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }


}
