package Techproed.day06_Practice;

import Techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class C01_WindowHandles extends TestBase {
// 'https://www.n11.com' adresine gidin
// arama motoruna 'Oppo' yazıp aratın
// ilk ürüne tıklayın
// ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
// ilk sayfaya donun ve Title'ını yazdırın

    @Test
    public void test01() throws InterruptedException {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String n11WindowHandle= driver.getWindowHandle();
        System.out.println("SAYFA1HANDLE: " +n11WindowHandle);
        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.xpath("//*[@id='searchData']")).sendKeys("Oppo" + Keys.ENTER);
        Thread.sleep(2000);
        // ilk ürüne tıklayın
        WebElement ilkUrun=driver.findElement(By.xpath("(//*[@class='lazy cardImage'])[1]"));
        ilkUrun.click();
        Thread.sleep(2000);

       Set<String> windowHandleSeti= driver.getWindowHandles();
       String sayfa2Handle="";
        for (String each:windowHandleSeti) {
            if (!each.equals(n11WindowHandle)){
                sayfa2Handle=each;
            }
        }
        System.out.println("SAYFA2HANDLE: " +sayfa2Handle);

        driver.switchTo().window(sayfa2Handle);
        Thread.sleep(2000);

        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
        String  ikinciSayfaTitle = driver.getTitle();
        Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));

        Thread.sleep(2000);
        // ilk sayfaya donun ve Title'ını yazdırın

        driver.switchTo().window(n11WindowHandle).getTitle();
        String ilkSayfaTitle=driver.getTitle();
        System.out.println("ILK SAYFA TİTLE: " +ilkSayfaTitle);

    }
}
