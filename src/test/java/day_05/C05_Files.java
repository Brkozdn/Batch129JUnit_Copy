package day_05;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_Files {


    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin


    @Test
    public void test01() {

      /*
        DOSYANIN, BİLGİSAYARIMDA DESKTOP'DA OLUP OLMADIGINI
        JAVA İLE TEST EDECEGİM.
        CUNKU SELENİUM, WEB SAYFALARINI TEST EDER. SELENİUM, BENİM BİLGİSAYARIMIZDAKİ DESKTOP'A MUDAHELE EDEMEZ
         */


        // "C:\Users\BURAK\Desktop\text.txt"
        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\BURAK\\Desktop\\text.txt")));


        String farkliKisim = System.getProperty("user.home");
        System.out.println(farkliKisim);
        String ortakKisim = "\\Desktop\\text.txt";
        System.out.println(ortakKisim);

        String dosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));




    }
}
