package com.xwsd.android.myframework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.xwsd.android.myframework.app.MyApp;
import com.xwsd.android.myframework.di.component.DaggerFragmentComponent;
import com.xwsd.android.myframework.di.component.FragmentComponent;
import com.xwsd.android.myframework.di.module.FragmentModule;
import com.xwsd.android.myframework.model.preferences.PreferencesHelperImpl;
import com.xwsd.android.myframework.utils.ToastUtils;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2017/11/8.
 */

public abstract class BaseFragment <T extends BasePresenter> extends SimpleFragment implements BaseView{

    @Inject
    protected T mPresenter;
    @Inject
    protected PreferencesHelperImpl preferencesHelper;

    protected FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .fragmentModule(getFragmentModule())
                .appComponent(MyApp.getAppComponent())
                .build();
    }

    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(View view,@Nullable Bundle bSavedInstanceState){
        initInject();
        mPresenter.attachView(this);
        super.onViewCreated(view,bSavedInstanceState);
    }

    @Override
    public void onDestroyView(){
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroyView();
    }



    @Override
    public void showErrorMsg(String msg) {
        ToastUtils.showShort(msg);
    }


    protected abstract void initInject();


}
