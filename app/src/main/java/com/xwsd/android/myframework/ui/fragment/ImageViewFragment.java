package com.xwsd.android.myframework.ui.fragment;

import android.widget.ImageView;
import android.widget.TextView;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseFragment;
import com.xwsd.android.myframework.contract.ImageViewContract;
import com.xwsd.android.myframework.presenter.ImageViewPresenter;
import com.xwsd.android.myframework.utils.LogUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by qiang.lin on 2017/11/8.
 * 二级页面
 */

public class ImageViewFragment extends BaseFragment<ImageViewPresenter> implements ImageViewContract.View {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.banner)
    ImageView banner;


    @Override
    protected int getLayout() {
        return R.layout.fragment_image_view;
    }

    @Override
    protected void initEventAndData() {
        toolbarTitle.setText("二级页面");
        mPresenter.getBannerList();
        LogUtils.i("token", preferencesHelper.getToken());
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        pop();
    }
}
