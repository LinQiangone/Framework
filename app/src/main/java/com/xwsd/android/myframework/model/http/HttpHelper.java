package com.xwsd.android.myframework.model.http;


import com.google.gson.JsonObject;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.Url;

/**
 * Created by qiang.lin on 2017/11/7.
 * 网络请求接口
 */

public interface HttpHelper {
    Flowable<ResponseBody> download(@Url String downloadUrl);



}
