package com.xwsd.android.myframework.modules.others.webview;

import com.xwsd.android.myframework.base.BaseFragment;

/**
 * Created by qiang.lin on 2018/3/5.
 * 腾讯浏览器fragment
 */

public class BaseWebViewFragment extends BaseFragment<BaseWebViewPresenter> implements BaseWebViewContract.View {


    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
}
