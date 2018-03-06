package com.xwsd.android.myframework.model.api;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by qiang.lin on 2017/11/6.
 * 请求地址配置
 */

public interface MyApi {


    /**
     * 大文件使用，文件下载
     *
     * @return
     */
    @Streaming
    @GET
    Flowable<ResponseBody> download(@Url String downloadUrl);

}
