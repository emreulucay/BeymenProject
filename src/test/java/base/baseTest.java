package base;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class baseTest {
        static WebDriver webDriver = null;

        @Before
        public void setUp(){
                System.setProperty("webdriver.chrome.driver","C:\\Users\\emreu\\IdeaProjects\\BeymenProject\\driver\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("disable-notifications");
                options.addArguments("disable-popup-blocking");
                setWebDriver(new ChromeDriver(options));
                getWebDriver().navigate().to("https://www.beymen.com/");
        }

        public static WebDriver getWebDriver() {
                return webDriver;
        }

        public static void setWebDriver(WebDriver webDriver) {
                baseTest.webDriver = webDriver;
        }

        public void tearDown() throws InterruptedException {
                Thread.sleep(5000);
                getWebDriver().quit();
        }


}
