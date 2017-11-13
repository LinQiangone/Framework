package com.xwsd.android.myframework.contract;

import com.xwsd.android.myframework.base.BasePresenter;
import com.xwsd.android.myframework.base.BaseView;

/**
 * Created by qiang.lin on 2017/11/7.
 */

public interface MainContract {
    interface View extends BaseView {

    }
    interface Presenter extends BasePresenter<View> {
    }

}
