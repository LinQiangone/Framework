package com.xwsd.android.myframework.model.http;

import com.google.gson.JsonObject;
import com.xwsd.android.myframework.model.api.MyApi;
import com.xwsd.android.myframework.model.api.XMLApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;

/**
 * Created by qiang.lin on 2017/11/6.
 * 网络接口实现类
 */

public class RetrofitHelper implements HttpHelper{
    //json解析
    private MyApi myApi;
    //xml解析
    private XMLApi xmlApi;

    @Inject
    public RetrofitHelper(MyApi myApi,XMLApi xmlApi) {
       this.myApi = myApi;
       this.xmlApi=xmlApi;
    }


    @Override
    public Flowable<ResponseBody> download(String downloadUrl) {
        return myApi.download(downloadUrl);
    }
}
