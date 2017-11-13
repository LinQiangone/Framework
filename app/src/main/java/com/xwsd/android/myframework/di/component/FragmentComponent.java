package com.xwsd.android.myframework.di.component;

import android.app.Activity;

import com.xwsd.android.myframework.di.module.FragmentModule;
import com.xwsd.android.myframework.di.scope.FragmentScope;
import com.xwsd.android.myframework.ui.fragment.HomeFragment;
import com.xwsd.android.myframework.ui.fragment.ImageViewFragment;
import com.xwsd.android.myframework.ui.fragment.MainFragment;
import com.xwsd.android.myframework.ui.fragment.MyCenterFragment;
import com.xwsd.android.myframework.ui.fragment.SecondFragment;
import com.xwsd.android.myframework.ui.fragment.ThirdFragment;

import dagger.Component;

/**
 * Created by qiang.lin on 2017/11/7.
 * 注入fragment
 */

@FragmentScope
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

    void inject(MainFragment fragment);
    void inject(HomeFragment fragment);
    void inject(MyCenterFragment fragment);
    void inject(SecondFragment fragment);
    void inject(ThirdFragment fragment);
    void inject(ImageViewFragment fragment);
}
