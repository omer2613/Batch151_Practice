package Techproed.day06_Practice;

import Techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class C03_ActionMoveToElement extends TestBase {
    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim

    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
    @Test
    public void test01() throws InterruptedException {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String ilkSayfaHandle= driver.getWindowHandle();
Thread.sleep(2000);
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
        WebElement dilMenu= driver.findElement(By.xpath("//*[@class='nav-line-2']"));
        actions.moveToElement(dilMenu).perform();
        // Change country/region butonuna basiniz
         driver.findElement(By.xpath("(//*[@class='icp-mkt-change-lnk'])[1]")).click();
        // United States dropdown'undan 'Turkey (Türkiye)' seciniz


        //dropdown 3 adimda handle edilir
        // 1-dropdown locate edilir
        WebElement ddm =driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        // 2-select objesi olusturulur
        Select select=new Select(ddm);
        // 3- select opsiyonlardan biri secilir
        select.selectByVisibleText("Turkey (Türkiye)");

        // Go to website butonuna tiklayiniz

        // drop down opsiyon listesi 'Go to website' butonuna basmamıza engel oldugu icin
        // herhangi bir yere click yapıp dropdown option listesinin toparlanmasını sagladık

        //actions.moveToElement(driver.findElement(By.xpath("//*[text()='Turkey (Türkiye)']"))).click().perform();
        driver.findElement(By.xpath("(//span[@class='a-text-bold'])[3]")).click();

        Thread.sleep(200);

        WebElement goToWebSite=driver.findElement(By.xpath("//input[@class='a-button-input']"));
        goToWebSite.click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

        Set<String> windowHandleSeti=driver.getWindowHandles();
        String sayfa2Handle="";
        for (String each:windowHandleSeti) {
            if (!each.equals(ilkSayfaHandle)){
                sayfa2Handle=each;
            }

        }
            driver.switchTo().window(sayfa2Handle);
        Thread.sleep(2000);
        //driver i yeni acilan sekmeye gecirdik

        String ikincisayfaTitle=driver.getTitle();
        Assert.assertTrue(ikincisayfaTitle.contains("Elektronik"));

    }
}
