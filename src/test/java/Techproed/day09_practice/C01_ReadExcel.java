package Techproed.day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    // Ulkeler dosyasındaki 3.satırdaki indexin, 3. sutunundaki indexinin
    // "Cezayir" oldugunu test eden method olusturunuz.

    @Test
    public void test01() throws IOException {
        int satirNoIdx=3;
        int sutunNoIdx=3;

       String actuelData= banaDataGetir(satirNoIdx,sutunNoIdx);
       String expecteddata="Cezayir";
        Assert.assertEquals(expecteddata,actuelData);

    }

    public static String banaDataGetir(int satirNoIdx, int sutunNoIdx) throws IOException {
        String dosyaYolu="resources/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);
        //ulkeler dosyasini bizim sistemimize getirdik

        Workbook workbook= WorkbookFactory.create(fis);
        //dosyayi workbook a atadik

        String istenenData=workbook.getSheet("sayfa1").getRow(satirNoIdx).getCell(sutunNoIdx).toString();
        return istenenData;
    }
}
