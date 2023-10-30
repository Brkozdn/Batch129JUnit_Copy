package day_06;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_Screenshot extends TestBase {


    // https://www.teknosa.com/ adresine gidin
    // arama cubuguna oppo yazip enter'a basınız
    // sonuc yazısını yazdiriniz
    // ilk urunun fotografını cekin
    // cikan ilk urune tiklayiniz
    // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirabilirin
    // sepete ekleyiniz
    // sepetim'e git tilayiniz
    // "Siparis Ozeti" webelementinin text'ini yazdiriniz
    // Alisverisi tamamlayiniz
    // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz


    @Test
    public void test01() throws IOException, InterruptedException {


        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");
        Thread.sleep(3000);


        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cıkmadı");
        }
        // HATA VERİRSE KABUL ET


        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("oppo" + Keys.ENTER);
        Thread.sleep(3000);



        // sonuc yazısını yazdiriniz
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println("SONUC YAZİSİ: " + sonucYazisi.getText());
        Thread.sleep(3000);




        // ilk urunun fotografını cekin
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);


        //String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());





        WebElement ilkUrun = driver.findElement(By.xpath("(//a[@class=' prd-link '])[1]"));


        File kayit = new File("src/test/java/utilities/ekranGoruntusu/ilkUrun"+tarih+".png");

        File geciciDosya = ilkUrun.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,kayit);

        //FileUtils.copyFile(ilkUrun.getScreenshotAs(OutputType.FILE),new File("src/test/java/utilities/ekranGoruntusu/ilkUrun"+tarih+".png"));



        Thread.sleep(3000);





        // cikan ilk urune tiklayiniz
        ilkUrun.click();
        Thread.sleep(3000);




        // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirin
        //Actions actions = new Actions(driver);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Thread.sleep(3000);





        // sepete ekleyiniz
        driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]")).click();
        Thread.sleep(3000);




        // sepetim'e git tilayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        Thread.sleep(3000);


        // "Siparis Ozeti" webelementinin text'ini yazdiriniz
        WebElement siparisOzeti = driver.findElement(By.xpath("//div[text()='Sipariş Özeti']")); // TEXT OLANI ALLL
        System.out.println("SİPARİS OZETİ TEXT: " + siparisOzeti.getText());
        Thread.sleep(3000);




        // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
        Thread.sleep(3000);



        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
        WebElement teknosayaHosgeldiniz = driver.findElement(By.xpath("//div[text()='Teknosa’ya Hoş Geldiniz']"));
        System.out.println("TEKNOSAYA HOSGELDİNİZ TEXT: " + teknosayaHosgeldiniz.getText());



    }


    @Test
    public void natest01ReusableMethodCozumu() throws InterruptedException {

        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");
        Thread.sleep(3000);


        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cıkmadı");
        }
        // HATA VERİRSE KABUL ET


        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("oppo" + Keys.ENTER);
        Thread.sleep(3000);



        // sonuc yazısını yazdiriniz
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println("SONUC YAZİSİ: " + sonucYazisi.getText());
        Thread.sleep(3000);




        // ilk urunun fotografını cekin
        WebElement ilkUrun = driver.findElement(By.xpath("(//a[@class=' prd-link '])[1]"));

        webElementEkranGoruntusu(ilkUrun);


        Thread.sleep(3000);









        // cikan ilk urune tiklayiniz
        ilkUrun.click();
        Thread.sleep(3000);




        // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);





        // sepete ekleyiniz
        driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]")).click();
        Thread.sleep(3000);




        // sepetim'e git tilayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        Thread.sleep(3000);


        // "Siparis Ozeti" webelementinin text'ini yazdiriniz
        WebElement siparisOzeti = driver.findElement(By.xpath("//div[text()='Sipariş Özeti']")); // TEXT OLANI ALLL
        System.out.println("SİPARİS OZETİ TEXT: " + siparisOzeti.getText());
        Thread.sleep(3000);




        // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
        Thread.sleep(3000);



        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
        WebElement teknosayaHosgeldiniz = driver.findElement(By.xpath("//div[text()='Teknosa’ya Hoş Geldiniz']"));
        System.out.println("TEKNOSAYA HOSGELDİNİZ TEXT: " + teknosayaHosgeldiniz.getText());







    }
}
