package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        System.out.println("task02-->"+ogrcSayisi110AzMi(unv));
        System.out.println("\n   ***   ");


    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv) {
        return unv.stream().allMatch(t -> t.getNotOrt() > 74);//allmatch -->eğer bır tane bıle 74 ten kucuk varsa false verır.
        // hepsi istenen durumu saglarsa true doner && operatoru gıbı


    }

    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.

    public static boolean ogrcSayisi110AzMi(List<Universite> unv) {
        return unv.stream().anyMatch(t-> t.getOgrSayisi()<110);//anymatch--> eğer bır tane bıle 110 dan kucuk varsa true doner.
        // sadece bır tanesının ıstenen durumu sağlaması true donmesı ıcın yeterlı || operatoru gıbı
    }
}
