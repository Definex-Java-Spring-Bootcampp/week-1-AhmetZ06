package com.patika.onlineappservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class onlineappServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(onlineappServiceApplication.class, args);
    
        List<Musteri> musteriler = new ArrayList<>();
    
        Musteri musteri1 = new Musteri("Cem", 28);
        Musteri musteri2 = new Musteri("Elif", 30);
        Musteri musteri3 = new Musteri("Ahmet", 26);
        Musteri musteri4 = new Musteri("Mehmet", 50);
    
    
        Urun urun1 = new Urun("Laptop", "Elektronik", 10000, 20);
        Urun urun2 = new Urun("Telefon", "Elektronik", 5000, 20);
        Urun urun3 = new Urun("Şarj Aleti", "Elektronik", 2000, 25);
        Urun urun4 = new Urun("Airtag", "Elektronik", 1000, 15);
    
        Siparis siparis1 = new Siparis();
        siparis1.urunEkle(urun1);
        siparis1.urunEkle(urun2);
        siparis1.setFatura(new Fatura(siparis1.toplamTutarHesapla()));


        Siparis siparis2 = new Siparis();
        siparis2.urunEkle(urun1);
        siparis2.urunEkle(urun2);
        siparis2.urunEkle(urun3);
        siparis2.urunEkle(urun4);
        siparis2.setFatura(new Fatura(siparis2.toplamTutarHesapla()));
    
    
        
        Siparis siparis3 = new Siparis();
        siparis3.urunEkle(urun2);
        siparis3.urunEkle(urun3);
        siparis3.urunEkle(urun4);
        siparis3.setFatura(new Fatura(siparis2.toplamTutarHesapla()));
    
    
        Siparis siparis4 = new Siparis();
        siparis4.urunEkle(urun1);
        siparis4.urunEkle(urun3);
        siparis4.urunEkle(urun4);
        siparis4.setFatura(new Fatura(siparis2.toplamTutarHesapla()));
    
    
        musteri1.siparisEkle(siparis1);
        musteri2.siparisEkle(siparis2);
        musteri1.siparisEkle(siparis3);
        musteri2.siparisEkle(siparis4);

        musteri3.siparisEkle(siparis3);
        musteri4.siparisEkle(siparis4);
    

        musteriler.add(musteri1);
        musteriler.add(musteri2);
        musteriler.add(musteri3);
        musteriler.add(musteri4);

        int toplamMusteriSayisi = musteriler.size();

        // İsmi Cem olan müşterilerin aldıkları ürün sayısını bulmak için

        int cemUrunSayisi = musteriler.stream()
            .filter(musteri -> "Cem".equals(musteri.getIsim()))
            .flatMapToInt(musteri -> musteri.getSiparisler().stream().mapToInt(siparis -> siparis.getUrunler().size()))
            .sum();

        // İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarını hesplam içn
        
        double cemToplamAlisverisTutari = musteriler.stream()
            .filter(musteri -> "Cem".equals(musteri.getIsim()) && musteri.getYas() > 25 && musteri.getYas() < 30)
            .flatMapToDouble(musteri -> musteri.getSiparisler().stream().mapToDouble(siparis -> siparis.getFatura().getToplamTutar()))
            .sum();

        // Sistemdeki 1500 TL üzerindeki faturaları listemek için
        List<Fatura> yuksekFaturalar = musteriler.stream()
            .flatMap(musteri -> musteri.getSiparisler().stream())
            .map(Siparis::getFatura)
            .filter(fatura -> fatura.getToplamTutar() > 1500)
            .collect(Collectors.toList());    


            System.out.println("Toplam müşteri sayısı: " + toplamMusteriSayisi);
            System.out.println("İsmi Cem olan müşterilerin aldıkları ürün sayısı: " + cemUrunSayisi);
            System.out.println("İsmi Cem olan ve yaşı 25 ile 30 arasında olan müşterilerin toplam alışveriş tutarı: " + cemToplamAlisverisTutari + " TL");
            System.out.println("1500 TL üzerindeki faturalar:");
            yuksekFaturalar.forEach(fatura -> System.out.println(fatura.getToplamTutar() + " TL"));
        }
    }


    

}

