package com.adek.muslimguide.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.adek.muslimguide.Adapter.AdapterMainMenu;
import com.adek.muslimguide.R;
import com.adek.muslimguide.model.MainMenuData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterMainMenu adapterMainMenu;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerMain);
        layoutManager = new GridLayoutManager(getApplicationContext(),3);
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(layoutManager);

        adapterMainMenu = new AdapterMainMenu(getApplicationContext(),getData());
        recyclerView.setAdapter(adapterMainMenu);

    }
    private List<MainMenuData> getData(){
        List<MainMenuData> data = new ArrayList<>();
        data.add(new MainMenuData("Al-Qur'an",R.drawable.ic_reading_quran));
        data.add(new MainMenuData("Arah Kiblat", R.drawable.ic_compass));
        data.add(new MainMenuData("Kegiatan", R.drawable.ic_calendar));
        data.add(new MainMenuData("Jadwal Sholat", R.drawable.ic_clock));
        data.add(new MainMenuData("Kumpulan Doa",R.drawable.ic_dua_hands));
        data.add(new MainMenuData("Tuntunan Sholat", R.drawable.ic_islamic_prayer));
        data.add(new MainMenuData("Tugas", R.drawable.ic_list));
        data.add(new MainMenuData("Mesjid", R.drawable.ic_mosque));
        data.add(new MainMenuData("Kisah Pahlawan Islam",R.drawable.ic_open_book));


        return data;
    }


}
