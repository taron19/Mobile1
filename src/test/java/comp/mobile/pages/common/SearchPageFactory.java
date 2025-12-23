package comp.mobile.pages.common;

import comp.mobile.driver.Platform;
import comp.mobile.pages.android.SearchPageImpl;
import comp.mobile.pages.ios.SearchPageImpl2;

public class SearchPageFactory {

    public static SearchPage get(Platform platform) {


        if (platform == Platform.ANDROID) {
            return new SearchPageImpl();
        } else {
            return new SearchPageImpl2();
        }
    }
}
