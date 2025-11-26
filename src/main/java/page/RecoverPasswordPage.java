package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
    private WebDriver driver;

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private By enterBtn = By.xpath(".//a[text()='Войти']");

    @Step("Нажать на кнопку Войти")
    public void clickRecoverPasswordBtn() {driver.findElement(enterBtn).click();}
}
