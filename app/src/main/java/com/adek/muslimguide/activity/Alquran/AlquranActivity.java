package com.adek.muslimguide.activity.Alquran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.adek.muslimguide.Adapter.AdapterAlquran;
import com.adek.muslimguide.Pojo.Alquran.Result;
import com.adek.muslimguide.Pojo.Alquran.Surah;
import com.adek.muslimguide.R;
import com.adek.muslimguide.rest.alquran.client;
import com.adek.muslimguide.rest.alquran.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlquranActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<Surah> results;
    String status ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alquran);
        recyclerView = findViewById(R.id.recyclerMainAlquran);

        getData();


    }

    private void getData(){
        new client();
        Service api = client.createService(Service.class);
        api.getSurah().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                results = response.body().getData();
                init();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }

    private void init(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        AdapterAlquran adapterAlquran = new AdapterAlquran(getApplicationContext(), results);
        recyclerView.setAdapter(adapterAlquran);

    }
}
