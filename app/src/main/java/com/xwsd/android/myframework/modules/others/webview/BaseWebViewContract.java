package com.xwsd.android.myframework.modules.others.webview;

import com.xwsd.android.myframework.base.BasePresenter;
import com.xwsd.android.myframework.base.BaseView;

/**
 * Created by qiang.lin on 2018/3/5.
 */

public interface BaseWebViewContract {
    interface View extends BaseView {

    }
    interface Presenter extends BasePresenter<View> {

    }
}
