package day_05;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C12_FilesUploadRobot extends TestBase {


    @Test
    public void test02() {


        // Test sayfasını aç
        driver.get("https://www.ilovepdf.com/compress_pdf");



        // Dosya seçme düğmesini bul ve tıkla
        driver.findElement(By.xpath("//*[.='Select PDF files']")).click();





        //   "C:\Users\BURAK\Desktop\PDF.pdf"

        // Dosya yüklemek için Robot sınıfını kullan

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\PDF.pdf";

        String dosyaYolu = farkliKisim + ortakKisim;

        bekle(3);


        robot(dosyaYolu);



    }






}
