package com.xwsd.android.myframework.model.api;

import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by qiang.lin on 2017/11/6.
 */

public interface MyApi {

    @POST("Banner/getBannerList")
    @FormUrlEncoded
    Flowable<JsonObject> getBannerList(@Field("token") String  token);

}
