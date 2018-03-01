package com.xwsd.android.myframework.modules.project.projectdetail;

import android.widget.TextView;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

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

    }


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


    @OnClick(R.id.tv_seconds)
    public void onViewClicked() {
        mPresenter.countDown();
        tvSeconds.setEnabled(false);
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
}
