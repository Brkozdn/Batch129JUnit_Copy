package day_05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionsMoveToElement extends TestBase {

    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz


    @Test
    public void test01() throws InterruptedException {




        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String sayfa1Handle = driver.getWindowHandle();








        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);

        WebElement dilMenu = driver.findElement(By.xpath("//div[text()='EN']"));

        actions.moveToElement(dilMenu).perform();


        Thread.sleep(3000);










        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();


        Thread.sleep(3000);









        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));

        Select select = new Select(ddm);

        select.selectByVisibleText("Turkey (Türkiye)");



        Thread.sleep(3000);








        //Drop down opsiyon listesi 'Go to website' butonuna basmamıza engel oldugu icin
        //herhangi bir yere clic yapıp drop down opsiyon listesinin toparlanmasını sagladık
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();


        Thread.sleep(3000);









        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();










        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        Set<String> windowHandlesSeti = driver.getWindowHandles();

        System.out.println("SAYFA1HANDLE: " + sayfa1Handle);
        System.out.println(windowHandlesSeti);




        String sayfa2Handle="";

        for (String each:windowHandlesSeti) {

            if(!each.equals(sayfa1Handle)){
                sayfa2Handle=each;
            }

        }


        System.out.println("SAYFA2HANDLE: " + sayfa2Handle);




        driver.switchTo().window(sayfa2Handle);


        /*
        List<String > pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        */

        // driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());





        Thread.sleep(3000);




        String ikinciSayfaTitle = driver.getTitle();
        System.out.println("İKİNCİ SAYFANIN TİTLE: " + ikinciSayfaTitle);





        Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));








    }
}
