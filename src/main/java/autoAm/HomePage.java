package autoAm;

import autoAm.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public final String URL = "https://auto.am/";

    public String model = "bmw";
    public String year = "2006";
    @FindBy(xpath = "//input[@id='searchInp']")
    private WebElement inputModelAndYear;
    @FindBy(xpath = "//div[@class='footer-logo']")
    private WebElement logo;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void goTo() {
        driver.get(URL);
    }
    public void searchByModelAndYear() {
        inputModelAndYear.sendKeys(model + " " + year);
        inputModelAndYear.sendKeys(Keys.ENTER);

    }public void pageForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(logo));
    }

}
