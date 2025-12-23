package comp.mobile.pages.ios;

import comp.mobile.pages.common.SearchPage;
import comp.mobile.utils.Waits;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;

public class SearchPageImpl2 implements SearchPage {



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
}