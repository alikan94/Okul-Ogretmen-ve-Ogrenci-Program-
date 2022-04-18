package okulYonetimi;

import java.util.Scanner;

public class Kisi {
    private String adSoyad;
    private String kimlikNo;
    private int yas;

    static Scanner scan = new Scanner(System.in);

    public Kisi() {
    }

    public Kisi(String adSoyad, String kimlikNo, int yas) {
        setAdSoyad(adSoyad);
        setKimlikNo(kimlikNo);
        setYas(yas);
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad.toUpperCase();
    }

    public String getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(String kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        if (yas < 0) {
            this.yas = -yas;
        } else {
            this.yas = yas;
        }
    }

    public static String kimlikNoEkle() {
        String kimlikNo = "";
        boolean gecersizGirisMi = true;
        String alfabe = "qwertyuıopğüasdfghjklşizxcvbnmöç";
        do {
            System.out.print("KIMLIK NO GIRINIZ : ");
            kimlikNo = scan.next();
            if (!(kimlikNo.length() == 11)) {
                System.out.println("Gecersiz uzunluk... ");
            } else {
                int kontrol = 0;
                for (int i = 0; i < kimlikNo.length(); i++) {
                    if ((kimlikNo.charAt(i) < 'Z' || kimlikNo.charAt(i) > 'a')) {

                    } else kontrol++;
                }
                if (kontrol == 0) {
                    gecersizGirisMi = false;
                } else {
                    System.out.println("Gecersiz karakter girdiniz. sadece rakam girilmelidir.");
                }

            }
        } while (gecersizGirisMi);

        return kimlikNo;
    }
    protected static int yasEkle(){
        int yas = 0;
        boolean gecersizGirisMi = true;
        do {
            System.out.print("YAS GIRINIZ : ");
            try {
                scan.nextLine();
                yas = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Lutfen sadece rakam giriniz.");
            }
            if (yas<0 || yas >120) {
                System.out.println("Gecersiz yas girdiniz... ");
            } else {
                gecersizGirisMi=false;
            }
        } while (gecersizGirisMi);


        return yas;
    }

}
