package com.xwsd.android.myframework.model.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.xwsd.android.myframework.app.Constants;
import com.xwsd.android.myframework.app.MyApp;

import javax.inject.Inject;


/**
 * Created by qiang.lin on 2017/11/6.
 */

public class PreferencesHelperImpl implements PreferencesHelper {
    private final SharedPreferences mSPrefs;
    private static final String SHARED_PREFERENCES_NAME = "my_sp";


    @Inject
    public PreferencesHelperImpl() {
        mSPrefs = MyApp.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void setToken(String token) {
        mSPrefs.edit().putString(Constants.TOKEN, token).apply();
    }

    @Override
    public String getToken() {
        return mSPrefs.getString(Constants.TOKEN, "");
    }

    /**
     * 第一次打开app判断引导页
     * @return
     */
    @Override
    public boolean getIsFirst() {
        return mSPrefs.getBoolean(Constants.IS_FIRST, true);
    }

    @Override
    public void setIsFirst(boolean flag) {
        mSPrefs.edit().putBoolean(Constants.IS_FIRST, flag).apply();
    }

}

