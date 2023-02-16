package page;

import base.basePage;
import org.openqa.selenium.WebDriver;
import static locaters.locaters.*;

public class homePage extends basePage {

    public homePage(WebDriver driver) {
        super(driver);
    }
    public homePage click() throws InterruptedException {

        Thread.sleep(4000);
        click(ACCEPT_COOKIES);

        try {
        Thread.sleep(3000);
        click(GENDER_MAN_SELECT);
        }
        catch (Exception e) {
        logger.ERROR("Cinsiyet seçimi ve çerez kabulü yapılamadı!");
        }
        logger.INFO("Cinsiyet seçimi ve çerez kabulü yapıldı");
        return this;
    }

    public homePage anasayfaControl(){

        String url = driver.getCurrentUrl();
        logger.INFO("URL Bilgisi : "+url);
        Control(url.equals("https://www.beymen.com/"), "Anasayfa kontrolü sağlandi",
                "Anasayfada değilsiniz. Bulunduğunuz sayfa : "+url);

        return this;
    }
}
