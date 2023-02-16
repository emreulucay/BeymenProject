package page;
import base.basePage;
import locaters.locaters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static locaters.locaters.*;

public class addBasketPage extends basePage {

  //  public static int randomSize;
    locaters locater = new locaters();
    public addBasketPage(WebDriver driver) {

        super(driver);
    }
    static String productSizeOfCount;
    public addBasketPage SelectProductSize() throws InterruptedException {
        for (int i = 1; i < 4; i++) {

            try {
//        randomSize = randomNumber(productSizeOfCount);
//        String number = String.valueOf(randomSize);
                Thread.sleep(2000);
                productSizeOfCount = String.valueOf(i);
                locater.getRandomSize(productSizeOfCount);
                click(SELECT_SIZE);
                String size = getText(SELECT_SIZE);
                logger.INFO("Sepete eklemek için beden seçimi yapıldı, Seçilen beden ölçüsü : " + size);
            } catch (Exception e) {

                try {
                    Thread.sleep(2000);
                    productSizeOfCount = String.valueOf(i);
                    locater.getRandomSizeCritical(productSizeOfCount);
                    click(SELECT_SIZE_CRITICAL);
                    String size = getText(SELECT_SIZE_CRITICAL);
                    logger.INFO("Sepete eklemek için beden seçimi yapıldı, Seçilen beden ölçüsü : " + size);
                } catch (Exception e1) {
                    logger.ERROR("Beden seçimi yapılamadı");
                }
            }
            break;
        }
        return this;
    }

    public addBasketPage addBasket() throws InterruptedException {
        try {
            Thread.sleep(3000);
            click(ADD_BASKET);
            logger.INFO("Urun sepete eklendi");
        }
        catch (Exception e){
            logger.ERROR("Urun sepete eklenemedi");
        }
        return this;
    }
    public addBasketPage goToBasket() throws InterruptedException {
        try {

            Thread.sleep(5000);
            click(BASKET);
            logger.INFO("Sepete gidildi");
        }
        catch (Exception e){
            logger.ERROR("Sepete gidilemedi !!");
        }
        return this;
    }

    static String priceInfo,priceofbasket;
    public addBasketPage verifyInfo() throws InterruptedException {
        Thread.sleep(3000);
        priceofbasket = getText(PRICE_OF_BASKET);
        logger.INFO("sepetteki fiyatı :" +priceofbasket);
        Thread.sleep(3000);
        logger.INFO("liste fiyatı: "+priceInfo);
        try {
            Control(priceofbasket.equals(priceInfo),"fiyatlar aynı" ,"fiyatlar farklı");
            logger.INFO("Seçilen Urunun SEPET Fiyatı ve LISTE Fiyatı karşılaştırıldı ve aynı olduğu görüldü");
        }
        catch (Exception e){
            logger.ERROR("Seçilen Urunun SEPET Fiyatı ve LISTE Fiyatı karşılaştırıldı ve FARKLI olduğu görüldü");
        }
        return this;
    }
    public WebElement elementqty = driver.findElement(QTY_SELECT);
    public WebElement elementqty2 = driver.findElement(QTY_SELECT_2);
    public addBasketPage quantitySelect() throws InterruptedException {
        Thread.sleep(3000);
        Select select = new Select(elementqty);
        try {
            select.selectByIndex(1);
            logger.INFO("Urun 2 adet seçildi");
        }
        catch (Exception e){
            Thread.sleep(3000);
            Select select2 = new Select(elementqty2);
            try {
                select2.selectByIndex(1);
                logger.INFO("try-catch bloğu 1.catch çalıştı");
                logger.INFO("Urun 2 adet seçildi");
            }catch (Exception e2) {
                select2.selectByIndex(0);
                logger.INFO("Urun iki adet secilemedi stok yok, 1 adet olarak kaldı");
            }
        }
        String elementquantity = elementqty.getAttribute("value");
        Control(elementquantity.equals(2), "Urun adedi 2 olarak seçildi",
                "stok olmadığı için 2 adet seçilemedi");

        return this;
    }

}