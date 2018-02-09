package com.xwsd.android.myframework.modules.project.index;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseLazyFragment;
import com.xwsd.android.myframework.contract.SecondContract;

/**
 * Created by qiang.lin on 2017/11/8.
 */

public class ProjectFragment extends BaseLazyFragment<SecondPresenter> implements SecondContract.View {



    @Override
    protected int getLayout() {
        return R.layout.fragment_second;
    }

    @Override
    protected void initEventAndData() {


    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


}