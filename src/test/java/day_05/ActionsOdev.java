package day_05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsOdev extends TestBase {


    //https://www.google.com/ sayfasına gidelim
    //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
    //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
    //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım

    @Test
    public void odev(){


        //https://www.google.com/ sayfasına gidelim
        driver.get("https://www.google.com/");


        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));

        aramaKutusu.sendKeys("Selenium");
        bekle(3);
        aramaKutusu.sendKeys(Keys.ENTER);


        bekle(3);

        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim

        Actions actions = new Actions(driver);

        aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));

        actions.doubleClick(aramaKutusu).keyDown(Keys.CONTROL).sendKeys("X").keyUp(Keys.CONTROL).perform();

        bekle(3);


        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım

        driver.navigate().back();

        bekle(3);

        aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));

        actions.click(aramaKutusu).keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
        bekle(3);
        actions.sendKeys(Keys.ENTER).perform();




    }




}
