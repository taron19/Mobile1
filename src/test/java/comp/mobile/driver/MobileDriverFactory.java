package comp.mobile.driver;

import comp.mobile.config.OwnerConfig;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public interface MobileDriverFactory {

    AppiumDriver createDriver() throws MalformedURLException;

    default Map<String, Object> getbstackOptions(OwnerConfig config) {
          /*BrowserStack требует, чтобы все его настройки лежали внутри capability
         bstack:options*/
        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", System.getProperty("username"));   //   <-  аутентификация
        bstackOptions.put("accessKey", System.getProperty("accessKey"));  //   <-  аутентификация
        bstackOptions.put("projectName", config.projectName());  //   <-  метаданные
        bstackOptions.put("buildName", config.buildName());  //   <-  метаданные
        bstackOptions.put("sessionName", config.sessionName()); //   <-  метаданные

        return bstackOptions;
    }
}

