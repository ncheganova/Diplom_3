import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConsructorTest extends BaseTest{
    @DisplayName("Переход к разделу Булки")
    @Description("Проверяет, что при клике на вкладку Булки, вкладка становится активной")
    @Test
    public void clickBunsBtnSelectBuns() {
        mainPage.openMainPage();
        mainPage.clickSaucesBtnBtn();
        mainPage.clickBunBtn();
        assertTrue("Вкладка Булки неактивна", mainPage.isBunSelect());
    }
    @DisplayName("Переход к разделу Соусы")
    @Description("Проверяет, что при клике на вкладку Соусы, вкладка становится активной")
    @Test
    public void clickSoucesBtnSelectSouces() {
        mainPage.openMainPage();
        mainPage.clickSaucesBtnBtn();
        assertTrue("Вкладка Булки неактивна", mainPage.isSousesSelect());
    }
    @DisplayName("Переход к разделу Начинки")
    @Description("Проверяет, что при клике на вкладку Начинки, вкладка становится активной")
    @Test
    public void clickFillingsBtnSelectFillings() {
        mainPage.openMainPage();
        mainPage.clickFillingsBtnBtn();
        assertTrue("Вкладка Булки неактивна", mainPage.isFillingsSelect());
    }
}
