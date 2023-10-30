package day_06;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_Screenshot extends TestBase {

    // https://www.amazon.com/ adresine gidin
    // arama kutusuna Nutella yazip aratın
    // ilk ürüne tıklayın
    // tüm sayfanın fotografını cekin




    @Test
    public void test01() throws InterruptedException, IOException {

        // https://www.amazon.com/ adresine gidin

        driver.get("https://www.amazon.com/");




        // arama kutusuna Nutella yazip aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella" + Keys.ENTER);




        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();





        // tüm sayfanın fotografını cekin
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);

        //String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());



        TakesScreenshot ts = (TakesScreenshot) driver;

        File kayit = new File("target/ekranGoruntusu/tumSayfa"+tarih+".Jpeg");

        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,kayit);


        //FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/ekranGoruntusu/tumSayfa"+tarih+".Jpeg"));

        
        
    }





    @Test
    public void test01ReusableMethodCozumu() {



        // https://www.amazon.com/ adresine gidin

        driver.get("https://www.amazon.com/");




        // arama kutusuna Nutella yazip aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella" + Keys.ENTER);




        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();





        // tüm sayfanın fotografını cekin
        tumSayfaEkranGoruntusu();






    }
}
