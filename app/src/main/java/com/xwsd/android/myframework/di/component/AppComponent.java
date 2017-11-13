package com.xwsd.android.myframework.di.component;

import com.xwsd.android.myframework.app.MyApp;
import com.xwsd.android.myframework.di.module.AppModule;
import com.xwsd.android.myframework.di.module.HttpModule;
import com.xwsd.android.myframework.model.DataManager;
import com.xwsd.android.myframework.model.preferences.PreferencesHelper;
import com.xwsd.android.myframework.model.preferences.PreferencesHelperImpl;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by qiang.lin on 2017/11/1.
 * 申明全局的单例，生命周期和Application一样
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    MyApp getContext();

    //数据管理类
    DataManager getDataManager();


    PreferencesHelperImpl getPreferencesHelper();


}
