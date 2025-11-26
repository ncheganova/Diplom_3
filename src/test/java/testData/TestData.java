package testData;

import com.github.javafaker.Faker;

public class TestData {
    static Faker user = new Faker();
    public static final String EMAIL = user.name().lastName() + user.regexify("[0-9]{4}") + "@yandex.ru";
    public static final String PASSWORD = user.regexify("[0-9]{8}");
    public static final String WRONG_PASSWORD = user.regexify("[0-9]{3}");
    public static final String NAME = user.name().firstName();
}
