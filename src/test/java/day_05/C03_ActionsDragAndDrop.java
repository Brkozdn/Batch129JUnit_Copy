package day_05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_ActionsDragAndDrop extends TestBase {




    // https://demoqa.com/droppable adresine gidiniz
    // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
    // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz




    @Test
    public void test04() {

        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");




        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
        Actions actions=new Actions(driver);

        WebElement tasinacakElement=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement hedefElement=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(tasinacakElement,hedefElement).perform();






        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        String expectedYazi="Dropped!";

        WebElement dropped=driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String actuelYazi=dropped.getText();

        Assert.assertEquals(expectedYazi,actuelYazi);


    }




}
