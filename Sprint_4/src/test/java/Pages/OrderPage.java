package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends MainPage {
    // Поле Фамилия
    private final By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");
    // Поле Имя
    private final By firstNameField = By.xpath("//input[@placeholder='* Имя']");
    // Поле Адресс
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле Метро
    private final By metroField = By.cssSelector("input.select-search__input");
    // Поле Время аренды
    private final By orderDurationField = By.xpath("//*/text()[normalize-space(.)='* Срок аренды']/parent::*");
    // Поле Дата заказа
    private final By orderDateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // Кнопка Далее
    private final By orderNextButton = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");
    // Поле Телефон
    private final By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка Подтвердить заказ
    private final By makeOrderButton = By.xpath("//*/text()[normalize-space(.)='Да']/parent::*");
    // Поле комментарий
    private final By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    // Кнопка Заказать в форме заказа
    private final By formOrderButton = By.xpath("(//*/text()[normalize-space(.)='Заказать']/parent::*)[2]");
    // Модальное Окно
    private final By modalWindow = By.xpath("//div[contains(@class, 'Order_ModalHeader')]");
    // Выбор разных цветов
    // Поле Цвет
    private By colorField;
    private WebDriver driver;
    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setColorSamokat(String colorSamokat) {
        this.colorField = By.xpath(String.format("(//div[contains(., 'Цвет самоката') and contains(@class, 'Order_Title')])/following::label[@for='%s']", colorSamokat));
    }

    public String findModalWindow() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(modalWindow));
        return driver.findElement(modalWindow).getText();
    }

    public void clickMakeOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(makeOrderButton));
        driver.findElement(makeOrderButton).click();
    }

    public void setComment(String commentText) {
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(commentText);
    }

    public void setColor(String colorSamokat) {
        setColorSamokat(colorSamokat);
        driver.findElement(colorField).click();
    }

    public void setOrderDateField(String date) {
        WebElement orderDate = driver.findElement(orderDateField);
        orderDate.sendKeys(date);
        orderDate.sendKeys(Keys.ENTER);
    }

    public void clickNextPage() {
        driver.findElement(orderNextButton).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
    }


    public void clickOrderButtonInForm() {
        driver.findElement(formOrderButton).click();
    }

    public void setOrderDuration(String orderDuration) {
        driver.findElement(orderDurationField).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + orderDuration + "')]")).click();
    }

    public void setMetro(String metroName) {
        WebElement metroFieldElement = driver.findElement(metroField);
        metroFieldElement.sendKeys(metroName);
        metroFieldElement.sendKeys(Keys.DOWN);
        metroFieldElement.sendKeys(Keys.ENTER);
    }

    public void setOrderMainDetails(String firstName, String lastName, String address, String metroName, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setMetro(metroName);
        setPhoneNumber(phoneNumber);
    }

    public void setOrderAdditionalDetails(String date, String duration, String color, String comment) {
        setOrderDateField(date);
        setOrderDuration(duration);
        setColor(color);
        setComment(comment);
    }
}
