package day_02;

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

public class C01 {


    // https://www.amazon.com/ adresine gidin
    // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
    // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin





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
    public void test01() {

        // https://www.amazon.com/ adresine gidin


        driver.get("https://www.amazon.com/");












        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz


        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));




        String actuelTagName = aramaKutusu.getTagName();


        String expectedTagName = "input";

        Assert.assertEquals(expectedTagName,actuelTagName);
        // Assert.assertTrue(expectedTagName.equals(actuelTagName));

       // if(expectedTagName.equals(actuelTagName)){
       //    System.out.println("TagName input");
       // }else{
       //     System.out.println("TagName input degil");
       // }












        // arama kutusunun, 'name' attribute'nun, degerinin 'field-keywords' oldugunu test edin


        String actuelNameDegeri = aramaKutusu.getAttribute("name");



        String expectedNameDegeri = "field-keywords";

        Assert.assertEquals(expectedNameDegeri,actuelNameDegeri);
        // Assert.assertTrue(expectedNameDegeri.equals(actuelNameDegeri));

       // if(expectedNameDegeri.equals(actuelNameDegeri)){
       //     System.out.println("name attribute'nun degeri field-keyword");
       // }else{
       //     System.out.println("name attribute'nun degeri field-keyword degil");
       // }






    }


}
