package com.xwsd.android.myframework.modules.project.index;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseLazyFragment;
import com.xwsd.android.myframework.modules.MainFragment;
import com.xwsd.android.myframework.modules.project.projectdetail.ProjectDetailFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by qiang.lin on 2017/11/8.
 */

public class ProjectFragment extends BaseLazyFragment<ProjectPresenter> implements ProjectContract.View {


    @Override
    protected int getLayout() {
        return R.layout.fragment_project;
    }

    @Override
    protected void initEventAndData() {


    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


    @OnClick(R.id.tv_project)
    public void onViewClicked() {
        ProjectDetailFragment fragment = new ProjectDetailFragment();
        ((MainFragment) getParentFragment()).start(fragment);
    }
}