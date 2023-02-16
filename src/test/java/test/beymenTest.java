package test;

import base.baseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import page.addBasketPage;
import page.homePage;
import page.productSelectPage;
import page.searchPage;

import static page.productSelectPage.productDescription;
import static page.searchPage.cellText;

@TestMethodOrder(MethodOrderer.DisplayName.class)

public class beymenTest extends baseTest {
    homePage homepage ;
    searchPage searchpage;
    addBasketPage addbasketpage;
    productSelectPage productselectpage;

    @Before
    public void before(){
        homepage = new homePage(getWebDriver());
        searchpage = new searchPage(getWebDriver());
        productselectpage = new productSelectPage(getWebDriver());
        addbasketpage = new addBasketPage(getWebDriver());

    }

    @DisplayName("1") // Junit koşum sıralaması için kullanıldı
    @Test
   public void homePageTest() throws InterruptedException {
       try {
           homepage.click().anasayfaControl();

           searchpage
                   .excelRead(0,0).search(cellText)
                   .deleteSearchArea()
                   .excelRead(0,1).search(cellText)
                   .pressEnter();

           productselectpage
                   .productSelectOfList()
                   .productInfoAndPrice()
                   .printTxt(productDescription);

           addbasketpage
                   .SelectProductSize()
                   .addBasket()
                   .goToBasket()
                   .verifyInfo()
                   .quantitySelect()
                   .cleanAndControlBasket();

       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }

   /*
    @DisplayName("2")
    @Test
    public void searchPageTest() throws InterruptedException {
        try {
            searchpage
                    .excelRead(0,0).search(cellText)
                    .deleteSearchArea()
                    .excelRead(0,1).search(cellText)
                    .pressEnter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    */
    @After
    public void driverQuit() throws InterruptedException {
        tearDown();
    }
}
