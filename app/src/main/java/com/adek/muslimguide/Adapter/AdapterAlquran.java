package com.adek.muslimguide.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adek.muslimguide.Pojo.Alquran.Surah;
import com.adek.muslimguide.R;

import java.util.List;

/**
 * Created by Adek on 03/03/2018.
 */

public class AdapterAlquran extends RecyclerView.Adapter<AdapterAlquran.ViewHolder> {
    private Context contextalquran;
    private List<Surah> results;

    public AdapterAlquran(Context context, List<Surah> alquran){
        this.contextalquran=context;
        this.results = alquran;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contextalquran).inflate(R.layout.menualquran,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.SurahLatin.setText(results.get(position).getEnglishName());
        holder.SurahArab.setText(results.get(position).getName());



    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView SurahLatin,SurahArab;
        public ViewHolder(View itemView) {
            super(itemView);
            SurahLatin = itemView.findViewById(R.id.latin_surah);
            SurahArab = itemView.findViewById(R.id.arab_surah);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                }
            });
        }
    }
}
