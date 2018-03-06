package com.xwsd.android.myframework.modules.myself.download;

import android.view.View;
import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseFragment;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import butterknife.OnClick;

/**
 * Created by qiang.lin on 2018/3/5.
 */

public class DownLoadFragment extends BaseFragment<DownLoadPresenter> implements DownLoadContract.View {






    @Override
    protected int getLayout() {
        return R.layout.fragment_download;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


    @OnClick({R.id.navbar_left_image, R.id.tv_download})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.navbar_left_image:
                pop();
                break;
            case R.id.tv_download:
                 mPresenter.download("http://xykd.taihaifintech.com//Uploads/Apk/20180305/5a9cf5c7330c4.apk");
                break;
        }
    }
}
