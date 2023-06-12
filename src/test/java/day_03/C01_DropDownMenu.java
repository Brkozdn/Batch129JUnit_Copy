package day_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDownMenu {



    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin



    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @After
    public void tearDown() throws Exception {
        //driver.close();
    }


    @Test
    public void name() {



        // https://www.amazon.com/ sayfasina gidin
        // dropdown'dan "Books" secenegini secin
        // arama cubuguna "Java" aratın
        // arama sonuclarinin Java icerdigini test edin




        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");








        // dropdown'dan "Books" secenegini secin



        // DROPDOWN 3 ADIMDA HANDLE EDİLİR

        // 1- DROPDOWN LOCATE EDİLMELİDİR

        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));







        // 2- SELECT OBJESİ OLUSTURULMALIDIR

        Select select = new Select(ddm);








        // 3- OPTİONLARDAN BİR TANESİ SECİLMELİDİR

         select.selectByVisibleText("Books");
        // select .selectByIndex(5);
        // select.selectByValue("search-alias=stripbooks-intl-ship");













        // arama cubuguna "Java" aratın

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);











        // arama sonuclarinin Java icerdigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String aramaSonucYazisi = aramaSonucElementi.getText();

        Assert.assertTrue(aramaSonucYazisi.contains("Java"));








    }
}
