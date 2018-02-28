package com.xwsd.android.myframework.modules.project.projectdetail;

import com.xwsd.android.myframework.base.BaseLazyFragment;

/**
 * Created by qiang.lin on 2018/2/28.
 * 项目详情
 */

public class ProjectDetailFragment  extends BaseLazyFragment<ProjectDetailPresenter> implements ProjectDetailContract.View {
    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInject() {
getFragmentComponent().inject(this);
    }
}
