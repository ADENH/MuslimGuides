package com.adek.muslimguide.model;

/**
 * Created by Adek on 03/03/2018.
 */

public class ListSuratAlquran {
    private String surah;
    private int nosurah;

    public String getSurah(){
        return surah;
    }

    public int getNosurah(){
        return nosurah;
    }

    public ListSuratAlquran(String surah, int nosurah){
        this.surah = surah;
        this.nosurah = nosurah;
    }
}
