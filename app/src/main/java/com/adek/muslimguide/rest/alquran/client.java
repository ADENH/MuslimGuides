package com.adek.muslimguide.rest.alquran;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Adek on 03/03/2018.
 */

public class client {
    public static final String BASE_URL="https://api.alquran.cloud/";

    private static OkHttpClient.Builder sHttpClient =
            //can add interceptors here
            new OkHttpClient.Builder();

    private static Retrofit.Builder sBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(sHttpClient.build());

    public static <T> T createService(Class<T> serviceClass) {
        return sBuilder.build().create(serviceClass);
    }
}
