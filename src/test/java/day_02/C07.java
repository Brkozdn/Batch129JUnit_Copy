package day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C07 {


    // "https://teknosa.com/" adresine gidiniz
    // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
    // Title'in "Teknoloji" kelimesini icerip icermedigini test ediniz
    // URL'in "teknosa" kelimesini icerip icermedigini test ediniz
    // "https://medunna.com/" adresine gidiniz
    // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
    // Title'in "MEDUNNA" kelimesini icerip icermedigini test ediniz.
    // URL'in "medunna" kelimesini icerip icermedigini test ediniz
    // teknosa adresine geri donunuz
    // Sayfayı yenileyiniz
    // medunna adresine ilerleyiniz
    // Sayfayı yenileyiniz


    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @After
    public void tearDown(){
        driver.close();
    }


    @Test
    public void test01() throws InterruptedException {



        // "https://teknosa.com/" adresine gidiniz


        driver.get("https://teknosa.com/");


        Thread.sleep(2000);













        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz


        String teknosaTitle = driver.getTitle();

        System.out.println("teknosaTitle = " + teknosaTitle);




        String teknosaURL = driver.getCurrentUrl();

        System.out.println("teknosaUrl = " + teknosaURL);














        // Title'in "Teknoloji" kelimesini icerip icermedigini test ediniz

        Assert.assertTrue(teknosaTitle.contains("Teknoloji"));

        /*
        if(teknosaTitle.contains("Teknoloji")){
            System.out.println("Title Teknoloji iceriyor");
        }else {
            System.out.println("Title Teknoloji icermiyor");
        }

         */














        // URL'in "teknosa" kelimesini icerip icermedigini test ediniz

        Assert.assertTrue(teknosaURL.contains("teknosa"));

        /*
        if(teknosaURL.contains("teknosa")){
            System.out.println("URL teknosa iceriyor" );
        }else {
            System.out.println("URL teknosa icermiyor");
        }
         */













        // "https://medunna.com/" adresine gidiniz


        driver.get("https://medunna.com/");

        Thread.sleep(2000);

















        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz


        String medunnaTitle = driver.getTitle();

        System.out.println("medunnaTitle = " + medunnaTitle);





        String medunnaURL = driver.getCurrentUrl();

        System.out.println("medunnaURL = " + medunnaURL);















        // Title'in "MEDUNNA" kelimesini icerip icermedigini test ediniz.

        Assert.assertTrue(medunnaTitle.contains("MEDUNNA"));

        /*
        if(medunnaTitle.contains("MEDUNNA")){
            System.out.println("Title MEDUNNA iceriyor");
        }else {
            System.out.println("Title MEDUNNA icermiyor");
        }
         */













        // URL'in "medunna" kelimesini icerip icermedigini test ediniz

        Assert.assertTrue(medunnaURL.contains("medunna"));

        /*
        if(medunnaURL.contains("medunna")){
            System.out.println("URL medunna iceriyor" );
        }else {
            System.out.println("URL medunna icermiyor");
        }
         */












        // teknosa adresine geri donunuz

        driver.navigate().back();

        Thread.sleep(2000);














        // Sayfayı yenileyiniz

        driver.navigate().refresh();

        Thread.sleep(2000);













        // medunna adresine ilerleyiniz


        driver.navigate().forward();

        Thread.sleep(2000);













        // Sayfayı yenileyiniz


        driver.navigate().refresh();

        Thread.sleep(2000);










    }
}
