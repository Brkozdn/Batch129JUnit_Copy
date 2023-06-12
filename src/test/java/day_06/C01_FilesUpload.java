package day_06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FilesUpload extends TestBase {

    // masaustunde bir deneme dosyası olusturun
    // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
    // 'Upload' butonuna basın
    // 'File Uploaded!' yazısının goruntulendigini test edin


    @Test
    public void test01() throws InterruptedException {




        // masaustunde bir deneme dosyası olusturun













        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");
        Thread.sleep(2000);

















        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaSec = driver.findElement(By.xpath("//input[@id='file-upload']"));



        // "C:\Users\BURAK\Desktop\deneme.txt"

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\deneme.txt";

        String dosyaYolu = farkliKisim+ortakKisim;


        dosyaSec.sendKeys(dosyaYolu); /////////////////////////////////////////////////



        Thread.sleep(2000);




















        // 'Upload' butonuna basın
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        Thread.sleep(3000);















        // 'File Uploaded!' yazısının goruntulendigini test edin
       // WebElement fileUploaded = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));

       // Assert.assertTrue(fileUploaded.isDisplayed());




    }
}
