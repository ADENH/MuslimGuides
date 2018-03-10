package com.adek.muslimguide.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adek.muslimguide.R;
import com.adek.muslimguide.activity.Alquran.AlquranActivity;
import com.adek.muslimguide.model.MainMenuData;

import java.util.List;

/**
 * Created by Adek on 01/03/2018.
 */

public class AdapterMainMenu extends RecyclerView.Adapter<AdapterMainMenu.RecyclerViewHolder> {
    List<MainMenuData> values;
    Context context1;

    public AdapterMainMenu(Context context, List<MainMenuData> UserInformation){
        context1=context;
        values=UserInformation;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainmenu,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterMainMenu.RecyclerViewHolder holder,final int position) {
        holder.judul.setText(values.get(position).getJudul());
        holder.gambar.setImageResource(values.get(position).getGambar());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==0){
                    Intent intent = new Intent(context1, AlquranActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context1.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
        ImageView gambar;
        CardView cardView;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.cardview);
            judul=(TextView)itemView.findViewById(R.id.namaIcon);
            gambar=(ImageView)itemView.findViewById(R.id.namaGambar);
        }
    }
}
