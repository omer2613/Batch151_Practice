package Techproed.day10_practice;

import Techproed.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C01_WebTables extends TestBase {
    @Test
    public void test01() {
        // girisYap methodu olusturun
// https://www.hotelmycamp.com adresine gidin

// Log in butonuna tıklayın

// Username: manager
// Password: Manager1!
        girisYap();
// sutun sayısını yazdırın
        //html kodlarini ctrl+f ile acip //thead yazdik baslik sayisini gördük
        // //thead//tr yazinca satir basliklarini görürüz
        // //thead//tr[1] basligin 1.sütununu verir
        // //thead//tr[1]//th basligin 1.satirindaki elementleri verir

        //birden fazla element verecegi icin list kullandik

        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("SUTUN SAYISI : " + sutunBasliklariListesi.size());
// tum body'i yazdirin

        //html kodlarini acip ctrl+f ile actigimiz locate yazdigimiz yere  //tbody yazincaa sadece body kismini isaretler.

        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println("tumBody.getText() = " + tumBody.getText());
        //bodyleri yazdirdik, Webelementi textte cevirdik--getText();


        System.out.println("************************************");


        // body'de bulunan satır sayısını yazdırın

        //html kodlarini acip ctrl+f ile actigimiz locate yazdigimiz yere  //tbody yazinca sadece body kismini isaretler.
        //satirlari elde etmek icin //tbody//tr[1] bodynin 1.satirini isaretler.
        //index belirtmezsek bodyde bulunan tüm satirlari verir--//tbody//tr

        //birden fazla element verecegi icin List e atadik

        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        // birden fazla oldugu icin findElement's' yapariz

        System.out.println("SATIR SAYISI= " + satirlarListesi.size());


        System.out.println("*********************************");

        // body'de bulunan satırları yazdırın
        //lambda ile------satirlarListesi.forEach(t-> System.out.println(t.getText()));


        for (WebElement each:satirlarListesi) {
            System.out.println(each.getText());
        }

    }
    public void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click(); // GELİSMİS
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click(); // GÜVENLİ DEGİL


        driver.findElement(By.xpath("//a[text()='Log in']")).click(); // LOG IN

        Actions actions = new Actions(driver);

      WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));

        actions.
                click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();

// sutun sayısını yazdırın

// tum body'i yazdirin

// body'de bulunan satır sayısını yazdırın

// body'de bulunan satırları yazdırın

// 4.satırdaki elementleri yazdırın

    }
}
