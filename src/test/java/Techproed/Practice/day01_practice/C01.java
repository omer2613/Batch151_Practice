package Techproed.Practice.day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();//cok onemli
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//Cok onemli

        // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // ilk kutucuga 20 giriniz
        WebElement ilkKutucuk=driver.findElement(By.xpath("//input[@id='number1']"));
        ilkKutucuk.sendKeys("20");
        // ikinci kutucuga 30 giriniz
        WebElement ikinciKutucuk=driver.findElement(By.xpath("//input[@id='number2']"));
        ikinciKutucuk.sendKeys("30");
        // calculate'e tıklayınız
        WebElement calculateButonu=driver.findElement(By.xpath("//input[@id='calculate']"));
        calculateButonu.click();
        // sonucu yazdırınız
       WebElement sonuc= driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println("Toplamİslaminin Sonucu = " +sonuc.getText());
        // sayfayi kapatiniz
        driver.close();
    }
}
