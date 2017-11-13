package com.xwsd.android.myframework.di.module;

import com.xwsd.android.myframework.app.MyApp;
import com.xwsd.android.myframework.model.DataManager;
import com.xwsd.android.myframework.model.http.HttpHelper;
import com.xwsd.android.myframework.model.http.RetrofitHelper;
import com.xwsd.android.myframework.model.preferences.PreferencesHelper;
import com.xwsd.android.myframework.model.preferences.PreferencesHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by qiang.lin on 2017/11/3.
 */

@Module
public class AppModule {
    private final MyApp application;

    public AppModule(MyApp app){
        application = app;
    }

    @Provides
    @Singleton
    MyApp provideApplicationContext() {
        return application;
    }

    //传入的参数和返回的参数一样，会导致循环依赖
    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper helper){
        return helper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesHelperImpl preferencesHelper){
        return preferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, PreferencesHelper preferencesHelper){
        return new DataManager(httpHelper,preferencesHelper);
    }
}
