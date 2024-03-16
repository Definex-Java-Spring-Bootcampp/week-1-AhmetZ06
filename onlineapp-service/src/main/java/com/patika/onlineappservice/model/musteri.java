package com.patika.onlineappservice.model;


import java.util.ArrayList;
import java.util.List;

public class Musteri {
    private String isim;
    private int yas;
    private List<Siparis> siparisler;

    public Musteri(String isim, int yas) {
        this.isim = isim;
        this.yas = yas;
        this.siparisler = new ArrayList<>();
    }

    // Getter ve Setter metotları
    public String getIsim() {
        return isim;
    }

    public int getYas() {
        return yas;
    }

    public List<Siparis> getSiparisler() {
        return siparisler;
    }

    public void siparisEkle(Siparis siparis) {
        siparisler.add(siparis);
    }
}
