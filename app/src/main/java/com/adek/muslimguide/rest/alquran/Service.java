package com.adek.muslimguide.rest.alquran;

import com.adek.muslimguide.Pojo.Alquran.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Adek on 03/03/2018.
 */

public interface Service {

    @GET("surah")
    Call<Result> getSurah ();

    @GET("surah/{surah}")
    Call<Result> getAyah (@Path("surah")int noSurah);


}
