package okulYonetimi;

import java.util.ArrayList;
import java.util.List;

public class Ogrenci extends Kisi{
    private String ogrcNo;
    private static int ogrenciNoSabiti = 100;
    private String sinif;
    private static List<Ogrenci> ogrncListesi = new ArrayList<>();

    public Ogrenci() {
    }

    public Ogrenci(String adSoyad, String kimlikNo, String ogrcNo, int yas, String sinif) {
        super(adSoyad, kimlikNo, yas);
        this.ogrcNo = ogrcNo;
        this.sinif = sinif;
    }

    public static String ogrenciNoOlusturucu() {
        String ogrenciNo = (ogrenciNoSabiti++) + "";
        return ogrenciNo;
    }

    public String getOgrcNo() {
        return ogrcNo;
    }

    public void setOgrcNo(String ogrcNo) {
        this.ogrcNo = ogrcNo;
    }

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    public static List<Ogrenci> getOgrncListesi() {
        return ogrncListesi;
    }

    public static void setOgrncListesi(List<Ogrenci> ogrncListesi) {
        Ogrenci.ogrncListesi = ogrncListesi;
    }

    protected static void ogrenciEkle(Ogrenci ogrenci) {
        Ogrenci.ogrncListesi.add(ogrenci);
    }

    protected static void ogrenciSil(Ogrenci ogrenci) {
        Ogrenci.ogrncListesi.remove(ogrenci);
    }

    protected static void ogrenciListesiniYazdir() {

        System.out.printf("%-20s %-15s %-5s %-12s %-5s\n","AD SOYAD","TC KIMLIK","YAS","OGRENCI NO","SINIF");

//        System.out.println("AD SOYAD" + "\t"+ "\t" + "TC KIMLIK NO" + "\t"+ "\t" + "YAS" + "\t"+ "\t" +
//                "OGRECI NO" + "\t"+ "\t" + "SINIF");

        for (Ogrenci each : ogrncListesi
        ) {
            {

                System.out.printf("%-20s %-15s %-5s %-12s %-5s\n",each.getAdSoyad(),each.getKimlikNo(),
                        each.getYas(),each.getOgrcNo(),each.getSinif());
//                System.out.println(each.getAdSoyad() + "\t"+ "\t" + each.getKimlikNo() + "\t"+ "\t"+ "\t" + each.getYas() + "\t"+ "\t" +
//                        each.getOgrcNo() + "\t"+ "\t"+ "\t" + each.getSinif());
            }
        }
    }

}
