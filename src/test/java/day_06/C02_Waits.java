package day_06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_Waits extends TestBase {




    //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
    //==>  Remove tuşuna basın
    //==>  "It's gone!" yazısının görünür oldugunu test edin.




    @Test
    public void explicitWait() {


        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");





        //==>  Remove tuşuna basın
        driver.findElement(By.xpath("//*[text()='Remove']")).click();





        //==>  "It's gone!" yazısının görünür oldugunu test edin.



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement itsGoneYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));



        Assert.assertTrue(itsGoneYazisi.isDisplayed());






    }




}
