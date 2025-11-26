import api.model.UserModel;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static api.steps.UserSteps.*;
import static page.LoginPage.LOGIN_URL;
import static page.MainPage.MAIN_URL;
import static testData.TestData.*;

public class RegisreationTest extends BaseTest {
    private UserModel user;
    private String userAccessToken;

    @Before
    public void setUp() {
        RestAssured.baseURI = MAIN_URL;
    }

    @DisplayName("Успешная регистрация")
    @Description("Проверяет регистрацию с валидными данными")
    @Test
    public void RegistrationSuccess() {
        registerPage.openRegisterPage();
        registerPage.regitrationSteps(NAME, EMAIL, PASSWORD);
        loginPage.waitLoginPage();
        Assert.assertEquals("С регистрацией что-то не так", LOGIN_URL, driver.getCurrentUrl());

        user = new UserModel(EMAIL, PASSWORD, NAME);
    }

    //    Ошибку для некорректного пароля. Минимальный пароль — шесть символов
    @DisplayName("Ошибка для некорректного пароля")
    @Description("Проверяет, что при пароле в 3 символа появляется ошибка - Некорректный пароль")
    @Test
    public void RegistrationWithWrongPasswordFailure() {
        registerPage.openRegisterPage();
        registerPage.regitrationSteps(NAME, EMAIL, WRONG_PASSWORD);
        Assert.assertEquals("Не выводится сообщение о некорректности пароля", "Некорректный пароль", registerPage.getWrongPasswordMessage());
        user = new UserModel(EMAIL, WRONG_PASSWORD, NAME);
    }

    @After
    public void cleanUp() {
        //код для удаления созданного пользователя
        Response resLoginUser = loginUser(user);
        userAccessToken = getUserAccessToken(resLoginUser);
        if (userAccessToken != null) {
            deleteUser(userAccessToken);}
    }
}