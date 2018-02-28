package com.xwsd.android.myframework.modules.discover.index;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseLazyFragment;
import com.xwsd.android.myframework.contract.ThirdContract;

/**
 * Created by qiang.lin on 2017/11/8.
 */

public class DiscoverFragment extends BaseLazyFragment<DiscoverPresenter> implements DiscoverContract.View {



    @Override
    protected int getLayout() {
        return R.layout.fragment_third;
    }

    @Override
    protected void initEventAndData() {


    }

    @Override
    protected void initInject() {
         getFragmentComponent().inject(this);
    }


}
