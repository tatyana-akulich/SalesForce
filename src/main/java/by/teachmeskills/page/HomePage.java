package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.util.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class HomePage extends BasePage {

    private By graph = By.xpath("//div[@class='ps-container']");
    private static final String HOME_PAGE_PATH = "/lightning/page/home";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    protected HomePage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url") + HOME_PAGE_PATH);
        waitForPageLoaded();
        return this;
    }

    public HomePage waitForPageOpening() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(graph));
        return this;
    }
}
