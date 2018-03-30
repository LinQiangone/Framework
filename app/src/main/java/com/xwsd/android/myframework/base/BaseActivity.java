package com.xwsd.android.myframework.base;

import android.widget.Scroller;

import com.xwsd.android.myframework.app.MyApp;
import com.xwsd.android.myframework.di.component.ActivityComponent;
import com.xwsd.android.myframework.di.component.DaggerActivityComponent;
import com.xwsd.android.myframework.di.module.ActivityModule;
import com.xwsd.android.myframework.model.preferences.PreferencesHelperImpl;
import com.xwsd.android.myframework.utils.ToastUtils;
import com.xwsd.android.myframework.view.EmptyLayout;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2017/11/3.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView {

    @Inject
    protected T mPresenter;

    public EmptyLayout mErrorLayout;

    /**
     * 注入
     */
    protected abstract void initInject();


    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(MyApp.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
        //内存泄漏检测,view分离以后检测内存问题。
//        MyApp.getRefWatcher(mContext).watch(this);
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


}
