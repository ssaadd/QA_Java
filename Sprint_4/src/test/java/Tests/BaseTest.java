package Tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    protected static WebDriver driver;
    private final String baseUrl = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.get(getBaseUrl());
    }

    @After
    public void tearDown() {
        driver.quit();

    }


    public String getBaseUrl() {
        return baseUrl;
    }
}
