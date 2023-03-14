package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.util.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class LoginPage extends BasePage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.id("Login");
    private static final By START_MY_FREE_TRIAL_BTN =
            By.xpath("//span[contains (text(),'Start my free trial')]//ancestor::div[contains (@class,'btn-container')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url"));
        waitForPageLoaded();
        return this;
    }

    public HomePage login() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.findElement(username).sendKeys(properties.getProperty("username"));
        driver.findElement(password).sendKeys(properties.getProperty("password"));
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    @Override
    protected LoginPage waitForPageOpening() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(START_MY_FREE_TRIAL_BTN));
        return this;
    }
}