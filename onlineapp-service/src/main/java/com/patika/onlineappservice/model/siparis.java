package com.patika.onlineappservice.model;

import java.util.ArrayList;
import java.util.List;

public class Siparis {
    private List<Urun> urunler;
    private Fatura fatura;

    public Siparis() {
        this.urunler = new ArrayList<>();
    }

    public void urunEkle(Urun urun) {
        urunler.add(urun);
    }

    public List<Urun> getUrunler() {
        return urunler;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public double toplamTutarHesapla() {
        double toplam = 0;
        for (Urun urun : urunler) {
            toplam += urun.getFiyat();
        }
        return toplam;
    }
}
