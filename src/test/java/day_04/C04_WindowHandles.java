package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_WindowHandles extends TestBase {

    // 'https://www.n11.com' adresine gidin
    // arama motoruna 'oppo' yazıp aratın
    // ilk ürüne tıklayın
    // Basligin 'Oppo' icerdigini test edin.
    // ilk sayfaya donun ve Title'ını yazdırın


    @Test
    public void test01() throws InterruptedException {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String sayfa1Handle = driver.getWindowHandle();

        System.out.println(sayfa1Handle);
        Thread.sleep(2000);



        // arama motoruna 'oppo' yazıp aratın
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("Oppo" + Keys.ENTER);
        Thread.sleep(2000);



        // ilk ürüne tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]"));
        ilkUrun.click();
        Thread.sleep(3000);



        Set<String> windowHandleSeti = driver.getWindowHandles();

        String sayfa2Handle="";

        for (String each:windowHandleSeti) {

            if(!each.equals(sayfa1Handle)){

                sayfa2Handle = each;

            }

        }


        System.out.println(windowHandleSeti);

        System.out.println(sayfa2Handle);


        driver.switchTo().window(sayfa2Handle);







        // Basligin 'Reno' icerdigini test edin.
        WebElement baslik = driver.findElement(By.xpath("//h1[@class='proName']"));
        String baslikStr = baslik.getText();

        Assert.assertTrue(baslikStr.contains("Reno"));
        Thread.sleep(2000);








        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);

        String ilkSayfaTitle = driver.getTitle();
        System.out.println("İLK SAYFA TİTLE: " + ilkSayfaTitle);
        Thread.sleep(2000);



    }
}
