import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static page.LoginPage.LOGIN_URL;
import static testData.TestData.*;

public class RegisreationTest extends BaseTest {
    @DisplayName("Успешная регистрация")
    @Description("Проверяет регистрацию с валидными данными")
    @Test
    public void RegistrationSuccess() {
        registerPage.openRegisterPage();
        registerPage.regitrationSteps(NAME, EMAIL, PASSWORD);
        loginPage.waitLoginPage();
        Assert.assertEquals("С регистрацией что-то не так", LOGIN_URL, driver.getCurrentUrl());
    }

    //    Ошибку для некорректного пароля. Минимальный пароль — шесть символов
    @DisplayName("Ошибка для некорректного пароля")
    @Description("Проверяет, что при пароле в 3 символа появляется ошибка - Некорректный пароль")
    @Test
    public void RegistrationWithWrongPasswordFailure() {
        registerPage.openRegisterPage();
        registerPage.regitrationSteps(NAME, EMAIL, WRONG_PASSWORD);
        Assert.assertEquals("Не выводится сообщение о некорректности пароля", "Некорректный пароль", registerPage.getWrongPasswordMessage());
    }
}