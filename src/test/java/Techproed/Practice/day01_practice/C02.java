package Techproed.Practice.day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();//cok onemli
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//Cok onemli

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");
        // arama motorunda nutella yazip aratınız
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella" + Keys.ENTER);//submit

        // Customer Service ve Registry butonlarına sırasıyla tıklayın ve title'larının "Amazon" icerdigini test edin


        for (int i=0;i<2;i++){
            List<WebElement> butonlar = driver.findElements(By.xpath("(//a[@tabindex='0'])[6] | (//a[@tabindex='0'])[7]"));
            butonlar.get(i).click();
            if (driver.getTitle().contains("Amazon")){
                System.out.println("Tittle amazon Iceriyor");

            }
            driver.navigate().back();
        }
        // pencereyi kapatiniz
        driver.close();

        //ODEVLER1
        // "/" adresine gidiniz.
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
        // "https://www.n11.com/" adresine gidiniz.
        driver.get("https://www.n11.com");
        // amazon adresine geri donunuz
        driver.navigate().back();
        // n11 adresine ilerleyiniz
        driver.navigate().forward();
        // sayfayi yenileyiniz
        driver.navigate().refresh();
        // pencereyi kapat
        // Konsola "HER ŞEY YOLUNDA" yazdir

        //ODEVLER2

        // ""https://teknosa.com/"" adresine gidiniz
       //driver.get("https://teknosa.com");
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz

        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
        // "https://medunna.com/" adresine gidiniz
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        // teknosa adresine geri donunuz
        // Sayfayı yenileyiniz
        // medunna adresine ilerleyiniz
        // Sayfayı yenileyiniz
        // pencereyi kapat
    }
}
