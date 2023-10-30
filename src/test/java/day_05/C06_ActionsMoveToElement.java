package day_05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_ActionsMoveToElement extends TestBase {

    // https://demo.automationtesting.in/Vimeo.html sayfasına gidiniz
    // ust bolumde bulunan Video menusunun acilmasi icin mause'u bu menunun ustune getiriniz. Ve Vimeo kısmına tıklayınız.
    // play tusuna basınız.
    // 'Automation Demo Site' yazısının gorunur oldugunu test ediniz


    @Test
    public void test01() {

        // https://demo.automationtesting.in/Vimeo.html sayfasına gidiniz
        driver.get("https://demo.automationtesting.in/Vimeo.html");





        // ust bolumde bulunan Video menusunun acilmasi icin mause'u bu menunun ustune getiriniz. Ve Vimeo kısmına tıklayınız.
        WebElement video = driver.findElement(By.xpath("//a[text()='Video']"));

        WebElement vimeo = driver.findElement(By.xpath("//a[text()='Vimeo']"));


        Actions actions = new Actions(driver);
        actions.moveToElement(video).click(vimeo).perform();









        // play tusuna basınız.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='foo']"));
        driver.switchTo().frame(iframe);



       WebElement play = driver.findElement(By.xpath("//button[@aria-label='Play']"));
       play.click();
       /*
        Play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı
        bunun uzerine HTML kodlarini inceleyince
        play'in aslinda bir iframe icerisinde oldugunu gorduk
        bu durumda once iframe'i locate edip
        switchTo() ile o iFrame'e gecmeliyiz
        */





        // 'Automation Demo Site' yazısının gorunur oldugunu test ediniz

        driver.switchTo().parentFrame();


        WebElement automationYazisi = driver.findElement(By.xpath("//h1[text()='Automation Demo Site ']"));
        Assert.assertTrue(automationYazisi.isDisplayed());


       /*
        'Automation Demo Site' yazısını dogru locate etmemize ragmen faild verdi
        cunku yukarida iframe'e gecis yapmistik
        once oradan cikmamiz lazim
    */

    }
}
