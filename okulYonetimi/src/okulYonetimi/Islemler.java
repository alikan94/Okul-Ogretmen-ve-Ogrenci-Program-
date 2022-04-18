package okulYonetimi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Islemler {
    static Scanner scan = new Scanner(System.in);
    static String secim;
    static String kisiTuru;
    protected static List<Ogrenci> liste = new ArrayList<>();


    public static void karsilamaMenusu() {
        System.out.println("====================================");
        System.out.println("===== Ogrenci Ogretmen Paneli ======");
        System.out.println("=========== Hosgeldiniz ============");
        System.out.println("====================================");
        System.out.println("== 1 - Ogrenci Islemleri          ==");
        System.out.println("== 2 - Ogretmen Islemleri         ==");
        System.out.println("== E - Cikis                      ==");
        secim = scan.next().toUpperCase();

        switch (secim) {
            case "1":
                kisiTuru = "OGRENCI";
                islemMenusu();
                break;
            case "2":
                kisiTuru = "OGRETMEN";
                islemMenusu();
                break;
            case "E":
                cikis();
                break;
            default:
                System.out.println("====================================");
                System.out.println("== Hatali giris yaptiniz...       ==");
                karsilamaMenusu();
        }


    }

    private static void islemMenusu() {
        System.out.println("== " + kisiTuru + " ISLEM MENUSU");
        System.out.println("============= ISLEMLER =============");
        System.out.println("====================================");
        System.out.println("== 1 - Ekleme                     ==");
        System.out.println("== 2 - Arama Yapma                ==");
        System.out.println("== 3 - Listele                    ==");
        System.out.println("== 4 - Silme                      ==");
        System.out.println("== 0 - Ana Menuye Don             ==");
        secim = scan.next();
        switch (secim) {
            case "1":
                ekle();
                islemMenusu();
                break;
            case "2":
                aramaYap();
                islemMenusu();
                break;
            case "3":
                listele();
                islemMenusu();
                break;
            case "4":
                sil();
                islemMenusu();
                break;
            case "0":
                karsilamaMenusu();
                break;

            default:
                System.out.println("====================================");
                System.out.println("== Hatali giris yaptiniz...       ==");
                islemMenusu();
        }


    }

    private static void sil() {
        System.out.println("== " + kisiTuru + " SILME EKRANI");
        boolean flag = true;

        if (kisiTuru.equals("OGRENCI")) {
            scan.nextLine();
            System.out.println();
            System.out.println("= SILINECEK KIMLIK NO GIRINIZ : ");
            String arananKimlikNo=scan.nextLine();

            for (Ogrenci each: Ogrenci.getOgrncListesi()) {

                if (each.getKimlikNo().equals(arananKimlikNo)){
                    System.out.println("Silinen ogrenci : " + each.getAdSoyad());
                    Ogrenci.ogrenciSil(each);
                    flag=false;
                    break;
                }
            }
            if (flag){
                System.out.println("= BULUNAMADI");
            }
        } else {
            scan.nextLine();
            System.out.println();
            System.out.println("= SILINECEK KIMLIK NO GIRINIZ : ");
            String arananKimlikNo=scan.nextLine();

            for (Ogretmen each: Ogretmen.getOgrtListesi()) {

                if (each.getKimlikNo().equals(arananKimlikNo)){
                    System.out.println("Silinen ogretmen : " + each.getAdSoyad());
                    Ogretmen.ogretmenSil(each);
                    flag = false;
                    break;
                }
            }if (flag) {
                System.out.println("Arama basarisiz.");
            }
        }
    }

    private static void listele() {
        System.out.println("== " + kisiTuru + " LISTE EKRANI");
        if (kisiTuru.equals("OGRENCI")) {
            Ogrenci.ogrenciListesiniYazdir();
        } else {
            Ogretmen.ogretmenListesiniYazdir();
        }

    }

    private static void aramaYap() {
        System.out.println("== " + kisiTuru + " ARAMA EKRANI");
        boolean flag = true;

        if (kisiTuru.equals("OGRENCI")) {
            scan.nextLine();
            System.out.println();
            System.out.println("= OGRENCI KIMLIK NO GIRINIZ : ");
            String arananKimlikNo=scan.nextLine();

            for (Ogrenci each: Ogrenci.getOgrncListesi()) {

                if (each.getKimlikNo().equals(arananKimlikNo)){
                    System.out.println("Arananan ogrenci : " + each.getAdSoyad());
                    flag=false;
                }
            }
            if (flag){
                System.out.println("= BULUNAMADI");
            }
        } else {
            for (Ogretmen each: Ogretmen.getOgrtListesi()) {
                scan.nextLine();
                System.out.println();
                System.out.println("= OGRETMEN KIMLIK NO GIRINIZ : ");
                String arananKimlikNo=scan.nextLine();
                if (each.getKimlikNo().equals(arananKimlikNo)){
                    System.out.println("Arananan ogretmen : " + each.getAdSoyad());
                    flag = false;
                }
            }if (flag) {
                System.out.println("Arama basarisiz.");
            }
        }
    }

    private static void ekle() {
        System.out.println("== " + kisiTuru + " EKLEME EKRANI");
        System.out.println("= AD SOYAD GIRINIZ : ");
        scan.nextLine();
        String adSoyad = scan.nextLine().toUpperCase();
        String kimlikNo = Kisi.kimlikNoEkle();
        int yas = Kisi.yasEkle();

        if (kisiTuru.equals("OGRENCI")) {
            String ogrenciNo = Ogrenci.ogrenciNoOlusturucu();
            System.out.println("Ogrencinin numarasi = " + ogrenciNo);
            System.out.println("Ogrencinin sinifini giriniz: ");
            String sinif = scan.next();

            Ogrenci ogrenci = new Ogrenci(adSoyad, kimlikNo, ogrenciNo, yas, sinif);
            Ogrenci.ogrenciEkle(ogrenci);
            liste.add(ogrenci);
        } else {
            System.out.println("Ogretmenin Sicil Nosunu Giriniz = ");
            String sicilNo = scan.next().toUpperCase();
            System.out.println("Ogretmenin Bolumunu Giriniz: ");
            String bolum = scan.next().toUpperCase();
            Ogretmen ogretmen = new Ogretmen(adSoyad, kimlikNo, yas, bolum, sicilNo);
            Ogretmen.ogretmenEkle(ogretmen);
        }

    }

    protected static void cikis() {
        System.out.println("====================================");
        System.out.println("== Gine bekleriz... ================");
    }

}
