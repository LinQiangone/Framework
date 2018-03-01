package com.xwsd.android.myframework.di.module;


import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import com.xwsd.android.myframework.BuildConfig;
import com.xwsd.android.myframework.app.Constants;
import com.xwsd.android.myframework.di.qualifier.CommonQualifier;
import com.xwsd.android.myframework.di.qualifier.XMLQualifier;
import com.xwsd.android.myframework.model.api.MyApi;
import com.xwsd.android.myframework.model.api.XMLApi;
import com.xwsd.android.myframework.model.schedulers.BaseSchedulerProvider;
import com.xwsd.android.myframework.model.schedulers.SchedulerProvider;
import com.xwsd.android.myframework.utils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by qiang.lin on 2017/11/3.
 * 支持xml解析和json解析
 */

@Module
public class HttpModule {

    @Singleton
    @Provides
    BaseSchedulerProvider provideSchedulerProvider(SchedulerProvider schedulerProvider) {
        return schedulerProvider;
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    @CommonQualifier
    Retrofit provideCommonRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createCommonRetrofit(builder, client,
                Constants.HOST);
    }

    @Singleton
    @Provides
    @XMLQualifier
    Retrofit provideXMLRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        //xml解析有时候地址可能不是服务器的地址，这里需要改变
        return createXMLRetrofit(builder, client, Constants.XML_HOST);
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG == true) {
            HttpLoggingInterceptor interceptorLog = new HttpLoggingInterceptor(message -> LogUtils.i("发送的数据", message));
            interceptorLog.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptorLog);
        }
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor interceptor = chain -> {
            Request request = chain.request();
            long timestamp = System.currentTimeMillis();
            request = request.newBuilder()
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", Constants.APP_VERSION)
                    .addHeader("timestamp", timestamp + "")
                    .build();
            Response response = chain.proceed(request);
            return response;
        };
//                    request = request.newBuilder()
//                            .removeHeader("User-Agent")
//                            .addHeader("User-Agent",Constants.USER_AGENT + Constants.APP_VERSION)
//                            .removeHeader("Cookie")
//                            .addHeader("Cookie",session)
//                            .addHeader("timestamp",timestamp+"")
//                            .build();


//                if (!TextUtils.isEmpty(response.header("Set-Cookie"))) {
//                    String cookie = response.header("Set-Cookie");
//                    if (TextUtils.isEmpty(session)) {
//                        userManager.setSession(cookie.split(";")[0] + ";");
//                    }
//                }
//                if (SystemUtil.isNetworkConnected()) {
//                    int maxpage = 0;
//                    response = response.newBuilder()
//                            .addHeader("Cache-Control", "public,max-page=" + maxpage)
//                            .removeHeader("Pragma")
//                            .build();
//                } else {
//                    int maxStale = 60 * 60 * 24 * 28;
//                    response = response.newBuilder()
//                            .addHeader("Cache-Control", "public,only-if-cached,max-stale=" + maxStale)
//                            .removeHeader("Pragma")
//                            .build();
//                }
//                return response;
//            }
//        };

        builder.addNetworkInterceptor(interceptor);
        builder.cache(cache);
        builder.connectTimeout(20, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

    @Singleton
    @Provides
    MyApi provideCommonMyApiService(@CommonQualifier Retrofit retrofit) {
        return retrofit.create(MyApi.class);
    }

    @Singleton
    @Provides
    XMLApi provideXMLMyApiService(@XMLQualifier Retrofit retrofit) {
        return retrofit.create(XMLApi.class);
    }


    private Retrofit createXMLRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder.baseUrl(url)
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private Retrofit createCommonRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder.baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .build();
    }


    private Gson buildGson() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Integer.class, new IntegerDefault0Adapter())
                .registerTypeAdapter(int.class, new IntegerDefault0Adapter())
                .registerTypeAdapter(Double.class, new DoubleDefault0Adapter())
                .registerTypeAdapter(double.class, new DoubleDefault0Adapter())
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson;
    }

    public class IntegerDefault0Adapter implements JsonSerializer<Integer>, JsonDeserializer<Integer> {
        @Override
        public JsonElement serialize(Integer src, Type typeOfT, JsonSerializationContext context) {
            return new JsonPrimitive(src);
        }

        @Override
        public Integer deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            try {
                if (element.getAsString().isEmpty() || element.getAsString().equals("null")) {
                    return 0;
                }
            } catch (Exception e) {
            }

            try {
                return element.getAsInt();
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    public class DoubleDefault0Adapter implements JsonSerializer<Double>, JsonDeserializer<Double> {
        @Override
        public JsonElement serialize(Double src, Type typeOfT, JsonSerializationContext context) {
            return new JsonPrimitive(src);
        }

        @Override
        public Double deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonSyntaxException {
            try {
                if (element.getAsString().isEmpty() || element.getAsString().equals("null")) {
                    return 0.0;
                }
            } catch (Exception e) {
            }

            try {
                return element.getAsDouble();
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }
    }
}
