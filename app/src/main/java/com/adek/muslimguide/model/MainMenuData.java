package com.adek.muslimguide.model;

/**
 * Created by Adek on 28/02/2018.
 */

public class MainMenuData {

        private String judul;
        private int gambar;

        public String getJudul(){
            return judul;
        }

        public int getGambar(){
            return gambar;
        }

        public MainMenuData(String judul, int gambar){
            this.judul = judul;
            this.gambar = gambar;
        }
    }
