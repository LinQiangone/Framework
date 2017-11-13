package com.xwsd.android.myframework.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseFragment;
import com.xwsd.android.myframework.base.BaseLazyFragment;
import com.xwsd.android.myframework.contract.HomeContract;
import com.xwsd.android.myframework.presenter.HomePresenter;
import com.xwsd.android.myframework.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by qiang.lin on 2017/11/7.
 * 首页
 */

public class HomeFragment extends BaseLazyFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;



    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initEventAndData() {
        toolbarTitle.setText("首页");
        preferencesHelper.setToken("222222");
    }

    @OnClick(R.id.tv_home)
    public void onViewClicked() {
        ((MainFragment) getParentFragment()).start(new ImageViewFragment());
    }
}
