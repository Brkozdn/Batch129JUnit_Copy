package day_03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C04_DropDownOptions extends TestBase {

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın




    @Test
    public void name() {




        // https://www.amazon.com/ sayfasina gidin
        // dropdown'dan "Baby" secenegini secin
        // sectiginiz option'i yazdirin
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        // dropdown'daki optionların tamamını yazdırın




        // https://www.amazon.com/ sayfasina gidin

        driver.get("https://www.amazon.com/");















        // dropdown'dan "Baby" secenegini secin




        // DROPDOWN 3 ADIMDA HANDLE EDİLİR

        // 1- DROPDOWN LOCATE EDİLMELİDİR

        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));






        // 2- SELECT OBJESİ OLUSTURULMALIDIR

        Select select = new Select(ddm);






        // 3- OPTİONLARDAN BİR TANESİ SECİLMELİDİR


         select.selectByVisibleText("Baby");
        // ddmVisibleText(ddm,"Baby");

        // select.selectByIndex(3);
        // ddmIndex(ddm,3);


        // select.selectByValue("search-alias=baby-products-intl-ship");
        // ddmValue(ddm,"search-alias=baby-products-intl-ship");












        // sectiginiz option'i yazdirin


        String sectigimOption = select.getFirstSelectedOption().getText();


        System.out.println("SECTİGİM OPTİON: " + sectigimOption);











        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin


        List<WebElement> optionlarList = select.getOptions();



        int expectedOptionSayisi = 28;
        int actuelOptionSayisi = optionlarList.size();

        Assert.assertEquals(expectedOptionSayisi,actuelOptionSayisi);













        // dropdown'daki optionların tamamını yazdırın



        int sayac=1;


        for (WebElement each:optionlarList) {

            System.out.println(sayac + ". option: " + each.getText());

            sayac++;

        }



        // optionlarList.stream().forEach(t-> System.out.println(t.getText()));





    }




}
