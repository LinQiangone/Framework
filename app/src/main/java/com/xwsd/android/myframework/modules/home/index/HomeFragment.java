package com.xwsd.android.myframework.modules.home.index;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseLazyFragment;
import com.xwsd.android.myframework.contract.HomeContract;
import com.xwsd.android.myframework.presenter.HomePresenter;
import com.xwsd.android.myframework.ui.fragment.MainFragment;

import butterknife.OnClick;

/**
 * Created by qiang.lin on 2017/11/7.
 * 首页
 */

public class HomeFragment extends BaseLazyFragment<HomePresenter> implements HomeContract.View {

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

    }

    @OnClick(R.id.tv_home)
    public void onViewClicked() {

    }


}
