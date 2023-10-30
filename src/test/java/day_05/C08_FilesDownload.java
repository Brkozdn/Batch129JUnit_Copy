package day_05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C08_FilesDownload extends TestBase {

    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
    // some-file.txt dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() throws InterruptedException {

        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        Thread.sleep(3000);




        /*
        String farkliKisimm = System.getProperty("user.home");
        String ortakKisimm = "\\Downloads\\some-file.txt";

        String dosyaYoluu = farkliKisimm+ortakKisimm;

        try {
            Files.delete(Paths.get(dosyaYoluu));
        } catch (Exception e) {
            System.out.println("Dosya Bulunamadı");
        }


        Eğer localimizden atomasyon ile bir dosya silmek istiyorsak Files.delete islemini kullanırız dosya yolunu
        içine yerleştiririz.

        Eger localimizde belirttigimiz dosya yoluna ait bir dosya varsa silsin, yoksa "Dosya bulunamadı" msj'ı vermesi icin de
        try-catch blogu icerisine alırız.(try-catch blogu icerisine almazssak dosyayı bulamazsa silemeyecegi icin exception verir)


        Bunu yapma sebebimiz; test classımızı her çalıştırdıgımızda yeni bir dosya indirecegi için
        indirilenlerdeki dosya kalabalığını önlemiş oluruz aynı zamanda doğrulama yaparken işimizi garantiye almış oluruz.

        Aynı isimde birden fazlada dosya indirmis olsak da her indirilenin yanına index vereceği için ve
        bizim ilk indirdiğimiz dosya indirilenler klasörünün içinde bulunacağı için
        her zaman ilk dosyanın varlığını test etmiş oluruz.
         */




        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
        Thread.sleep(3000);




        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

        /*
        DOSYANIN, BİLGİSAYARIMDA DOWNLOADS'A BASARIYLA İNDİRİLİP İNDİRİLMEDİGİNİ
        JAVA İLE TEST EDECEGİM.
        CUNKU SELENİUM, WEB SAYFALARINI TEST EDER. SELENİUM, BENİM BİLGİSAYARIMDAKİ DOWNLOADS'A MUDAHELE EDEMEZ
         */


        // "C:\Users\BURAK\Downloads\some-file.txt"
        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\BURAK\\Downloads\\some-file.txt")));


        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\some-file.txt";

        String dosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
