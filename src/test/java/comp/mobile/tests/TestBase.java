package comp.mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import comp.mobile.config.OwnerConfig;
import comp.mobile.helpers.Attach;
import comp.mobile.driver.MobileDriverFactory;
import comp.mobile.driver.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;




public class TestBase {

    //AppiumDriver — это базовый (родительский) класс для всех мобильных драйверов Appium.
    protected static AppiumDriver driver;
    protected OwnerConfig config = ConfigFactory.create(OwnerConfig.class);
    protected static Platform platform;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 30000;
        Configuration.browserSize = null; //в Appium  и в моб приложениях нет браузера и размера окна!
    }

    @BeforeEach
    void startDriver() throws MalformedURLException {

        String platformName = System.getProperty("platform", "android");
        platform = Platform.valueOf(platformName.toUpperCase());

        driver = MobileDriverFactory.createDriver(platform, config);

        WebDriverRunner.setWebDriver(driver);

        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
        );
    }

    @AfterEach
    void tearDown() {

        String sessionId = driver.getSessionId().toString();

        Attach.pageSource();
        Attach.screenshotAs("last screen");

        driver.quit();

        /**
         * Видео на BrowserStack становится доступным только после завершения сессии
         * поэтому драйвер нужно закрыть ДО запроса видео.
         */
        Attach.addVideo(sessionId);
    }
}
