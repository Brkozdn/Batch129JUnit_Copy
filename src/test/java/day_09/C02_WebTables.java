package day_09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_WebTables extends TestBase {


    // girisYap methodu olusturun
    // https://www.hotelmycamp.com adresine gidin
    // Log in butonuna tıklayın
    // Username: manager
    // Password: Manager1!

    // input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i dinamik olarak yazdırın.


    @Test
    public void dinamikYazici() {


        // girisYap methodu olusturun
        // https://www.hotelmycamp.com adresine gidin
        // Log in butonuna tıklayın
        // Username: manager
        // Password: Manager1!
        girisYap();


        // input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i dinamik olarak yazdırın.
        int satir = 3;
        int sutun = 3;


        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(arananCell.getText());


    }


    public void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click(); // Gelismis
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click(); // Güvenli Degil

        driver.findElement(By.xpath("//a[text()='Log in']")).click(); // Log in

        Actions actions = new Actions(driver);

        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));

        actions.click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();


    }

}



