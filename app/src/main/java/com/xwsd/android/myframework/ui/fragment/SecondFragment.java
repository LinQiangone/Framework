package com.xwsd.android.myframework.ui.fragment;

import android.widget.TextView;
import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseFragment;
import com.xwsd.android.myframework.base.BaseLazyFragment;
import com.xwsd.android.myframework.contract.SecondContract;
import com.xwsd.android.myframework.presenter.SecondPresenter;
import com.xwsd.android.myframework.utils.LogUtils;

import butterknife.BindView;

/**
 * Created by qiang.lin on 2017/11/8.
 */

public class SecondFragment extends BaseLazyFragment<SecondPresenter> implements SecondContract.View {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;


    @Override
    protected int getLayout() {
        return R.layout.fragment_second;
    }

    @Override
    protected void initEventAndData() {
        toolbarTitle.setText("第二个");

    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


}