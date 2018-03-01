package com.xwsd.android.myframework.model;

import com.xwsd.android.myframework.model.http.HttpHelper;
import com.xwsd.android.myframework.model.preferences.PreferencesHelper;

/**
 * Created by qiang.lin on 017/11/6.
 */

public class DataManager implements HttpHelper, PreferencesHelper{
    private HttpHelper httpHelper;
    private PreferencesHelper mPreferencesHelper;

    public DataManager(HttpHelper httpHelper, PreferencesHelper preferencesHelper) {
        this.httpHelper = httpHelper;
        this.mPreferencesHelper = preferencesHelper;
    }


    /**
     * @param token
     */
    @Override
    public void setToken(String token) {
        mPreferencesHelper.setToken(token);
    }

    @Override
    public String getToken() {
        return mPreferencesHelper.getToken();
    }

    /**
     * 第一次打开app判断引导页
     * @return
     */
    @Override
    public boolean getIsFirst() {
        return mPreferencesHelper.getIsFirst();
    }

    @Override
    public void setIsFirst(boolean flag) {
        mPreferencesHelper.setIsFirst(flag);
    }

}
