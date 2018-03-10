package com.adek.muslimguide.rest.alquran;

import com.adek.muslimguide.Pojo.Alquran.ResultForSurah;
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
    Call<ResultForSurah> getAyah (@Path("surah")int noSurah);

    @GET("surah/{surah}/en.asad")
    Call<ResultForSurah> getEnTrans (@Path("surah")int noSurah);


}
