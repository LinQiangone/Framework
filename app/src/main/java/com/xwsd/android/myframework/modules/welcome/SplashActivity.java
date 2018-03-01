package com.xwsd.android.myframework.modules.welcome;

import android.content.Intent;
import com.xwsd.android.myframework.R;
import com.xwsd.android.myframework.app.AppManager;
import com.xwsd.android.myframework.base.BaseActivity;
import com.xwsd.android.myframework.model.schedulers.SchedulerProvider;
import com.xwsd.android.myframework.modules.MainActivity;
import com.xwsd.android.myframework.modules.MainPresenter;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by qiang.lin on 2018/2/28.
 * 启动页
 */

public class SplashActivity extends BaseActivity<MainPresenter> {
    private Disposable disposable;
    public CompositeDisposable mCompositeDisposable;
    @Inject
    SchedulerProvider schedulerProvider;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initEventAndData() {
        mCompositeDisposable=new CompositeDisposable();
        disposable = Flowable.timer(2, TimeUnit.SECONDS).observeOn(schedulerProvider.ui()).subscribe(aLong -> {
//            引导页还是主页
            if (preferencesHelper.getIsFirst()) {
//                引导页
                Intent intent = new Intent(SplashActivity.this, WelcomeActivity.class);
                startActivity(intent);
                preferencesHelper.setIsFirst(false);
            } else {
//                主页
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
            AppManager.getInstance().finishActivity(this);
        });
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

}
