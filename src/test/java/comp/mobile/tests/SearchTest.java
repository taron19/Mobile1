package comp.mobile.tests;

import comp.mobile.pages.common.SearchPage;
import comp.mobile.pages.common.SearchPageFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.*;


@Tag("mobile")
public class SearchTest extends TestBase {

    private SearchPage searchPage;

    @BeforeEach
    void initPage() {
        step("выбор платформы ", () -> {
            searchPage = SearchPageFactory.get(platform);
            addAttachment(" - ", platform.toString());
        });
    }

    @Test
    void searchTest() {

        step("поиск элемента на странице ", () -> {
            searchPage.search("Russia");
        });


        step("проверка элемента на странице ", () -> {
            searchPage.checkResults();
        });
    }
}