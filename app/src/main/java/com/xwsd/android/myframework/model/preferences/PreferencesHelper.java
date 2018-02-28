package com.xwsd.android.myframework.model.preferences;

/**
 * Created by qiang.lin on 2017/11/6.
 */

public interface PreferencesHelper {

     void setToken(String token);

    String getToken();

    boolean getIsFirst();

    void setIsFirst(boolean flag);


}
