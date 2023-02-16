package base;

import logger.logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class basePage {
    public logger logger = new logger();
    public WebDriver driver = null;
    public WebDriverWait wait = null;
    public basePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public WebElement findElement(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }
    public void sendKeys(By by, String text){
        findElement(by).sendKeys(text);
    }
    public void click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    public void hoverElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }
    public String getText(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }
    public void Control(boolean statement, String onTrue, String onFalse) {
        if (statement == true) {
            logger.INFO(onTrue);
        } else {
            logger.INFO(onFalse);
        }
    }
    public int randomNumber(int size) {
        Random rand = new Random();
        int number = rand.nextInt(1,size);
        return number;
    }

}
