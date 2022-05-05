package day04;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    public static void main(String[] args) {
 /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */

        Universite bogazici = new Universite("Boğaziçi", "matematik", 571, 89);
        Universite itü = new Universite("itü", "matematik", 622, 81);
        Universite marmara = new Universite("marmara", "hukuk", 567, 82);
        Universite istanbul = new Universite("istanbul", "bılgısayar muh", 1453, 86);
        Universite ytu = new Universite("ytü", "gemi", 109, 88);

        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, istanbul, itü, marmara, ytu));

        System.out.println("\n   ***   ");
        System.out.println("task01-->" + notOrt74BykUnv(unv));
        System.out.println("\n   ***   ");
        System.out.println("task02-->" + ogrcSayisi110AzMi(unv));
        System.out.println("\n   ***   ");
        System.out.println("task03-->" + matBolumVarmi(unv));
        System.out.println("\n   ***   ");
        System.out.println("task04-->" + ogrSayiBkSirala(unv));
        System.out.println("\n   ***   ");
        ogrSayiBkSiralavoid(unv);
        System.out.println("\n   ***   ");
        System.out.println("task05-->" + notOrtBkSialiIlkUc(unv));
        System.out.println("\n   ***   ");
        System.out.println("task06-->" + enAzOgrcSaysi2Unv(unv));
        System.out.println("\n   ***   ");
        System.out.println("task 7: " + notOrt63BykUnvOgrcSayisiTopla(unv));
        System.out.println("\n   ***   ");
        System.out.println("mapToInt ile : " + notOrt63BykUnvOgrcSayisiToplaToInt(unv));
        System.out.println("\n   ***   ");
        System.out.println("task 8 : " + ogrcSayisi333BykNotOrtOrtlamaAl(unv));
        System.out.println("\n   ***   ");
        System.out.println("task09-->" + mathBolmSayısı(unv));
        System.out.println("\n   ***   ");
        System.out.println("task10-->" + ogrcSayisi571BykMaxNotort(unv));
        System.out.println("\n   ***   ");
        System.out.println("task11-->"+ogrcSayisi1071AzMinnotOrt(unv));


    }


    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv) {
        return unv.stream().allMatch(t -> t.getNotOrt() > 74);//allmatch -->eğer bır tane bıle 74 ten kucuk varsa false verır.
        // hepsi istenen durumu saglarsa true doner && operatoru gıbı


    }

    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.

    public static boolean ogrcSayisi110AzMi(List<Universite> unv) {
        return unv.stream().anyMatch(t -> t.getOgrSayisi() < 110);//anymatch--> eğer bır tane bıle 110 dan kucuk varsa true doner.
        // sadece bır tanesının ıstenen durumu sağlaması true donmesı ıcın yeterlı || operatoru gıbı
    }

    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matBolumVarmi(List<Universite> unv) {
        return unv.stream().anyMatch(t -> t.getBolum().equalsIgnoreCase("Matematik"));
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayiBkSirala(List<Universite> unv) {
        return unv.stream().//akışa alındı
                sorted(Comparator.comparing(Universite::getOgrSayisi).//methode reference ıle ogrencı sayısına gore objelerı kucukten buyuge sıraladı
                reversed()).//ter sıra yaptı
                collect(Collectors.toList()); //list içine topladı elemanları
    }

    public static void ogrSayiBkSiralavoid(List<Universite> unv) {
        System.out.println(unv.stream().sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).collect(Collectors.toList()));
        //collect()->akısdaki elamanları istenen sarta gore elınde tutar
        //Collectors.toList()->collect'e toplanan elemanlari list'e cevirir

    }

    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static List<Universite> notOrtBkSialiIlkUc(List<Universite> unv) {
        return unv.stream().sorted(Comparator.comparing(Universite::getNotOrt).reversed()).
                limit(3).//ilk 3 elemanı aldı sadece
                        collect(Collectors.toList());//aldıgımız elemanları listte topladık .

    }

    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.

    public static List<Universite> enAzOgrcSaysi2Unv(List<Universite> unv) {
        return unv.stream().sorted(Comparator.comparing(Universite::getOgrSayisi)).limit(2).skip(1).collect(Collectors.toList());

    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz.
    public static int notOrt63BykUnvOgrcSayisiTopla(List<Universite> unv) {
        return unv.stream().
                filter(t -> t.getNotOrt() > 63).
                map(t -> t.getOgrSayisi()).
                //reduce(Math::addExact)-->Math classından method reference
                //reduce(Integer::sum);-->Integer classından method reference
                        reduce(0, (t, u) -> t + u);//-->lambda expressıon

    }

    public static int notOrt63BykUnvOgrcSayisiToplaToInt(List<Universite> unv) {
        return unv.stream().
                filter(t -> t.getNotOrt() > 63).
                mapToInt(t -> t.getOgrSayisi())//akışa aldıgı elemanları integerda tutar
                .sum();//ıntegerdakı elemanları toplama methodu(sum) bu sayede dırek gelıyor


    }

    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static OptionalDouble ogrcSayisi333BykNotOrtOrtlamaAl(List<Universite> unv) {
        return unv.stream().filter(t -> t.getOgrSayisi() > 333).
                mapToDouble(t -> t.getNotOrt()).//elemanları double data type ında tutar
                        average();//akısdaki elemanların ortlaması alındı
        // mapToDouble() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki degere göre dooble data type update eder

    }

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int mathBolmSayısı(List<Universite> unv) {
        return (int) unv.stream().filter(t -> t.getBolum().equalsIgnoreCase("matematik")).count();
    }

    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi571BykMaxNotort(List<Universite> unv) {
        return unv.stream().filter(t -> t.getOgrSayisi() > 571).
                mapToInt(t -> t.getNotOrt()).//akısdaki unv obj notOrt akısı olarak update edildi
                        max();   //akısın en byk degerini return eder

    }

    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi1071AzMinnotOrt(List<Universite> unv) {
        return unv.
                stream().filter(t -> t.getOgrSayisi() < 1071).mapToInt(t -> t.getNotOrt()).min();

    }
}
