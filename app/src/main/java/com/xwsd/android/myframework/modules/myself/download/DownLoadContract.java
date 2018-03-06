package com.xwsd.android.myframework.modules.myself.download;

import com.xwsd.android.myframework.base.BasePresenter;
import com.xwsd.android.myframework.base.BaseView;
import com.xwsd.android.myframework.modules.myself.index.MyselfContract;

/**
 * Created by qiang.lin on 2018/3/5.
 */

public interface DownLoadContract {
    interface View extends BaseView {

    }
    interface Presenter extends BasePresenter<View> {
        void download(String downloadUrl);

    }
}
