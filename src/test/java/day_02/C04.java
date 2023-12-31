package day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04 {



    // ...Exercise 1...  COZDU


    // https://www.techproeducation.com/ sayfasina gidin
    // Title ve Url'ini alın ve yazdırın
    // Title'in "Techpro" kelimesini içerip içermedigini test edin
    // Url'in "techproeducation" kelimesini içerip içermedigini test edin
    // https://www.amazon.com/ sayfasına gidin
    // Title'ini alın ve yazdırın
    // Title'in "more" kelimesini içerip içermedigini test edin
    // techproeducation.com'a geri dönün
    // sayfayı yenileyin
    // amazon.com'a tekrar gelin



    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @After
    public void tearDown(){
        //driver.close();
    }


    @Test
    public void Test01() throws InterruptedException {

        // https://www.techproeducation.com/ sayfasina gidin
        driver.get("https://www.techproeducation.com/");






        // Title ve Url'ini alın ve yazdırın
        String techproeducationTitle = driver.getTitle();
        System.out.println("TECHPROEDUCATİON TİTLE: " + techproeducationTitle);

        String techproeducationUrl = driver.getCurrentUrl();
        System.out.println("TECHPROEDUCATİON URL: " + techproeducationUrl);








        // Title'in "Techpro" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproeducationTitle.contains("Techpro"));







        // Url'in "techproeducation" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproeducationUrl.contains("techproeducation"));






        // https://www.amazon.com/ sayfasına gidin
        driver.get("https://www.amazon.com/");






        // Title'ini alın ve yazdırın
        String amazonTitle= driver.getTitle();
        System.out.println("AMAZON TİTLE: " + amazonTitle);





        // Title'in "more" kelimesini içerip içermedigini test edin
        Assert.assertTrue(amazonTitle.contains("more"));





        // techproeducation.com'a geri dönün
        driver.navigate().back();





        // sayfayı yenileyin
        driver.navigate().refresh();





        // amazon.com'a tekrar gelin
        driver.navigate().forward();






    }













}
