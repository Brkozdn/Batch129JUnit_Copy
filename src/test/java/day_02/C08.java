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

public class C08 {


    // https://www.amazon.com/ adresine gidin
    // Kaynak Kodlarini konsola yazdiriniz
    // Kaynak Kodlarinda "Gateway" yazdigini test edin


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
    public void test01() {



        // https://www.amazon.com/ adresine gidin


        driver.get("https://www.amazon.com/");










        // Kaynak Kodlarini konsola yazdiriniz


        String sayfaKaynakKodlari = driver.getPageSource();

        System.out.println(sayfaKaynakKodlari);












        // Kaynak Kodlarinda "Gateway" yazdigini test edin   // ctrl u

        Assert.assertTrue(sayfaKaynakKodlari.contains("Gateway"));

        /*
        if(sayfaKaynakKodlari.contains("Gateway")){
            System.out.println("Kaynak Kodlarinda Gateway yaziyor");
        }else {
            System.out.println("Kaynak Kodlarinda Gateway yazmiyor");
        }
         */













    }
}
