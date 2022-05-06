package day06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lambda06 {
    public static void main(String[] args) throws IOException {

        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        Files.lines(Paths.get("src/day06/haluk.txt")).//Files class'dan lines() method call edilerek data
                // çekilecek dosya yolu(path)
                // paremetre girilerek path'deki dosyanın dataları akısa alındı
                forEach(System.out::println);//akısdaki datalar(her satırdaki string)yazıldı)


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.lines(Paths.get("src/day06/haluk.txt")).map(String::toUpperCase).forEach(System.out::println);


        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
     //   Files.lines(Paths.get("src/day06/haluk.txt")).filter().map(String::toLowerCase).forEach(System.out::println);

    }
}
