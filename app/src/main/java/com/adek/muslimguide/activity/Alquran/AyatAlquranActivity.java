package com.adek.muslimguide.activity.Alquran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.adek.muslimguide.Adapter.AdapterSurah;
import com.adek.muslimguide.Pojo.Alquran.Ayah;
import com.adek.muslimguide.Pojo.Alquran.ResultForSurah;
import com.adek.muslimguide.R;
import com.adek.muslimguide.rest.alquran.Service;
import com.adek.muslimguide.rest.alquran.client;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AyatAlquranActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<Ayah> results;
    List<Ayah> result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat_alquran);
        recyclerView = findViewById(R.id.recyclerayatAlquran);

        int ayat= getIntent().getIntExtra("ayat",0);
//        Toast.makeText(getApplicationContext(),String.valueOf(ayat),Toast.LENGTH_SHORT).show();
        getData(ayat);
    }

    private void getData(int ayat){
        new client();
        Service api = client.createService(Service.class);
        api.getAyah(ayat).enqueue(new Callback<ResultForSurah>() {
            @Override
            public void onResponse(Call<ResultForSurah> call, Response<ResultForSurah> response) {
                if (response.isSuccessful()){
                    ResultForSurah resultForSurah = response.body();
                    results = resultForSurah.getData().getAyahs();
                    init();

                }
                else{
                    Toast.makeText(getApplicationContext(),"gagal",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResultForSurah> call, Throwable t) {

            }
        });
        api.getEnTrans(ayat).enqueue(new Callback<ResultForSurah>() {
            @Override
            public void onResponse(Call<ResultForSurah> call, Response<ResultForSurah> response) {
                if (response.isSuccessful()){
                    ResultForSurah resultForSurah = response.body();
                    result2 = resultForSurah.getData().getAyahs();
                    init();

                }
                else{
                    Toast.makeText(getApplicationContext(),"gagal",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResultForSurah> call, Throwable t) {

            }
        });

    }

    private void  init(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        AdapterSurah adapterSurah = new AdapterSurah(getApplicationContext(), results,result2);
        recyclerView.setAdapter(adapterSurah);
    }
}
