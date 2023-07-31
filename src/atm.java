import java.util.Scanner;

public class atm {
    static String kartNo="123456";
    static  String sifre="1234";
    static Scanner scan=new Scanner(System.in);
    static double bakiye=50000;

    public static void main(String[] args) {
         giris();
    }

    public static void giris() {

        System.out.print("KART NUMARASI GIRINIZ : ");
        String kkartNo= scan.nextLine().replace(" ","");
        System.out.print("sifrenizi giriniz : ");
        String kSifre= scan.next();
        if (kkartNo.equals(kartNo) && kSifre.equals(sifre)){
            menu();
        }else{
            System.out.println("HATALI GIRIS YAPTINIZ...");
            giris();
        }
    }

    public static void menu() {
        System.out.print("*****BANK HUB*****\n" +
                "1.BAKIYE SORGULAMA\n" +
                "2.PARA YATIRMA \n" +
                "3.PARA CEKME\n" +
                "4.PARA GONDERME\n" +
                "4.SIFRE DEGISTIRME\n" +
                "5.CIKIS\n" +
                "SECIM : ");
        int secim = scan.nextInt();
        switch (secim) {
            case 1: {
                bakiyeSorgula();
            }
            case 2: {
                System.out.print("YATIRMAK ISTEDIGINIZ MIKTARI GIRINIZ : ");
                double miktar= scan.nextDouble();
                paraYatirma(miktar);
            }
            case 3: {
                System.out.print("CEKMEK ISTEDIGINIZ MIKTARI GIRINIZ : ");
               // double miktar= scan.nextDouble();
                paraCekme(scan.nextDouble());
            }
            case 4: {
                paraGonder();
            }
            case 5: {
                sifreDegistirme();
            }
            case 6: {
                System.out.println("BIZI SECTIGINIZ ICIN TESEKKURLER...");
                System.exit(0);
            }
            default:{
                System.out.println("YANLIS GIRIS YAPTINIZ...");
                menu();
            }
        }
    }

    public static void sifreDegistirme() {

        System.out.println("MEVCUT SIFREYI GIRINIZ : ");
        String kSifre=scan.next();
        if (kSifre.equals(sifre)){
            System.out.print("YENI SIFRE GIRINIZ : ");
            sifre=scan.nextLine();
            giris();
        }else {
            System.out.println("HATALI GIRIS YAPILDI...");
            sifreDegistirme();
        }
    }

    public static void paraGonder() {
        scan.nextLine(); //dummy
        System.out.print("PARA GONDERILECEK IBANI GIRINIZ : ");
        String iban= scan.nextLine().toUpperCase().replace(" ","");
        if (iban.startsWith("TR") && iban.length()==26){
            System.out.print("GONDERILECEK MIKTARI GIRINIZ : ");
            double miktar= scan.nextDouble();
            if (miktar <= bakiye) {
                bakiye -= miktar;
                bakiyeSorgula();
            }else {
                System.out.println("BAKIYENIZ YETERSIZ...");
                menu();
            }
        }else {
            System.out.println("HATALI GIRDINIZ...");
            menu();
        }
    }
    public static void paraCekme(double miktar) {
        if (miktar<=bakiye){
            bakiye-=miktar;
            bakiyeSorgula();
        }else {
            System.out.print("BAKIYEDEN BUYUK MIKTAR CEKEMEZSINIZ...\n"+
                               "MIKTARI GIRINIZ :");
            double yeniMiktar= scan.nextDouble();
            paraCekme(yeniMiktar);
        }
    }

    public static void paraYatirma(double miktar) {
        bakiye+=miktar;
        bakiyeSorgula();
    }
    public static void bakiyeSorgula() {
        System.out.println("BAKIYE : "+bakiye+" $");
        menu();
    }

}
