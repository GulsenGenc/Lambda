package day03;

import day01.Lambda01;
import day02.Lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menü = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe", "havucDilim", "buryan",
                "yaglama", "kokareç", "arabAşı", "güveç", "trileçe", "trileçe", "trileçe", "whaffle"));
        alfBykTekrrsz(menü);
        System.out.println("***\n");
        chrSayisiTersSirali(menü);
        System.out.println("***\n");
        chrSayisiBkSirala(menü);
        System.out.println("***\n");
        sonHrfBkSirala(menü);
        System.out.println("***\n");
        ciftlerınKaresıSıralaByktnKcgeTkrarsz(menü);
        System.out.println("***\n");
        char7denAzKontrol(menü);
        System.out.println("***\n");
        wIleBaslayanElKontrol(menü);
        System.out.println("***\n");
        xIleBıtenElKontrol(menü);
        System.out.println("***\n");
        charSayisiBykElPrint(menü);
        ilkElHarcSnHarfSıralıPrınt(menü);


    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrrsz(List<String> yemek) {
        yemek.stream().
                // map(t-> t.toUpperCase()).//elemanlar buyuk harfe update edıldı lamba expressıon
                        map(String::toUpperCase). //method reference ıle
                sorted().//doğal sıralama yanı alfebetık sıralama yaptı
                distinct().//benzersız yada tekrarsız hale getırdı
                forEach(t -> System.out.print(t + " "));//yazdırıldı

        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }


    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSirali(List<String> menü) {
        menü.stream().map(t -> t.length()).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::yazdır);
    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBkSirala(List<String> menü) {
        menü.stream().sorted(Comparator.comparing(String::length)).forEach(t -> System.out.print(t + " "));
    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHrfBkSirala(List<String> menü) {
        menü.stream().sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length() - 1)).reversed()).forEach(t -> System.out.print(t + " "));
    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
    public static void ciftlerınKaresıSıralaByktnKcgeTkrarsz(List<String> menü) {
        menü.stream().filter(t -> t.length() % 2 == 0).map(t -> t.length() * t.length()).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::yazdır);
        //baska bır yontemle-->
        menü.stream().map(t -> t.length() * t.length()).filter(Lambda01::ciftBul).distinct().sorted(Comparator.reverseOrder()).forEach(Lambda01::yazdır);
    }

    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void char7denAzKontrol(List<String> menü) {
        boolean kontrol = menü.stream().allMatch(t -> t.length() < 7);
        if (kontrol) {
            System.out.println("list elemanları 7 ve daha az harften olusuyor");
        } else {
            System.out.println("list elemanları 7 harften buyuk değil");
        }
        //daha clean code ıle -->
        System.out.println(menü.stream().allMatch(t -> t.length() <= 7) ? "list elemanları 7 ve daha az harften olusuyor" : "list elemanları 7 harften buyuk değil");
        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
    }

    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> menü) {
        System.out.println(menü.stream().anyMatch(t -> t.startsWith("w")) ? "w ile başlayan yemek menude vardır." : "w ile baslayan yemek menude yoktur");
    }

    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBıtenElKontrol(List<String> menü) {
        System.out.println(menü.stream().anyMatch(t -> t.endsWith("x")) ? "x ile biten yemek menude vardır." : "x ile biten yemek menude yoktur");
    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSayisiBykElPrint(List<String> menü) {
        System.out.println(menü.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).findFirst());
        System.out.println(menü.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).limit(1));


        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
      // şekilde kesilmiş bir akış return eder. Stream return eder.
//limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır.
    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHarcSnHarfSıralıPrınt(List<String> menü) {
        menü.stream(). //akışa alındı
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).//son harfe gore sıralandı
                skip(1).//ilk elemanı atladı
                forEach(t -> System.out.print(t + " "));//yazdırıldı

        //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
// Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
//skip(list.size()-1) => List’in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.

    }


}
