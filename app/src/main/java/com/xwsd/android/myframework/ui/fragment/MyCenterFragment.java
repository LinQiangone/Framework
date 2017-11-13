package com.xwsd.android.myframework.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseFragment;
import com.xwsd.android.myframework.base.BaseLazyFragment;
import com.xwsd.android.myframework.contract.MyCenterContract;
import com.xwsd.android.myframework.presenter.MyCenterPresenter;
import com.xwsd.android.myframework.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by qiang.lin on 2017/9/11.
 * 个人中心
 */

public class MyCenterFragment extends BaseLazyFragment<MyCenterPresenter> implements MyCenterContract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_my_center;
    }

    @Override
    protected void initEventAndData() {
        toolbarTitle.setText("个人中心");


    }



}
