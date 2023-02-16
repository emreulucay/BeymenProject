package page;
import base.basePage;
import locaters.locaters;
import org.openqa.selenium.WebDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static locaters.locaters.*;

public class productSelectPage extends basePage {
    locaters locater = new locaters();
    public productSelectPage(WebDriver driver) {
        super(driver);
    }
    public static int randomNumber;

    public productSelectPage productSelectOfList() throws InterruptedException {

        int productCountOfList = 30; //listedeki ürün sayısı manuel girildi
        logger.INFO("Listedeki Urun Sayisi = " + productCountOfList);
        randomNumber = randomNumber(productCountOfList);
        logger.INFO("Listeden rastgele seçilecek ürün sıra no = " + randomNumber);
        String number = String.valueOf(randomNumber);
        Thread.sleep(2000);
        locater.getRandomNumber(number);
        click(PRODUCT_TO_CHOOSE);
        logger.INFO("Listeden rastgele seçilen ürüne tıklandı.");

        return this;
    }

   static String productInfo;
   public static String priceInfo;
   public static String productDescription;

    public productSelectPage productInfoAndPrice() throws InterruptedException {

        productInfo = getText(PRODUCT_INFO);
        priceInfo = getText(PRICE_INFO);
        productDescription = priceInfo +" --- "+ productInfo;
        logger.INFO("Seçilen Urunun Fiyatı ve Açıklaması = "+productDescription);

        return this;
    }
    public productSelectPage printTxt(String productDescription) {

        String filename = "writtenFile.txt";
        FileWriter fw = null;

        try {
            fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String text = productDescription;
            String lineSeparator = System.getProperty("line.separator");

            pw.write(text);
            pw.write(lineSeparator); // bilgileri satır satır yazdırmak için kullanıldı.
            logger.INFO("Urun açıklamaları writtenFile isimli dosyaya yazdırıldı");
            pw.close();

        } catch (IOException e) {
            logger.INFO("Urun açıklamaları writtenFile isimli dosyaya yazdırılamadı !!!");
            e.printStackTrace();
        }
        return this;

    }

}
