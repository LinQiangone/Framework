package com.xwsd.android.myframework.modules.discover.index;

import android.widget.TextView;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseLazyFragment;
import com.xwsd.android.myframework.contract.ThirdContract;
import com.xwsd.android.myframework.presenter.ThirdPresenter;

import butterknife.BindView;

/**
 * Created by qiang.lin on 2017/11/8.
 */

public class DiscoverFragment extends BaseLazyFragment<ThirdPresenter> implements ThirdContract.View {



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
