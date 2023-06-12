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

import java.time.Duration;

public class C06_Alert {


    // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

    // Bir test metodu olusturun: acceptAlert
    // 1. butona tıklayın
    // uyarıdaki OK butonuna tıklayın
    // result mesajının  “You successfully clicked an alert” oldugunu test edin.

    // Bir test metodu olusturun: dismissAlert
    // 2. butona tıklayın
    // uyarıdaki CANCEL butonuna tıklayın
    // result mesajının “successfuly” icermedigini test edin.

    // Bir test metodu olusturun: sendKeysAlert
    // 3. butona tıklayın
    // uyarıdaki metin kutusuna isminizi yazin
    // uyarıdaki OK butonuna tıklayın
    // result mesajında isminizin görüntülendiğini test edin.








    WebDriver driver;


    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
    }









    @After
    public void tearDown() throws Exception {
        driver.close();
    }















    // Bir test metodu olusturun: acceptAlert
    @Test
    public void acceptAlert() throws InterruptedException {


        // 1. butona tıklayın
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);


        // uyarıdaki Tamam butonuna tıklayın
        driver.switchTo().alert().accept();
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

        // 2. butona tıklayın
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);




        // uyarıdaki İptal butonuna tıklayın
        driver.switchTo().alert().dismiss();
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


        // 3. butona tıklayın
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);



        // uyarıdaki metin kutusuna isminizi yazin
        driver.switchTo().alert().sendKeys("Burak");
        Thread.sleep(2000);



        // uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(2000);


        // result mesajında isminizin görüntülendiğini test edin.
        String expectedResultMsj3 = "Burak";
        String actuelResultMsj3 = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(actuelResultMsj3.contains(expectedResultMsj3));
        Thread.sleep(2000);

    }
}
