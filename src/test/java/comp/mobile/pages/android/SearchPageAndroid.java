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

   /* @Test
    void successfulSearchTestComplete() throws MalformedURLException, InterruptedException {



        // ========== 1. НАСТРОЙКА КАПАБИЛИТИ ==========
        UiAutomator2Options options = new UiAutomator2Options();

        // Настройки BrowserStack (все в bstack:options)
        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", configOwner.userName());
        bstackOptions.put("accessKey", configOwner.accessKey());
        // Используем устройство из примера BrowserStack, которое точно поддерживается
        bstackOptions.put("deviceName", configOwner.androidDeviceName()); // Изменили устройство
        bstackOptions.put("osVersion", configOwner.androidOsVersion()); // Исправляем версию ОС для нового устройства
        bstackOptions.put("projectName", configOwner.projectName());
        bstackOptions.put("buildName", configOwner.buildName());
        bstackOptions.put("sessionName", configOwner.sessionName());

        // Ключевые capabilities БЕЗ префикса appium:
        options.setCapability("platformName", "Android");
        options.setCapability("app", configOwner.androidApp()); // Оставляем демо-приложение

        // Appium-специфичные настройки
        options.setCapability("appium:automationName", "UiAutomator2");

        // Присоединяем настройки BrowserStack
        options.setCapability("bstack:options", bstackOptions);

        // ========== 2. ИНИЦИАЛИЗАЦИЯ ДРАЙВЕРА ==========
        AndroidDriver driver = new AndroidDriver(new URL(configOwner.url()), options);

        // ========== 3. ВЫПОЛНЕНИЕ ТЕСТОВОГО СЦЕНАРИЯ ==========

        // Ждём и кликаем на кнопку поиска
        WebElement searchElement = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Search Wikipedia")));
        searchElement.click();

        // Ждём поле ввода и вводим текст
        WebElement insertTextElement = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("Russia");


        // Ждём результаты
        Thread.sleep(5000);

        // Проверяем, что найдены результаты
        List<WebElement> allProductsName = driver.findElements(AppiumBy.className("android.widget.TextView"));
        assert (allProductsName.size() > 0) : "Не найдено ни одного результата поиска";

        System.out.println("Тест успешно выполнен! Найдено результатов: " + allProductsName.size());

        driver.quit();

    }*/





