package com.adek.muslimguide.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adek.muslimguide.Pojo.Alquran.Ayah;
import com.adek.muslimguide.Pojo.Alquran.Data;
import com.adek.muslimguide.R;
import com.adek.muslimguide.activity.Alquran.AyatAlquranActivity;

import java.util.List;

/**
 * Created by Adek on 10/03/2018.
 */

public class AdapterSurah extends RecyclerView.Adapter<AdapterSurah.ViewHolder> {
    private Context contextayah;
    private List<Ayah> results;
    private List<Ayah> result2;

    public AdapterSurah (Context context, List<Ayah> ayah,List<Ayah> ayahtranslate){
        this.contextayah=context;
        this.results = ayah;
        this.result2 = ayahtranslate;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(contextayah).inflate(R.layout.ayatalquran,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tulisanArab.setText(results.get(position).getText());
        holder.tulisanLatin.setText(result2.get(position).getText());

    }

    @Override
    public int getItemCount() {
        if(results == null)
            return 0;
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tulisanArab,tulisanLatin;
        public ViewHolder(View itemView) {
            super(itemView);
            tulisanArab = itemView.findViewById(R.id.tulisanalquran);
            tulisanLatin = itemView.findViewById(R.id.tulisanlatin);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();

                }
                });

            }
        }
    }
