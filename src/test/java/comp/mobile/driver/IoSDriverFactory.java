package comp.mobile.driver;

import comp.mobile.config.IoSConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class IoSDriverFactory implements MobileDriverFactory{



    public  AppiumDriver createDriver()
            throws MalformedURLException {


            IoSConfig ioSConfig  = ConfigFactory.create(IoSConfig.class, System.getProperties());
            Map<String, Object> stringObjectMap = getbstackOptions(ioSConfig);


            XCUITestOptions options = new XCUITestOptions();

            stringObjectMap.put("deviceName", ioSConfig.iosDeviceName());
            stringObjectMap.put("osVersion", ioSConfig.iosOsVersion());

            options.setCapability("platformName", "iOS");
            options.setCapability("appium:automationName", "XCUITest");
            options.setCapability("appium:app", ioSConfig.iosApp());
            options.setCapability("bstack:options", stringObjectMap);

            return new IOSDriver(
                    new URL(ioSConfig.url()),
                    options
            );
        }
    }

