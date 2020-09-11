package com.dev.gadsproject.repository;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GADSClient {
    private static Retrofit retrofit=null;
    public static OkHttpClient client;
    public static final String BASE_URL = "https://gadsapi.herokuapp.com/";

    public static Retrofit getRetrofit (){
         OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder builder = originalRequest.newBuilder().header("Content-Type","application/json");
                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        return new Retrofit.Builder()

                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
