package day_09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


import java.util.List;

public class C01_WebTables extends TestBase {


    // girisYap methodu olusturun
    // https://www.hotelmycamp.com adresine gidin
    // Log in butonuna tıklayın
    // Username: manager
    // Password: Manager1!


    // sutun sayısını yazdırın
    // tum body'i yazdirin
    // body'de bulunan satır sayısını yazdırın
    // body'de bulunan satırları yazdırın
    // 4.satırdaki elementleri yazdırın
    // son satırdaki elementleri yazdırın
    // sondan bir önceki satırdaki elementleri yazdırın
    // Email baslıgındaki tum elementleri(sutun) yazdırın



    @Test
    public void test01() {

        // girisYap methodu olusturun
        // https://www.hotelmycamp.com adresine gidin
        // Log in butonuna tıklayın
        // Username: manager
        // Password: Manager1!
        girisYap();






        // sutun sayısını yazdırın
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("SUTUN SAYISI: " + sutunBasliklariListesi.size());




        System.out.println("*****************");



        // tum body'i yazdirin
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());


        System.out.println("*****************");


        // body'de bulunan satır sayısını yazdırın
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("SATIR SAYISI: " + satirlarListesi.size());



        System.out.println("*****************");



        // body'de bulunan satırları yazdırın
        for (WebElement each:satirlarListesi) {
            System.out.println(each.getText());
        }



        System.out.println("*****************");




        // 4.satırdaki elementleri yazdırın
        List<WebElement> dorduncuSatirElementleri =  driver.findElements(By.xpath("//tbody//tr[4]//td"));

        for (WebElement each:dorduncuSatirElementleri) {
            System.out.println(each.getText());
        }




        System.out.println("*****************");







        // son satırdaki elementleri yazdırın
        List<WebElement> sonSatirElementleri =  driver.findElements(By.xpath("//tbody//tr[last()]//td"));

        for (WebElement each:sonSatirElementleri) {
            System.out.println(each.getText());
        }




        System.out.println("*****************");







        // sondan bir önceki satırdaki elementleri yazdırın
        List<WebElement> sondanbironcekiSatirElementleri =  driver.findElements(By.xpath("//tbody//tr[last()-1]//td"));

        for (WebElement each:sondanbironcekiSatirElementleri) {
            System.out.println(each.getText());
        }




        System.out.println("*****************");









        // Email baslıgındaki tum elementleri(sutun) yazdırın

        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));


        int emailSutunNo = 0;

        for (int i = 0; i <basliklarListesi.size() ; i++) {

            if(basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }



        List<WebElement> emailSutunListesi = driver.findElements(By.xpath("//tbody//tr//td["+(emailSutunNo+1)+"]")); // ÖNCE BUNU YAZ



        for (WebElement each:emailSutunListesi) {

            System.out.println(each.getText());

        }


    }




    public void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click(); // Gelismis
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click(); // Güvenli Degil

        driver.findElement(By.xpath("//a[text()='Log in']")).click(); // Log in

        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));

        userName.sendKeys("manager",Keys.TAB,"Manager1!",Keys.ENTER);
        /*
        Actions actions = new Actions(driver);

        actions.click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();


         */


    }


}
