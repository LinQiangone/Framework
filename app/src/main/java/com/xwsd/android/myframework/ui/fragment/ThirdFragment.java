package com.xwsd.android.myframework.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseFragment;
import com.xwsd.android.myframework.base.BaseLazyFragment;
import com.xwsd.android.myframework.contract.ThirdContract;
import com.xwsd.android.myframework.presenter.ThirdPresenter;
import com.xwsd.android.myframework.utils.LogUtils;

import butterknife.BindView;

/**
 * Created by qiang.lin on 2017/11/8.
 */

public class ThirdFragment extends BaseLazyFragment<ThirdPresenter> implements ThirdContract.View {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;


    @Override
    protected int getLayout() {
        return R.layout.fragment_third;
    }

    @Override
    protected void initEventAndData() {
        toolbarTitle.setText("第三个页面");

    }

    @Override
    protected void initInject() {
         getFragmentComponent().inject(this);
    }


}
