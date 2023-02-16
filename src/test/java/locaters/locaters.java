package locaters;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class locaters {
    public static final By SEARCH_AREA = By.xpath("//*[@class='default-input o-header__search--input']");
    public static final By GENDER_MAN_SELECT = By.id("genderManButton");
    public static final By ACCEPT_COOKIES = By.xpath("//*[@id='onetrust-accept-btn-handler']");

    public static By PRODUCT_TO_CHOOSE = null;
    public void  getRandomNumber(String number)
    {
        PRODUCT_TO_CHOOSE = By.xpath("(//*[@class='m-productCard__desc'])["+number+"]");
    }

    public static final By PRODUCT_INFO = By.xpath("//*[@class='o-productDetail__description']");
    public static final By PRICE_INFO = By.className("m-price__new");
    public static final By SELECT_SIZE_ACTIVE = By.xpath("(//*[@class='m-variation__item' or @class='m-variation__item -criticalStock']) ");

    public static By SELECT_SIZE = null;
    public void  getRandomSize(String number)
    {
        SELECT_SIZE = By.xpath("(//*[@class='m-variation__item'])["+number+"]");
    }

    public static By SELECT_SIZE_CRITICAL = null;
    public void  getRandomSizeCritical(String number)
    {
        SELECT_SIZE_CRITICAL = By.xpath("(//*[@class='m-variation__item -criticalStock'])["+number+"]");
    }

    public static final By ADD_BASKET = By.id("addBasket");
    public static final By BASKET = By.xpath("(//*[@class='o-header__userInfo--text'])[3]");
    public static final By PRICE_OF_BASKET = By.xpath("//*[@class='m-productPrice__salePrice']");
    public static  By QTY_SELECT = By.xpath("//select[@class='a-selectControl -small']");
    public static  By QTY_SELECT_2 = By.id("quantitySelect0-key-0");
    public static final By DELETE_PRODUCT = By.id("removeCartItemBtn0-key-0");
    public static final By IS_BASKET_EMPTY = By.xpath("//*[text()='Sepetinizde Ürün Bulunmamaktadır']");



}
