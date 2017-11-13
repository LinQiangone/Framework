package com.xwsd.android.myframework.base;

import com.xwsd.android.myframework.app.MyApp;
import com.xwsd.android.myframework.di.component.ActivityComponent;
import com.xwsd.android.myframework.di.component.DaggerActivityComponent;
import com.xwsd.android.myframework.di.module.ActivityModule;
import com.xwsd.android.myframework.model.preferences.PreferencesHelperImpl;
import com.xwsd.android.myframework.utils.ToastUtils;

import javax.inject.Inject;

/**
 * Created by qiang.lin on 2017/11/3.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView{

    @Inject
    protected T mPresenter;

    @Inject
    protected PreferencesHelperImpl preferencesHelper;

    protected abstract void initInject();

    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder()
                .appComponent(MyApp.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
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
        MyApp.getRefWatcher(mContext).watch(this);
    }

    @Override
    public void showErrorMsg(String msg) {
        ToastUtils.showShort(msg);
    }

//    @Override
//    public void userNightMode(boolean isNight) {
//        if (isNight){
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        }
//        else{
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        }
//        recreate();
//    }
}
