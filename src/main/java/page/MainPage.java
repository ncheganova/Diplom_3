package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    public static final String MAIN_URL = "https://stellarburgers.education-services.ru/";

    private By personalAccountBtn = By.xpath(".//a[@href='/account']");
    private By enterToAccountBtn = By.xpath(".//button[text()='Войти в аккаунт']");
    private By bunsBtn = By.xpath(".//span[text()='Булки']");
    private By saucesBtn = By.xpath(".//span[text()='Соусы']");
    private By fillingsBtn = By.xpath(".//span[text()='Начинки']");
    private By bunsSelectedBtn = By.xpath(".//div[contains(@class,'tab_tab_type_current')]/span[text()='Булки']");
    private By saucesSelectedBtn = By.xpath(".//div[contains(@class,'tab_tab_type_current')]/span[text()='Соусы']");
    private By fillingsSelectedBtn = By.xpath(".//div[contains(@class,'tab_tab_type_current')]/span[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public void openMainPage() {
        driver.get(MAIN_URL);
    }
    @Step("Нажать на кнопку Личный кабинет")
    public void clickPersonalAccountBtn() {driver.findElement(personalAccountBtn).click();}
    @Step("Нажать на кнопку Войти в аккаунт")
    public void clickEnterToAccountBtn() {driver.findElement(enterToAccountBtn).click();}
    @Step("Подождать прогрузку главной страницы")
    public void waitMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(MAIN_URL));
    }
    @Step("Нажать на Булки")
    public void clickBunBtn() {driver.findElement(bunsBtn).click();}
    @Step("Проверка, что Булки выбраны")
    public boolean isBunSelect() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(bunsSelectedBtn));
        return driver.findElement(bunsSelectedBtn).isDisplayed();
    }
    @Step("Нажать на Соусы")
    public void clickSaucesBtnBtn() {driver.findElement(saucesBtn).click();}
    @Step("Проверка, что Соусы выбраны")
    public boolean isSousesSelect() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(saucesSelectedBtn));
        return driver.findElement(saucesSelectedBtn).isDisplayed();
    }
    @Step("Нажать на Начинки")
    public void clickFillingsBtnBtn() {driver.findElement(fillingsBtn).click();}
    @Step("Проверка, что Начинки выбраны")
    public boolean isFillingsSelect() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(fillingsSelectedBtn));
        return driver.findElement(fillingsSelectedBtn).isDisplayed();
    }
}
