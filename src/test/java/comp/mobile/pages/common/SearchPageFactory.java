package comp.mobile.pages.common;

import comp.mobile.driver.Platform;
import comp.mobile.pages.android.SearchPageAndroid;
import comp.mobile.pages.ios.SearchPageIOS;

public class SearchPageFactory {

    public static SearchPage get(Platform platform) {


        if (platform == Platform.ANDROID) {
            return new SearchPageAndroid();
        } else {
            return new SearchPageIOS();
        }
    }
}
