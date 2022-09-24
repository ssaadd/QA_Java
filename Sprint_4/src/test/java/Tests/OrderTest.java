package Tests;

import Pages.MainPage;
import Pages.OrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class OrderTest extends FunctionalTests {


    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroName;
    private final String phoneNumber;
    private final String date;
    private final String duration;
    private final String color;
    private final String comment;
    private final String result;

    public OrderTest(String firstName, String lastName, String address, String metroName, String phoneNumber, String date, String duration, String color, String comment, String result) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroName = metroName;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.duration = duration;
        this.color = color;
        this.comment = comment;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Имя", "Фамилия", "г. Москва", "Университет", "+7900000000", "01.01.2022", "сутки", "grey", "hello", "Заказ оформлен"},
                {"Иван", "Петров", "г. Новосибирск", "Сокольники", "+79999911111", "01.01.2023", "трое суток", "black", "", "Заказ оформлен"},

        };
    }

    @Test
    public void testOrderSamokatHeader() {
        MainPage objMainPage = new MainPage(driver);
        // Нажать кнопку «Заказать» в хедере
        objMainPage.clickOrderButtonHeader();

        OrderPage objOrderPage = new OrderPage(driver);
        // Заполнить первую страницу форму заказа
        objOrderPage.setOrderMainDetails(firstName, lastName, address, metroName, phoneNumber);


        // Перейти на вторую страницу формы
        objOrderPage.clickNextPage();

        // Заполнить вторую страницу формы заказа
        objOrderPage.setOrderAdditionalDetails(date, duration, color, comment);

        // Нажать Заказать
        objOrderPage.clickOrderButtonInForm();

        // Подтвердить Заказ
        objOrderPage.clickMakeOrder();

        // Проверить появляется Окно с Заказ оформлен
        assertThat("Сообщение Заказ оформлен не появилось", objOrderPage.findModalWindow(), containsString(result));
    }


    @Test
    public void testOrderSamokatBody() {
        MainPage objMainPage = new MainPage(driver);
        // Нажать кнопку «Заказать» в основной части страницы
        objMainPage.clickOrderButtonContent();

        OrderPage objOrderPage = new OrderPage(driver);
        // Заполнить первую страницу форму заказа
        objOrderPage.setOrderMainDetails(firstName, lastName, address, metroName, phoneNumber);


        // Перейти на вторую страницу формы
        objOrderPage.clickNextPage();

        // Заполнить вторую страницу формы заказа
        objOrderPage.setOrderAdditionalDetails(date, duration, color, comment);

        // Нажать Заказать
        objOrderPage.clickOrderButtonInForm();

        // Подтвердить Заказ
        objOrderPage.clickMakeOrder();

        // Проверить появляется Окно с Заказ оформлен
        assertThat("Сообщение Заказ оформлен не появилось", objOrderPage.findModalWindow(), containsString(result));
    }

}
