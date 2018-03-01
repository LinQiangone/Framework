package com.xwsd.android.myframework.modules.project.projectdetail;

import com.xwsd.android.myframework.base.BasePresenter;
import com.xwsd.android.myframework.base.BaseView;
import com.xwsd.android.myframework.modules.MainContract;

/**
 * Created by qiang.lin on 2018/2/28.
 */

public interface ProjectDetailContract {
    interface View extends BaseView {
        void updateTime(String time);
        void setTextStatus();

    }
    interface Presenter extends BasePresenter<View> {
        void countDown();

    }
}
