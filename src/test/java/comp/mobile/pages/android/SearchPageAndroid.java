package comp.mobile.pages.android;

import comp.mobile.pages.common.SearchPage;
import comp.mobile.utils.Waits;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;


public class SearchPageAndroid implements SearchPage {

    private final By searchButton =
            AppiumBy.accessibilityId("Search Wikipedia");

    private final By searchInput =
            AppiumBy.id("org.wikipedia.alpha:id/search_src_text");

    private final By results =
            AppiumBy.className("android.widget.TextView");

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
            throw new AssertionError("Android: результаты поиска не найдены");
        }
    }
}





