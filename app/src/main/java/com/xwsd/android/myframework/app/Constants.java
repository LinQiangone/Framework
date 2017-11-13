package com.xwsd.android.myframework.app;

import java.io.File;

/**
 * Created by qiang.lin on 2017/11/6.
 * 全局常量
 */

public class Constants {
    //首页
    public static final int HOME_FRAGMENT = 1;
    //第二个
    public static final int SECOND_FRAGMENT=2;
    //第三个
    public static final int THIRD_FRAGMENT=3;
    //个人中心
    public static final int MY_CENTER_FRAGMENT = 4;
    //网络缓存路径
    public static final String PATH_DATA = MyApp.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";
    //版本号
    public static final String APP_VERSION = "1.0";

    public static final String TOKEN="token";
}
