package com.xwsd.android.myframework.di.component;

import android.app.Activity;

import com.xwsd.android.myframework.di.module.FragmentModule;
import com.xwsd.android.myframework.di.scope.FragmentScope;
import com.xwsd.android.myframework.modules.MainFragment;
import com.xwsd.android.myframework.modules.discover.index.DiscoverFragment;
import com.xwsd.android.myframework.modules.home.index.HomeFragment;
import com.xwsd.android.myframework.modules.myself.index.MyselfFragment;
import com.xwsd.android.myframework.modules.project.index.ProjectFragment;

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
    void inject(MyselfFragment fragment);
    void inject(ProjectFragment fragment);
    void inject(DiscoverFragment fragment);

}
