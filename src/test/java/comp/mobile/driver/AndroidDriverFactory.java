package comp.mobile.driver;

import comp.mobile.config.AndroidConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.stream.Stream;

public class AndroidDriverFactory implements MobileDriverFactory {


    public AppiumDriver createDriver()
            throws MalformedURLException {


        AndroidConfig androidConfig = ConfigFactory.create(AndroidConfig.class, System.getProperties());

        Map<String, Object> stringObjectMap = getbstackOptions(androidConfig);
           /*Его задача
       физически управлять UI Android нажимать кнопки читать текст скроллить искать элементы*/
        UiAutomator2Options options = new UiAutomator2Options();
        stringObjectMap.put("deviceName", androidConfig.androidDeviceName());
        stringObjectMap.put("osVersion", androidConfig.androidOsVersion());

        options.setCapability("platformName", "Android");
        options.setCapability("app", androidConfig.androidApp());
        options.setCapability("automationName", "UiAutomator2");
        options.setCapability("bstack:options", stringObjectMap);


        return new AndroidDriver(
                new URL(androidConfig.url()),
                options
        );
    }

}
