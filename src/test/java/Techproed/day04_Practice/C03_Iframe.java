package Techproed.day04_Practice;

import Techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_Iframe extends TestBase {
    // https://html.com/tags/iframe sayfasına gidiniz
    // Videoyu görecek kadar asagiya ininiz
    // Videoyu izlemek icin Play tusuna basiniz
    // Videoyu calistirdiginizi test ediniz
    // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

    @Test
    public void test01() {

        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        /*
        Selenium'da Actions sınıfı, web tarayıcısında çeşitli eylemleri gerçekleştirmek için kullanılan bir sınıftır.
        Bu sınıf, kullanıcıların fare ve klavye etkileşimlerini taklit etmelerine olanak tanır.

        Actions sınıfı, web tarayıcısında fareyi hareket ettirme, tıklama,
        sağ tıklama, metin yazma, sürükle ve bırak gibi bir dizi eylemi gerçekleştirmek için kullanılabilir.
        Ayrıca klavye kısayolları, tuşa basma ve bırakma gibi klavye eylemlerini de taklit etmenizi sağlar.

        Actions sınıfı, Selenium WebDriver API'sinin bir parçasıdır ve birden fazla eylemi
        bir araya getirerek daha karmaşık etkileşimler oluşturmanıza olanak tanır.
        Örneğin, bir element üzerine fareyle
        tıkladıktan sonra bir menüyü açabilir ve ardından menüdeki bir öğeye tıklayabilirsiniz.
         */
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        /*
          Play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı
        bunun üzerine HTML kodlarını inceleyince
        play'in aslında bir iframe icerisinde oldugunu gördük
        bu durumda once iframe'i locate edip
        switchTo() ile iframe'e gecmeliyiz
 */
        WebElement play = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();
        // Videoyu calistirdiginizi test ediniz
       WebElement youtube= driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtube.isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement power=driver.findElement(By.xpath("//* [@id='Powerful_but_easy_to_misuse']"));
        Assert.assertTrue(power.isDisplayed());
    }
}
