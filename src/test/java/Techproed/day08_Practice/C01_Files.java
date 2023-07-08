package Techproed.day08_Practice;

import Techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files {
    @Test
    public void test01() {

        // masaustunde bir text dosyası olusturunuz



        // masaustunde text dosyasının olup olmadıgını test ediniz

       // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\altip\\OneDrive\\Masaüstü\\b10 all test cases, code (9).docx")));

        // dinamik hale getirelim

        //     "C:\Users\BURAK              \Desktop\Batch151.txt"
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\OneDrive\\Masaüstü\\b10 all test cases, code (9).docx";

        String dosyaYolu = farkliKisim + ortakKisim;

       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
