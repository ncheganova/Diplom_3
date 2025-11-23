package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public static final String LOGIN_URL = "https://stellarburgers.education-services.ru/login";

    private By recoverPasswordBtn = By.xpath(".//a[text()='Восстановить пароль']");
    private By emailLoginInput = By.xpath(".//fieldset[1]/div/div/input");
    private By passwordloginInput = By.xpath(".//fieldset[2]/div/div/input");
    private By enterBtn = By.xpath(".//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу авторизации")
    public void openLoginPage() {
        driver.get(LOGIN_URL);
    }
    @Step("Нажать на кнопку Восстановить пароль")
    public void clickRecoverPasswordBtn() {driver.findElement(recoverPasswordBtn).click();}
    @Step("Ввести email")
    public void setEmailLoginInput(String email) {
        driver.findElement(emailLoginInput).sendKeys(email);}
    @Step("Ввести password")
    public void setPasswordLoginInput(String password) {
        driver.findElement(passwordloginInput).sendKeys(password);}
    @Step("Нажать на кнопку Войти")
    public void clickEnterBtn() {driver.findElement(enterBtn).click();}
    @Step("Подождать прогрузку страницы авторизации")
    public void waitLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(LOGIN_URL));
    }
    @Step("Шаги авторизации: ввести email, пароль, нажать на кнопку")
    public void loginSteps(String email, String password){
        setEmailLoginInput(email);
        setPasswordLoginInput(password);
        clickEnterBtn();
    }
}
