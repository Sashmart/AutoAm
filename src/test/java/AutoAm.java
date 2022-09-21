import autoAm.HomePage;
import autoAm.SearchResultPage;
import createDriver.CommonActions;
import createDriver.Config;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class AutoAm {

    @Test
    public void autoAmTest() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
        HomePage homePage = new HomePage(CommonActions.getDriver());
        homePage.goTo();
        homePage.pageForLoad();
        homePage.searchByModelAndYear();
        SearchResultPage searchResultPage = new SearchResultPage(CommonActions.getDriver());
        searchResultPage.pageForLoad();
        for (int i = 1; i < searchResultPage.carYear().length; i++) {
            Assert.assertTrue(searchResultPage.carYear()[i] >= Integer.parseInt(homePage.year));

        }
        for (int i = 1; i < searchResultPage.nameCar().length; i++) {
            Assert.assertTrue(searchResultPage.nameCar()[i].contains(homePage.model));

        }
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = CommonActions.getDriver();
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
