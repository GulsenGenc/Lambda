package day06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda06 {
    public static void main(String[] args) throws IOException {

        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        Path haluk = Path.of("src/day06/haluk.txt");//path haluk objeye atandı !!
        Stream<String> akıs = Files.lines(haluk);

        //1.yoll
        Files.lines(haluk).//Files class'dan lines() method call edilerek data
                // çekilecek dosya yolu(path)
                // paremetre girilerek path'deki dosyanın dataları akısa alındı
                        forEach(System.out::println);//akısdaki datalar(her satırdaki string)yazıldı)

        //2.yol
        akıs.forEach(System.out::println);

        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.lines(Paths.get("src/day06/haluk.txt")).map(String::toUpperCase).forEach(System.out::println);


        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        //1.yoll limit methodu ıle -->
        Files.lines(haluk).map(String::toLowerCase).limit(1).forEach(System.out::println);
        //2.yoll fınd fırst methodu ıle
        System.out.println(Files.lines(haluk).map(String::toLowerCase).findFirst());

        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.lines(haluk).map(String::toLowerCase).filter(t -> t.contains("basari")).count());

        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        Files.lines(haluk).map(t -> t.split(" ")).//her bır kelıme arraye atandı
                flatMap(Arrays::stream).//düz akışa alındı
                distinct().//benzersiz yapıldı
                forEach(System.out::println);//yazdırıldı..liste atanıp yazdırılabılırdı.

        /*
   Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
   fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
   Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.
   Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
   Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
   flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
   ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.
 */
        //2.yol toSet ile
        System.out.println(Files.lines(haluk).map(t -> t.split(" ")).flatMap(Arrays::stream).collect(Collectors.toSet()));


        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        Files.lines(haluk).map(t -> t.split(" ")).flatMap(Arrays::stream).sorted().forEach(System.out::println);

        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).filter(t -> t.equalsIgnoreCase("basari")).count());


        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).map(t -> t.split(" ")).flatMap(Arrays::stream).
                filter(t -> t.contains("a")).//içinde a gecenler filtrelendı
                count());

        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        Files.lines(haluk).map(t -> t.split(" ")).flatMap(Arrays::stream).
                filter(t -> t.contains("a")).//içinde a bulunanlar fıltrelendı
                forEach(System.out::println);//yazdırıldı

        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).map(t -> t.replaceAll("\\W", "").
                        replaceAll("\\d", "")).
                map(t -> t.split("")).flatMap(Arrays::stream).distinct().count());

        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).map(t -> t.replaceAll("[!,.:;)(?\\-]", "").
                split(" ")).flatMap(Arrays::stream).distinct().count());

        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        Files.lines(haluk).map(t -> t.replaceAll("[!,.:;)(?\\-]", "").
                split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);


    }
}
