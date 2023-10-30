package day_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

import java.time.Duration;

public class C05_Alert extends TestBase {



    //http://demo.guru99.com/test/delete_customer.php adresine gidin
    //customer id kısmına 53920 yazın
    //submit butonuna tıklayın
    //cıkan alert mesajını yazdırın
    //alerti kabul edin
    //cıkan 2. alert mesajını yazdırın
    //cıkan 2. alerti kabul edin




    @Test
    public void name() throws InterruptedException {

        // http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        Thread.sleep(2000);






        //customer id kısmına 53920 yazın
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("53920");

        Thread.sleep(2000);





        //submit butonuna tıklayın
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        Thread.sleep(2000);







        //cıkan alert mesajını yazdırın
        String alertYazisi = driver.switchTo().alert().getText();
        System.out.println("ALERT YAZISI: " +alertYazisi);
        // alertgetText();

        Thread.sleep(2000);








        //alerti kabul edin
        driver.switchTo().alert().accept();
        // alertAccept();

        Thread.sleep(2000);









        //cıkan 2. alert mesajını yazdırın
        String alertYazisi2 = driver.switchTo().alert().getText();
        System.out.println("ALERT YAZISI: " + alertYazisi2);
        // alertgetText();

        Thread.sleep(2000);








        //cıkan 2. alerti kabul edin
        driver.switchTo().alert().accept();
        // alertAccept();

        Thread.sleep(2000);



    }
}
