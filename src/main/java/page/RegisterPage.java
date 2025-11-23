package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegisterPage {
    private WebDriver driver;

    public static final String REGISTER_URL = "https://stellarburgers.education-services.ru/register";

    private By nameInput = By.xpath(".//fieldset[1]/div/div/input");
    private By emailInput = By.xpath(".//fieldset[2]/div/div/input");
    private By passwordInput = By.xpath(".//fieldset[3]/div/div/input");
    private By registerBtn = By.xpath(".//button[text()='Зарегистрироваться']");
    private By wrongPasswordMessage = By.xpath(".//fieldset[3]/div/p");
    private By enterBtn = By.xpath(".//a[text()='Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открыть страницу регистрации")
    public void openRegisterPage() {
        driver.get(REGISTER_URL);
    }
    @Step("Ввести name")
    public void setNameInput(String name) {
        driver.findElement(nameInput).sendKeys(name);}
    @Step("Ввести email")
    public void setEmailInput(String email) {
        driver.findElement(emailInput).sendKeys(email);}
    @Step("Ввести password")
    public void setPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);}
    @Step("Нажать на кнопку Зарегистрироваться")
    public void clickRegisterBtn() {
        driver.findElement(registerBtn).click();
    }
    @Step("Получить инормацию об ошибке некорректного пароля")
    public String getWrongPasswordMessage() {
        return driver.findElement(wrongPasswordMessage).getText();
    }
    @Step("Нажать на кнопку Войти")
    public void clickEnterBtn() {
        driver.findElement(enterBtn).click();
    }
    @Step("Шаги регистрации: ввести имя, email, пароль, нажать на кнопку")
    public void regitrationSteps(String name, String email, String password){
        setNameInput(name);
        setEmailInput(email);
        setPasswordInput(password);
        clickRegisterBtn();
    }
}