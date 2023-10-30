package day_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

import java.time.Duration;

public class C06_Alert extends TestBase {



    // Bir test metodu olusturun: acceptAlert
    // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    // 1. butona tıklayın
    // uyarıdaki OK butonuna tıklayın
    // result mesajının  “You successfully clicked an alert” oldugunu test edin.



    // Bir test metodu olusturun: dismissAlert
    // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    // 2. butona tıklayın
    // uyarıdaki CANCEL butonuna tıklayın
    // result mesajının “successfuly” icermedigini test edin.



    // Bir test metodu olusturun: sendKeysAlert
    // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    // 3. butona tıklayın
    // uyarıdaki metin kutusuna isminizi yazin
    // uyarıdaki OK butonuna tıklayın
    // result mesajında isminizin görüntülendiğini test edin.







    // Bir test metodu olusturun: acceptAlert
    @Test
    public void acceptAlert() throws InterruptedException {

        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");



        // 1. butona tıklayın
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);


        // uyarıdaki Tamam butonuna tıklayın
        driver.switchTo().alert().accept();
        // alertAccept();
        Thread.sleep(2000);



        // result mesajının  “You successfully clicked an alert” oldugunu test edin.
        String expectedResultMsj = "You successfully clicked an alert";
        String actuelResultMsj = driver.findElement(By.xpath("//p[@id='result']")).getText();


        Assert.assertEquals(expectedResultMsj,actuelResultMsj);
        Thread.sleep(2000);

    }














    // Bir test metodu olusturun: dismissAlert
    @Test
    public void dismissAlert() throws InterruptedException {

        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");




        // 2. butona tıklayın
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);




        // uyarıdaki İptal butonuna tıklayın
        driver.switchTo().alert().dismiss();
        // alertDismiss();
        Thread.sleep(2000);



        // result mesajının “successfuly” icermedigini test edin.
       String expectedResultMsj2= "successfuly";
       String actuelResultMsj2 =  driver.findElement(By.xpath("//p[@id='result']")).getText();

       Assert.assertFalse(actuelResultMsj2.contains(expectedResultMsj2));
       Thread.sleep(2000);

    }











    // Bir test metodu olusturun: sendKeysAlert
    @Test
    public void sendKeysAlert() throws InterruptedException {


        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");




        // 3. butona tıklayın
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);



        // uyarıdaki metin kutusuna isminizi yazin
        driver.switchTo().alert().sendKeys("Burak");
        // alertsendKeys("Burak");
        Thread.sleep(2000);



        // uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();
        // alertAccept();
        Thread.sleep(2000);


        // result mesajında isminizin görüntülendiğini test edin.
        String expectedResultMsj3 = "Burak";
        String actuelResultMsj3 = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(actuelResultMsj3.contains(expectedResultMsj3));
        Thread.sleep(2000);

    }
}
