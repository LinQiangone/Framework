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
import com.xwsd.android.myframework.view.EmptyLayout;
import com.xwsd.android.myframework.view.NavbarManage;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2017/11/8.
 */

public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView {


    //标题栏导航
    public NavbarManage navbarManage;
    //    错误页
    public EmptyLayout mErrorLayout;
    @Inject
    protected T mPresenter;


    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .fragmentModule(getFragmentModule())
                .appComponent(MyApp.getAppComponent())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle bSavedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        super.onViewCreated(view, bSavedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroyView();
    }


    /**
     * 显示错误信息
     *
     * @param msg
     */
    @Override
    public void showErrorMsg(String msg) {
        ToastUtils.showShort(msg);
    }

    /**
     * 显示正在加载中(表单提交)
     */
    @Override
    public void showLoading() {
        showWaitDialog();
    }

    /**
     * 隐藏加载框
     */
    @Override
    public void hideLoading() {
        hideWaitDialog();
    }

    /**
     * 显示错误页
     *
     * @param i
     */
    @Override
    public void showErrorPage(int i) {
        mErrorLayout.setErrorType(i);
    }

    /**
     * 显示成功信息
     *
     * @param msg
     */
    @Override
    public void showSuccessMsg(String msg) {
        ToastUtils.showShort(msg);
    }


    protected abstract void initInject();


}
