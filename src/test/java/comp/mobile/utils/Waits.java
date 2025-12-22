package comp.mobile.utils;

import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {


    private static AppiumDriver driver() {
        return (AppiumDriver) Selenide.webdriver().object();
    }

    /**
     * Ожидание видимости элемента

     */
    public static WebElement waitForVisible(By locator) {
        return new WebDriverWait(driver(), Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Ожидание кликабельности
     существует
     видим
     не перекрыт
     */
    public static WebElement waitForClickable(By locator) {
        return new WebDriverWait(driver(), Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}
