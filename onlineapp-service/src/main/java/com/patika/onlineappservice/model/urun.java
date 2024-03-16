package com.patika.onlineappservice.model;


public class Urun {
    private String isim;
    private String kategori;
    private double fiyat;
    private int stok;

    public Urun(String isim, String kategori, double fiyat, int stok) {
        this.isim = isim;
        this.kategori = kategori;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    public String getIsim() {
        return isim;
    }

    public String getKategori() {
        return kategori;
    }

    public double getFiyat() {
        return fiyat;
    }

    public int getStok() {
        return stok;
    }
}
