package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
    // Кнопка Заказать хедер
    private final By orderButtonHeader = By.xpath("(//*/text()[normalize-space(.)='Заказать']/parent::*)[1]");
    // Кнопка Заказать тело
    private final By orderButtonBody = By.xpath("(//*/text()[normalize-space(.)='Заказать']/parent::*)[2]");
    private String accHeaderText = "";
    private WebDriver driver;
    // Выбор разных Элементов аккордеона
    // Элемент аккордеона вопросов
    private By accordionElement;
    // Текст элемента аккордеона вопросов
    private By accordionElementText;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccHeaderText() {
        return accHeaderText;
    }

    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    public void clickOrderButtonContent() {
        WebElement element = driver.findElement(orderButtonBody);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void openAccordionElement(String accHeaderText) {
        setAccordionElement(accHeaderText);
        WebElement elementToClick = driver.findElement(accordionElement);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + elementToClick.getLocation().y + ")");
        elementToClick.click();
    }


    public String getAccordionElementText(String accHeaderText) {
        setAccordionElementText(accHeaderText);
        return driver.findElement(accordionElementText).getText();
    }

    public void setAccordionElement(String accHeaderText) {
        this.accordionElement = By.xpath(String.format(".//*[text()[normalize-space(.)='%s']]", accHeaderText));
    }


    public void setAccordionElementText(String accHeaderText) {
        this.accordionElementText = By.xpath(String.format("(.//*[text()[normalize-space(.)='%s']])[1]/following::p[1]", accHeaderText));
    }
}
