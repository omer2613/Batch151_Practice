package Techproed.day11_practice;

import Techproed.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // arama kutusuna Nutella yazip aratın
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        // tüm sayfanın fotografını cekin
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");//dd kucuk harfle olursa ayın gun sayisi DD olursa yılın gün sayisi
        String tarih=date.format(dtf);


        TakesScreenshot ts= (TakesScreenshot) driver;
        File kayit= new File("target/ekranGoruntusu/tumSayfa"+tarih+".jpg");
       File geciciDosya= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,kayit);

    }
}
