package com.xwsd.android.myframework.di.module;

import android.app.Activity;


import com.xwsd.android.myframework.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by qiang.lin on 2017/11/1.
 */

@Module
public class ActivityModule {
    private Activity mActivity;
    public ActivityModule(Activity activity){
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity(){
        return mActivity;
    }
}
