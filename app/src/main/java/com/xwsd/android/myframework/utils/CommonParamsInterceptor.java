package com.xwsd.android.myframework.utils;

import com.xwsd.android.myframework.model.preferences.PreferencesHelperImpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by qiang.lin on 2018/3/2.
 */

public class CommonParamsInterceptor implements Interceptor {
     private  PreferencesHelperImpl preferencesHelper;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String method = request.method();
        preferencesHelper=new PreferencesHelperImpl();
//        if ("GET".equals(method)) {
////          get请求
//            request = addGetParams(request);
//        } else if ("POST".equals(method)) {
////post请求
//            request = addPostParams(request);
//        }


        return chain.proceed(request);
    }

    /**
     * 添加post请求公共参数
     *
     * @param request
     * @return 添加后的request
     */
//    private Request addPostParams(Request request) throws UnsupportedEncodingException {
//        if (request.body() instanceof FormBody) {
//            FormBody.Builder bodyBuilder = new FormBody.Builder();
//            FormBody formBody = (FormBody) request.body();
//
//            //把原来的参数添加到新的构造器，（因为没找到直接添加，所以就new新的）
//            for (int i = 0; i < formBody.size(); i++) {
//                bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
//            }
//
////            formBody = bodyBuilder
////                    .addEncoded("media", Constants.MEDIA)
////                    .build();
//
//            Map<String, String> bodyMap = getSortMap();
//            List<String> nameList = new ArrayList<>();
//
//            for (int i = 0; i < formBody.size(); i++) {
//                nameList.add(formBody.encodedName(i));
//                bodyMap.put(formBody.encodedName(i), URLDecoder.decode(formBody.encodedValue(i), "UTF-8"));
//            }
//
//            if(preferencesHelper.getUserId()!=null && preferencesHelper.getUserId().length()>0){
//                bodyMap.put("userId", preferencesHelper.getUserId());//登录的用户id
//                bodyMap.put("userSecret",preferencesHelper.getSecret());
//
//            }
////            StringBuilder builder = new StringBuilder();
////            for (int i = 0; i < nameList.size(); i++) {
////                builder.append("&").append(nameList.get(i)).append("=")
////                        .append(URLDecoder.decode(bodyMap.get(nameList.get(i)), "UTF-8"));
////            }
//            formBody = bodyBuilder
//                    .addEncoded("userId", preferencesHelper.getUserId())
//                    .addEncoded("userSecret", preferencesHelper.getSecret())
//                    .addEncoded("sign", sign(bodyMap))
//                    .build();
//            request = request.newBuilder().post(formBody).build();
//        }
//        return request;
//    }
//
//    /**
//     * 添加get请求公共参数
//     *
//     * @param request
//     * @return 添加后的request
//     */
//    private Request addGetParams(Request request) {
//        //添加公共参数
//        HttpUrl httpUrl = request.url();
////                .newBuilder()
////                .addQueryParameter("media", Constants.MEDIA)
////                .build();
//
//        //添加签名
//        Set<String> nameSet = httpUrl.queryParameterNames();
//        ArrayList<String> nameList = new ArrayList<>();
//        nameList.addAll(nameSet);
//        Collections.sort(nameList);
//        //转map
//        Map<String, String> map = getSortMap();
//
//
//        for (int i = 0; i < nameList.size(); i++) {
//            map.put(nameList.get(i), (httpUrl.queryParameterValues(nameList.get(i)) != null &&
//                    httpUrl.queryParameterValues(nameList.get(i)).size() > 0 ? httpUrl.queryParameterValues(nameList.get(i)).get(0) : ""));
//
//        }
//
//
//        if(preferencesHelper.getUserId()!=null && preferencesHelper.getUserId().length()>0){
//            map.put("userId", preferencesHelper.getUserId());//登录的用户id
//            map.put("userSecret",preferencesHelper.getSecret());
//        }
//        httpUrl = httpUrl.newBuilder()
//                .addQueryParameter("userId", preferencesHelper.getUserId())
//                .addQueryParameter("userSecret", preferencesHelper.getSecret())
//                .addQueryParameter("sign", sign(map))
//                .build();
//        request = request.newBuilder().url(httpUrl).build();
//        return request;
//    }


}
