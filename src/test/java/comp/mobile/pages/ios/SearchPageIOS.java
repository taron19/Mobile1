package comp.mobile.pages.ios;

import comp.mobile.pages.common.SearchPage;
import comp.mobile.utils.Waits;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;

public class SearchPageIOS implements SearchPage {



    private final By searchButton =
            AppiumBy.accessibilityId("Search");

    private final By searchInput =
            AppiumBy.accessibilityId("Search Wikipedia");

    private final By results =
            AppiumBy.iOSClassChain("**/XCUIElementTypeCell");

    @Override
    public void search(String text) {
        Waits.waitForClickable(searchButton).click();
        Waits.waitForClickable(searchInput).sendKeys(text);
    }

    @Override
    public void checkResults() {
        int size = Waits.waitForVisible(results)
                .findElements(results)
                .size();

        if (size == 0) {
            throw new AssertionError("iOS: результаты поиска не найдены");
        }
    }







    //private OwnerConfig configOwner = getConfigOwner();





/*
    @Test
    void successfulSearchTestIOS() throws Exception {

        // ===== 1. CAPABILITIES =====
        XCUITestOptions options = new XCUITestOptions();

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", configOwner.userName());
        bstackOptions.put("accessKey", configOwner.accessKey());
        bstackOptions.put("deviceName", configOwner.iosDeviceName());
        bstackOptions.put("osVersion", configOwner.iosOsVersion());
        bstackOptions.put("projectName", configOwner.projectName());
        bstackOptions.put("buildName", configOwner.buildName());
        bstackOptions.put("sessionName", "iOS Search Test");

        options.setCapability("platformName", "iOS");
        options.setCapability("automationName", "XCUITest");
        options.setCapability("app", configOwner.iosApp());
        options.setCapability("bstack:options", bstackOptions);

        IOSDriver driver = new IOSDriver(
                new URL(configOwner.url()),
                options
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // ===== 2. TEST =====
        WebElement search = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Search")
                )
        );
        search.click();

        WebElement searchField = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Search Wikipedia")
                )
        );
        searchField.sendKeys("Russia");
*/

       // List<WebElement> results = wait.until(
            //    ExpectedConditions.presenceOfAllElementsLocatedBy(
               //         AppiumBy.iOSClassChain("**/XCUIElementTypeCell")
              //  )
      //  );

       // assert results.size() > 0 : "iOS: результаты не найдены";

       // driver.quit();


}