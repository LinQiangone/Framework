package com.xwsd.android.myframework.model;

import com.google.gson.JsonObject;
import com.xwsd.android.myframework.model.api.MyApi;
import com.xwsd.android.myframework.model.http.HttpHelper;
import com.xwsd.android.myframework.model.preferences.PreferencesHelper;
import io.reactivex.Flowable;

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

    @Override
    public Flowable<JsonObject> getBannerList(String token) {
        return httpHelper.getBannerList(token);
    }

    @Override
    public void setToken(String token) {
        mPreferencesHelper.setToken(token);
    }

    @Override
    public String getToken() {
        return mPreferencesHelper.getToken();
    }


    /**
     * 数据库查询
     * @return
     */
//    @Override
//    public List<LoanType> getLoanTypeData() {
//        return mDBHelper.getLoanTypeData();
//    }

    /**
     * sharepreferences查询
     * @return
     */
//    @Override
//    public String getLastLoginUserName() {
//        return mPreferencesHelper.getLastLoginUserName();
//    }

    /**
     * 网络请求查询
     * @param uid
     * @return
     */

//    @Override
//    public Flowable<Package<List<Account>>> getAccount(int uid) {
//        return mHttpHelper.getAccount(uid);
//    }



}
