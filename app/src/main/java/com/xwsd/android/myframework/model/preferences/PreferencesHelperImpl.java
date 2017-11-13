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

    private static final boolean DEFAULT_NO_IMAGE = false;
//    private static final int DEFAULT_CURRENT_ITEM = Constants.TYPE_MAIN_PAGE;

    @Inject
    public PreferencesHelperImpl(){
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
//
//    @Override
//    public int getCurrentItem() {
//        return mSPrefs.getInt(Constants.SP_CURRENT_ITEM, DEFAULT_CURRENT_ITEM);
//    }
//
//    @Override
//    public void setCurrentItem(int item) {
//        mSPrefs.edit().putInt(Constants.SP_CURRENT_ITEM, item).apply();
//    }
//
//    @Override
//    public void setLastLoginUserName(String name) {
//        mSPrefs.edit().putString(Constants.SP_LAST_LOGIN_USER,name).apply();
//    }
//
//    @Override
//    public String getLastLoginUserName() {
//        return mSPrefs.getString(Constants.SP_LAST_LOGIN_USER,"");
//    }
//
//    @Override
//    public boolean getGuide() {
//        return mSPrefs.getBoolean(Constants.SP_IS_GUIDED,false);
//    }
//
//    @Override
//    public long getUpdateBaseDataTime() {
//        return mSPrefs.getLong(Constants.UPDATE_BASEDATA_TIME,0);
//    }
//
//    @Override
//    public void saveBaseDataTime(long time) {
//        mSPrefs.edit().putLong(Constants.UPDATE_BASEDATA_TIME,time);
//    }
//
//    @Override
//    public void setGuide(boolean flag) {
//        mSPrefs.edit().putBoolean(Constants.SP_IS_GUIDED,flag).apply();
//    }
//
//    @Override
//    public String getUserReplyContent() {
//        return mSPrefs.getString(Constants.SP_USERREPLY_CONTENT,"");
//    }
//
//    @Override
//    public void setUserReplyContent(String content) {
//        mSPrefs.edit().putString(Constants.SP_USERREPLY_CONTENT,content).apply();
//    }


}

