package day02;

import day01.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(3, 2, 6, 1, -5, 7));
        System.out.println("çiftlerin karesi\n");
        printCıftlerınKaresı(sayi);
        System.out.println("\nteklerin kübünün 1 fazlası\n");
        printTeklerinKübünün1Fazlası(sayi);
        System.out.println("\nçiftlerın karekoku\n");
        ciftKarekokPrint(sayi);
        maxElBul(sayi);
        System.out.println("\nçift sayıların karekokunun max olanı\n");
        ciftKarteMaxBul(sayi);
        System.out.println("\n**");
        elTopla(sayi);
        System.out.println("\n**");
        ciftCarp(sayi);

    }
    // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz
    public static void printCıftlerınKaresı(List<Integer> sayi ) {
        sayi.stream().filter(Lambda01::ciftBul).map(t-> t*t).forEach(Lambda01::yazdır);

        //map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
    }

    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edin

    public  static  void printTeklerinKübünün1Fazlası(List<Integer> sayi ){
        sayi.stream().//elemanlar akışa alındı
                filter(t-> t%2==1).//tek elemanlar fıltrelendı
                map(t-> t*t*t+1).//tek elemanların küpleri alındı
                forEach(Lambda01::yazdır);//print edildi
    }

    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarekokPrint(List<Integer> sayi) {
        sayi.stream().//akışa sunduk
                filter(Lambda01::ciftBul).//çift sayıları fıltreledık
                map(Math::sqrt).//Math sınıfından karekok alma methodu refere edıldı
                forEach(Lambda01::yazdırDouble);// sqrt methodu double dondurdugu ıcın ,yazdır double dıye method create ettık
    }

    // Task : list'in en buyuk elemanini yazdiriniz

    public static void maxElBul(List<Integer> sayi){

       Optional<Integer> maxSayı= sayi.stream().reduce(Math::max);//akışa gıren elemanları aksıyon sonrası tek bır eleman dondurur
        System.out.print("listtekı max eleman-->"+maxSayı);

        /*
        reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
        kullanımı yaygındır pratiktir.
        Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
        bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
        reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
        reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
        İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

        */
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKarteMaxBul(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max));

        System.out.println("daha hızlı specific ınteger class : " + sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));//36 specific class daha hızlı run olur
    }

    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...
    public static void elTopla(List<Integer> sayi){
       int toplam= sayi.stream().reduce(0,(a,b)->a+b);//lambda expression
         /*
        a ilk degerini her zaman atanan degerden (identity) alır
        b degerini her zamana  stream()'dan akısdan alır
        a ilk degerinden sonraki her değeri action(işlem)'dan alır

               */
        System.out.println("Lambda expression ile toplam = " + toplam);

        System.out.println("method referans ile toplam-->"+sayi.stream().reduce(Integer::sum));//method referans ıle
    }

    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftCarp(List<Integer> sayi){
       int carpım= sayi.stream().filter(Lambda01::ciftBul).reduce(1,(a,b)->a*b);//lambda expression ile
        System.out.println("lambda expression ıle çarpım--> " + carpım);
        System.out.println("method referession ile çarpım-->"+sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));

    }

    }
