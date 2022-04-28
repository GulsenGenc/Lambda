package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        /*
	 	1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
	 	   Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
	       Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
	 	   Lambda’lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
	   	   Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

	 		"Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
	 	2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
	 	3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
	     	ve hatasiz code yazma acilarindan cok faydalidir.
	 	4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
           Lambda kullanmak hatasız code kullanmaktır.

            Collections Nedir?
            Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
            yapar. Array’ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
            yaptığı gibi, daha fazlasını da yapar.
            Java’da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
            topluluğu bir arada tutan bir yapıdır. ‘Collections Framework’ ise arayüzler ve onların kurgularından
            (implementations) oluşur.
	 */
        List<Integer> sayı = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));
        printEtStructured(sayı);
        System.out.println("***");
        printEtFunctıonal(sayı);
        System.out.println("***");
        printEtFunctıonal1(sayı);
        System.out.println("***");
        printEtFunctıonal2(sayı);
        System.out.println("***");
        printCiftEtStructured(sayı);
        System.out.println("***");
        printCiftEtFunctional(sayı);
        //Task : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    }
    public static void printEtStructured(List<Integer> sayı) {
        for (Integer w : sayı
        ) {
            System.out.print(w + " ");
        }
    }
    //Task : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printEtFunctıonal(List<Integer> sayı) {
        sayı.stream().forEach(t -> System.out.print(t + " "));
    }
     /*
        stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
        forEach() :datanin parametresine gore her bir elemanı isler
        t-> : Lambda operatoru
         Lambda Expression-->(parameter list) -> {action body}
             Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
             -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
             Body: Expressionları ve statementları içerir.

            Bir kod bloğundan oluşan bir body...
            Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
            Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

                () -> {
                 double pi = 3.1415;
                    return pi;
                };
         Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

        */

    public static void printEtFunctıonal1(List<Integer> sayı) {
        sayı.stream().forEach(System.out::print);//method referance --> System.out yapısından prınt methodu refere et
    }

    public static void yazdır(int a) {//verılen ınt değeri yazdırma actıon yapan sead(tohum ) method create edildi.
        System.out.print(a + " ");
    }

    public static void printEtFunctıonal2(List<Integer> sayı) {
        sayı.stream().forEach(Lambda01::yazdır);//istediğimiz şekıl için kendı methodumuzu create edıp burada refere olarak kullandık


    }

    // Task : structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftEtStructured(List<Integer> sayı){
        for (Integer w:sayı
             ) {
            if (w%2==0){
                System.out.print(w+" ");
            }
        }
    }

    //Task : functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftEtFunctional(List<Integer> sayı){
        sayı.stream().filter(t-> t%2==0).forEach(Lambda01::yazdır);
    }

    public static boolean ciftBul(int a) {//seed(tohum) method kendisine verile int degerin cift olmasını kontrol eder
        return a % 2 == 0;
    }

    public static void printCiftElFunctional2(List<Integer> sayı) {
        sayı.stream().filter(Lambda01::ciftBul).forEach(Lambda01::yazdır);
    }


    //Task : functional Programming ile list elemanlarinin 34 den kucuk cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtzKckFunctional(List<Integer> sayı) {

        sayı.stream().filter(Lambda01::ciftBul).filter(t-> t<34).forEach(Lambda01::yazdır);
    }

//Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtzBykFunctional(List<Integer> sayı) {
        sayı.stream().filter(t-> t%2==0 || t>34).forEach(Lambda01::yazdır);
    }


    public static void yazdırDouble(Double x) {
        System.out.print(x+" ");
    }
}
