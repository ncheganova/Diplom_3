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
import static page.MainPage.MAIN_URL;
import static testData.TestData.*;

public class LoginTest extends BaseTest{
    private UserModel user;
    private String userAccessToken;

    @Before
    public void setUp() {
        RestAssured.baseURI = MAIN_URL;
        user = new UserModel(EMAIL, PASSWORD, NAME);
        Response resCreateUser = createUser(user);
        userAccessToken = getUserAccessToken(resCreateUser);
    }

    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Проверяет авторизацию чрез кнопку «Войти в аккаунт» на главной")
    @Test
    public void LoginOnMainPageEnterToAccountBtn() {
        mainPage.openMainPage();
        mainPage.clickEnterToAccountBtn();
        loginPage.waitLoginPage();
        loginPage.loginSteps(EMAIL, PASSWORD);
        mainPage.waitMainPage();
        Assert.assertEquals("С авторизацией что-то не так", MAIN_URL, driver.getCurrentUrl());
    }
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверяет авторизацию чрез кнопку «Личный кабинет» на главной")
    @Test
    public void LoginOnMainPagePersonalAccountBtn() {
        mainPage.openMainPage();
        mainPage.clickPersonalAccountBtn();
        loginPage.waitLoginPage();
        loginPage.loginSteps(EMAIL, PASSWORD);
        mainPage.waitMainPage();
        Assert.assertEquals("С авторизацией что-то не так", MAIN_URL, driver.getCurrentUrl());
    }
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверяет авторизацию чрез кнопку в форме регистрации")
    @Test
    public void LoginOnRegisterPageEnterBtn(){
        registerPage.openRegisterPage();
        registerPage.clickEnterBtn();
        loginPage.waitLoginPage();
        loginPage.loginSteps(EMAIL, PASSWORD);
        mainPage.waitMainPage();
        Assert.assertEquals("С авторизацией что-то не так", MAIN_URL, driver.getCurrentUrl());
    }
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверяет авторизацию чрез кнопку в форме восстановления пароля")
    @Test
    public void LoginOnRecoverPasswordBtn(){
        loginPage.openLoginPage();
        loginPage.clickRecoverPasswordBtn();
        recoverPasswordPage.clickRecoverPasswordBtn();
        loginPage.waitLoginPage();
        loginPage.loginSteps(EMAIL, PASSWORD);
        mainPage.waitMainPage();
        Assert.assertEquals("С авторизацией что-то не так", MAIN_URL, driver.getCurrentUrl());
    }

    @After
    public void cleanUp() {
        //код для удаления созданного пользователя
        deleteUser(userAccessToken);
    }
}