package comp.mobile.driver;

import comp.mobile.config.OwnerConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MobileDriverFactory {

    public static AppiumDriver createDriver(Platform platform, OwnerConfig config)
            throws MalformedURLException {
        /*BrowserStack требует, чтобы все его настройки лежали внутри capability
         bstack:options*/
        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", System.getProperty("username"));   //   <-  аутентификация
        bstackOptions.put("accessKey", System.getProperty("accessKey"));  //   <-  аутентификация
        bstackOptions.put("projectName", config.projectName());  //   <-  метаданные
        bstackOptions.put("buildName", config.buildName());  //   <-  метаданные
        bstackOptions.put("sessionName", config.sessionName()); //   <-  метаданные

        if (platform == Platform.ANDROID) {
           /*Его задача
       физически управлять UI Android нажимать кнопки читать текст скроллить искать элементы*/
            UiAutomator2Options options = new UiAutomator2Options();
            bstackOptions.put("deviceName", config.androidDeviceName());
            bstackOptions.put("osVersion", config.androidOsVersion());

            options.setCapability("platformName", "Android");
            options.setCapability("app", config.androidApp());
            options.setCapability("automationName", "UiAutomator2");
            options.setCapability("bstack:options", bstackOptions);

            return new AndroidDriver(
                    new URL(config.url()),
                    options
            );

        } else {

            XCUITestOptions options = new XCUITestOptions();

            bstackOptions.put("deviceName", config.iosDeviceName());
            bstackOptions.put("osVersion", config.iosOsVersion());

            options.setCapability("platformName", "iOS");
            options.setCapability("appium:automationName", "XCUITest");
            options.setCapability("appium:app", config.iosApp());
            options.setCapability("bstack:options", bstackOptions);

            return new IOSDriver(
                    new URL(config.url()),
                    options
            );
        }
    }
}
