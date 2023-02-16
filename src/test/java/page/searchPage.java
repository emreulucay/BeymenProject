package page;

import base.basePage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static locaters.locaters.*;

public class searchPage extends basePage {
    public WebElement elementSearch = driver.findElement(SEARCH_AREA);
    public static String cellText;
    public searchPage(WebDriver driver) {
        super(driver);
    }
    public searchPage moveToSearch(){
        hoverElement(SEARCH_AREA);
        return this;
    }
    public searchPage search(String text){
        sendKeys(SEARCH_AREA, text);
        return this;
    }
    public searchPage deleteSearchArea() throws InterruptedException {
        Thread.sleep(4000);
        while (!elementSearch.getAttribute("value").equals("")) {
            elementSearch.sendKeys(Keys.BACK_SPACE);
        }
        logger.INFO("Şort kelimesi silindi, gömlek kelimesi yazılacak");
        return this;
    }
    public searchPage pressEnter() throws InterruptedException {
        Thread.sleep(4000);
        elementSearch.sendKeys(Keys.ENTER);
        logger.INFO("Entera basılıp istenen arama yapıldı.");
        return this;
    }
    // excelden veri almak için
    public searchPage excelRead(int rownum, int cellnum) throws IOException {

            FileInputStream fis = new FileInputStream("src/test/java/resources/beymen.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("beymen");

            Row row = sheet.getRow(rownum);
            Cell cell = row.getCell(cellnum);

            cellText = cell.toString() ;
            logger.INFO("excelden alinan veri : "+cellText+" arama barına yazdırılıyor");

            return this;
    }
}