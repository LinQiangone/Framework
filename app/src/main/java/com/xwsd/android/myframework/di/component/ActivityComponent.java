package com.xwsd.android.myframework.di.component;


import android.app.Activity;

import com.xwsd.android.myframework.di.module.ActivityModule;
import com.xwsd.android.myframework.di.scope.ActivityScope;
import com.xwsd.android.myframework.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by qiang.lin on 2017/11/7.
 * activity注入
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(MainActivity mainActivity);

}
