package com.xwsd.android.myframework.modules.myself.index;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseLazyFragment;
import com.xwsd.android.myframework.modules.myself.download.DownLoadFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by qiang.lin on 2017/9/11.
 * 个人中心
 */

public class MyselfFragment extends BaseLazyFragment<MyselfPresenter> implements MyselfContract.View {


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_myself;
    }

    @Override
    protected void initEventAndData() {


    }


    @OnClick(R.id.tv_my_center)
    public void onViewClicked() {
        DownLoadFragment fragment = new DownLoadFragment();
        start(fragment);
    }
}
