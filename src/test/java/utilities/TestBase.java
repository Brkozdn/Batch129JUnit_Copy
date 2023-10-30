package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class TestBase {


    // BU CLASS'A extends ETTİGİMİZ TEST CLASSLARINDAN ULASABİLİRİZ
    // TestBase CLASS'INDAN OBJE OLUSTURULMASININ ONUNE GECİLMESİ İCİN abstract YAPILABİLİR



    protected ExtentReports extentReport;//-->raporlamayı başlatır
    protected ExtentHtmlReporter extentHtmlReporter;//-->Html formatında rapor oluşturur
    protected ExtentTest extentTest;//-->Test adımlarına bilgi eklenir



    protected WebDriver driver;



    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }



    @After
    public void tearDown(){

      //  driver.quit();
    }






    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }











    public void ddmVisibleText(WebElement ddm, String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }



    public void ddmIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }



    public void ddmValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }











    public void alertAccept(){
        driver.switchTo().alert().accept();
    }


    public void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }


    public void alertsendKeys(String text){
        driver.switchTo().alert().sendKeys(text);
    }



    public void alertgetText(){
        System.out.println(driver.switchTo().alert().getText());
    }





    //UploadFile Robot Class
    public void robot(String dosyaYolu) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }



    public void tumSayfaEkranGoruntusu(){

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File kayit = new File("target/ekranGoruntusu/tumSayfa"+tarih+".Jpeg");
        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,kayit);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




    public void webElementEkranGoruntusu(WebElement element){

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);


        File kayit = new File("src/test/java/utilities/ekranGoruntusu/ilkUrun"+tarih+".png");

        File geciciDosya = element.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,kayit);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //Extent Report
    public void rapor(String browser,String reportName){
        extentReport = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/extentReport/report"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReport.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler
        extentReport.setSystemInfo("Tester","Burak");
        extentReport.setSystemInfo(browser,"Chrome");
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");
        extentHtmlReporter.config().setReportName(reportName);
    }








}
