package okulYonetimi;

import java.util.ArrayList;

public class Ogretmen extends Kisi{
    private String bolum;
    private String sicilNo;
    private static ArrayList<Ogretmen> ogrtListesi = new ArrayList<>();

    public Ogretmen() {

    }

    public Ogretmen(String adSoyad, String kimlikNo, int yas,String bolum, String sicilNo) {
        super(adSoyad, kimlikNo, yas);
        this.bolum = bolum;
        this.sicilNo = sicilNo;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }

    public static ArrayList<Ogretmen> getOgrtListesi() {
        return ogrtListesi;
    }

    protected static void setOgrtListesi(ArrayList<Ogretmen> ogrtListesi) {
        Ogretmen.ogrtListesi = ogrtListesi;
    }
    protected static void ogretmenEkle(Ogretmen ogretmen) {
        Ogretmen.ogrtListesi.add(ogretmen);
    }
    protected static void ogretmenSil(Ogretmen ogretmen) {
        Ogretmen.ogrtListesi.remove(ogretmen);
    }
    protected static void ogretmenListesiniYazdir(){
        System.out.printf("%-25s %-15s %-5s %-15s %-5s\n","AD SOYAD","TC KIMLIK","YAS","SICIL NO","BOLUM");

//        System.out.println("AD SOYAD" +"\t" +"TC KIMLIK NO" +"\t" + "YAS" +"\t" +
//                "SICIL NO" +"\t"+ "BOLUM");

        for (Ogretmen each: ogrtListesi
        ) {
            System.out.printf("%-25s %-15s %-5s %-15s %-5s\n",each.getAdSoyad(),each.getKimlikNo(),
                    each.getYas(),each.getSicilNo(),each.getBolum());
//            System.out.println(each.getAdSoyad() +"\t" +each.getKimlikNo() +"\t" + each.getYas() +"\t" +
//                    each.getSicilNo() +"\t"+ each.getBolum());
        }
    }

}
