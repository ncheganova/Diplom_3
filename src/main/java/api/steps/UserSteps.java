package api.steps;

import api.model.UserModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.Endpoints.*;
import static io.restassured.RestAssured.given;

public class UserSteps {
    @Step("Создать пользователя")
    public static Response createUser(UserModel userModel) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(userModel)
                .when()
                .post(CREATE_USER_ENDPOINT)
                .then()
                .log().all()
                .extract().response();
    }
    @Step("Получить токен доступа")
    public static String getUserAccessToken(Response response) {
        return response.path("accessToken");
    }
    @Step("Удалить пользователя")
    public static void deleteUser(String userAccessToken) {
        given()
                .log().all()
                .header("Authorization", userAccessToken)
                .delete(DELETE_USER_ENDPOINT)
                .then()
                .log().all();
    }
}
