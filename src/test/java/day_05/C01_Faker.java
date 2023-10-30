package day_05;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {



    // 'https://www.facebook.com' sayfasina gidiniz
    // yeni hesap olustur butonuna basin
    // isim kutusunu locate ediniz
    // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun


    @Test
    public void test01() {



        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");






        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();





        // isim kutusunu locate ediniz
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));






        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun



        Faker faker=new Faker();


        String email=faker.internet().emailAddress();




        Actions actions=new Actions(driver);
        actions.click(isimKutusu).




                sendKeys(faker.name().firstName()).  // İSİM
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).    // SOYİSİM





                sendKeys(Keys.TAB).
                sendKeys(email).      // EMAİL CALIŞTIRR
                sendKeys(Keys.TAB).
                sendKeys(email).      // 2 KEZ EMAİL İSTİYOR






                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()). // ŞİFRE





                sendKeys(Keys.TAB). // ? İSARETİNİ TAB İLE GEC
                sendKeys(Keys.TAB).






                sendKeys("15").  // GÜN
                sendKeys(Keys.TAB).
                sendKeys("Mart").  // AY
                sendKeys(Keys.TAB).
                sendKeys("2000").  // YIL






                sendKeys(Keys.TAB). //? İSARETİNİ TAB İLE GEC
                sendKeys(Keys.TAB).






                sendKeys(Keys.ARROW_RIGHT). // CİNSİYETİ ERKEK SECTİM  bayanlar 3 kez arrow_rigt yapsin
                //sendKeys(Keys.ARROW_RIGHT).
                //sendKeys(Keys.ARROW_RIGHT).




                sendKeys(Keys.TAB). // 5 TANE TAB YAPACAGIM
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).



                sendKeys(Keys.ENTER).perform(); // ENTER İLE KAYDOL'A TIKLAYACAGIM





    }




}
