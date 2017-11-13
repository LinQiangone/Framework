package com.xwsd.android.myframework.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.xwsd.android.myframework.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by qiang.lin on 2017/11/3.
 */

@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment fragment){
        mFragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity(){
        return mFragment.getActivity();
    }
}
