package day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;

public class C02 {



        // https://www.google.com/ adresine gidin
        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        // arama cubuguna "Nutella" yazıp aratın
        // bulunan sonuc sayısını yazdırın
        // sonuc sayısının 100000000  fazla oldugunu test edin





    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // sayfanın yuklenmesi icin max bekleme suresi
    }


    @After
    public void tearDown(){
        driver.close();
    }




    @Test
    public void test01() throws InterruptedException {

        // https://www.google.com/ adresine gidin


        driver.get("https://www.google.com/");










        // sayfa baslıgının "Google" kelimesini icerdigini test edin


        String googleTitle = driver.getTitle();

        Assert.assertTrue(googleTitle.contains("Google"));


        //if(googleTitle.contains("Google")){
        //    System.out.println("Title Google iceriyor");
        //}else{
        //    System.out.println("Title Google icermiyor");
        //}


        Thread.sleep(2000);



















        // arama cubuguna "Nutella" yazıp aratın


        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Nutella" + Keys.ENTER);















        // bulunan sonuc sayısını yazdırın



        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));

        //System.out.println(sonucYazisi.getText());

        String arr[] = sonucYazisi.getText().split(" ");

        System.out.println(Arrays.toString(arr));

        String sonuc = arr[1];

        System.out.println(sonuc);













        // sonuc sayısının 100000000 fazla oldugunu test edin

        String sonucc = sonuc.replaceAll("\\D","");


        Assert.assertTrue(Integer.parseInt(sonucc)>100000000);


        //if(Integer.parseInt(sonucc)>100000000){
        //    System.out.println("Sonuc sayısı 10000000'dan fazla");
        //}else{
        //    System.out.println("Sonuc sayısı 10000000'dan fazla degil");
        //}
















    }





}
