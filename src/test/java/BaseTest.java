import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.LoginPage;
import page.MainPage;
import page.RecoverPasswordPage;
import page.RegisterPage;

public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    RecoverPasswordPage recoverPasswordPage;

    @Before
    public void startUp() {
        String browser = System.getProperty("browser","chrome"); // "chrome" - значение по умолчанию
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if(browser.equals("yandex")) {
            startBrowserYandex();
        }
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        recoverPasswordPage = new RecoverPasswordPage(driver);
    }
    public void startBrowserYandex() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/dell/IdeaProjects/drivers/yandexdriver-25.10.0.2474-win64/yandexdriver.exe");
        driver = new ChromeDriver();
    }
    public void startBrowserChrome() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}