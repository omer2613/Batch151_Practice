package Techproed.day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    // Ulkeler dosyasındaki "Başkent (İngilizce)" sutununu yazdırınız.

    @Test
    public void test01() throws IOException {
        String dosyaYolu="resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        int sonSatirIdx=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatirIdx);
        //getlastRowNum son satir numarasini index olarak verir

/*       //1.YOL
        for (int i = 0; i <=sonSatirIdx; i++) {

           String satirdakiData= C01_ReadExcel.banaDataGetir(i,1);//class ıi static yapip kullandik
            System.out.println(satirdakiData);

 */        // 2.YOL
        /* NOT: banaDataGetir() methodunu ister statik yapip direkt cagirabiliriz
         ister instance yapip farkli class'dan obje olusturarak kullanabiliriz
         veya class isminden sonra nokta koyup methodu cagirabiliriz

          //C01_ReadExcel obj = new C01_ReadExcel();//OBJE OLUSTURDUK
         //String satirdakiData = obj.banaDataGetir(i,1);

        }
*/
        //3.YOL

        for (int i = 0; i <=sonSatirIdx; i++) {
           String satırdakiData= workbook.getSheet("sayfa1").getRow(i).getCell(1).toString();
            System.out.println(satırdakiData);

        }
    }
}
