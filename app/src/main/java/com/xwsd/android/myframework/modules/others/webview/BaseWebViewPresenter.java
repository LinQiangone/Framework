package com.xwsd.android.myframework.modules.others.webview;

import com.xwsd.android.myframework.base.RxPresenter;
import com.xwsd.android.myframework.model.DataManager;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2018/3/5.
 */

public class BaseWebViewPresenter extends RxPresenter<BaseWebViewContract.View> implements BaseWebViewContract.Presenter {
    private DataManager dataManager;

    @Inject
    public BaseWebViewPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }


}
