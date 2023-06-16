package Techproed.day05_Practice;

import Techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_Iframe extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy");
        // Videoyu görecek kadar asagiya ininiz
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);
        /*
        play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı.
        Bunun üzerine HTML kodlarını inceleyince Play'in aslında bir iframe icerisinde oldugunu gördük
        Bu durumda önce iframe locate edip sonra switchTo() ile iframe'e gecmeliyiz
         */

        WebElement playtusu=driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playtusu.click();

        Thread.sleep(3000);
        // videoyu durdurunuz
        WebElement videoyuDurdur=driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        videoyuDurdur.click();
        // videoyu tam ekran yapınız
        WebElement tamEkran=driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
        tamEkran.click();
        Thread.sleep(3000);
        // videoyu calıstırınız
        WebElement videoyucalistir=driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        videoyucalistir.click();

        // videoyu kucultunuz
        WebElement kucukEkran=driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
        tamEkran.click();
        // videoyu durdurunuz
        WebElement videoyuDurdur1=driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        videoyuDurdur.click();
        // Videoyu calistirdiginizi test ediniz
        WebElement youtube=driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtube.isDisplayed());
        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement flexyYazisi = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(flexyYazisi.isDisplayed());

    }
}
