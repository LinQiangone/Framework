package com.xwsd.android.myframework.modules.project.projectdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseFragment;
import com.xwsd.android.myframework.view.EmptyLayout;
import com.xwsd.android.myframework.view.NavbarManage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by qiang.lin on 2018/2/28.
 * 项目详情
 */

public class ProjectDetailFragment extends BaseFragment<ProjectDetailPresenter> implements ProjectDetailContract.View {


    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.tv_seconds)
    TextView tvSeconds;



    @Override
    protected int getLayout() {
        return R.layout.fragment_project_detail;
    }

    @Override
    protected void initEventAndData() {
        initTitle();
    }

    private void initTitle() {
        //        错误页
        mErrorLayout = (EmptyLayout) mView.findViewById(R.id.error_layout);
        mErrorLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
        mErrorLayout.setOnLayoutClickListener(v -> {
            mErrorLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
//            mPresenter.getScatteredDetailData(id);
        });
        mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
//        结束
        navbarManage = new NavbarManage(getActivity(), mView);
        navbarManage.showLeft(true);
        navbarManage.setTextSize(14);
        navbarManage.setCentreStr("项目详情");
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }



    @Override
    public void updateTime(String time) {
        tvSeconds.setText(time);
    }

    @Override
    public void setTextStatus() {
        tvSeconds.setEnabled(true);
        tvSeconds.setText("发送验证码");
    }


    @OnClick({R.id.navbar_left_image, R.id.tv_seconds})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.navbar_left_image:
                pop();
                break;
            case R.id.tv_seconds:
                mPresenter.countDown();
                tvSeconds.setEnabled(false);
                break;

        }
    }
}
