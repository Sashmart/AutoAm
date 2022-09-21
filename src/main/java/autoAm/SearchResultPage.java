package autoAm;

import autoAm.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//span[@class='grey-text']")
    protected List<WebElement> carYearList;
    @FindBy(xpath = "//div[@class='pad-top-6 pad-bot-6 makeflex makebetween']")
    protected List<WebElement> carCatalog;
    @FindBy(xpath = "//button[@id='research-btn']")
    protected WebElement searchButton;

    public Integer[] carYear() {
        Integer[] yearCar = new Integer[carYearList.size()];

        for (int i = 1; i < carYearList.size(); i++) {
            yearCar[i] = (Integer.parseInt(carYearList.get(i).getText()));
        }
        return yearCar;
    }

    public void pageForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(searchButton));
    }

    public String[] nameCar() {
        String[] carName = new String[carCatalog.size()];
        for (int i = 1; i < carCatalog.size(); i++) {
            carName[i] = carCatalog.get(i).getText();
        }
        return carName;
    }

}
