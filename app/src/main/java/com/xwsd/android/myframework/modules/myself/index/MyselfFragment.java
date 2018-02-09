package com.xwsd.android.myframework.modules.myself.index;

import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.base.BaseLazyFragment;
import com.xwsd.android.myframework.contract.MyCenterContract;

/**
 * Created by qiang.lin on 2017/9/11.
 * 个人中心
 */

public class MyselfFragment extends BaseLazyFragment<MyCenterPresenter> implements MyCenterContract.View {



    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_my_center;
    }

    @Override
    protected void initEventAndData() {



    }



}
