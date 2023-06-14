package Techproed.day02_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropdownOptions {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin

        driver.get("https://www.amazon.com");

        // dropdown'dan "Baby" secenegini secin
        WebElement ddm =driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select = new Select(ddm);

        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin

        String sectigimoption=select.getFirstSelectedOption().getText();
        System.out.println("Sectigim option: " +sectigimoption);
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
       List<WebElement>  opionsList=select.getOptions();

       int expectedOptionsayisi=28;
       int actuelOptionSayisi=opionsList.size();

        Assert.assertEquals(expectedOptionsayisi,actuelOptionSayisi);

        // dropdown'daki optionların tamamını yazdırın

        int sayac=1;
        for (WebElement each:opionsList
             ) {
            System.out.println(sayac +"  .option"+each.getText());
            sayac++;

        }
            //opionsList.forEach(t-> System.out.println(t.getText()));
        }
    }


