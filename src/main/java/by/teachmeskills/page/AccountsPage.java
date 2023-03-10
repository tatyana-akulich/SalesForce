package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.util.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class AccountsPage extends BasePage {

    private static final String ACCOUNTS_PAGE_PATH = "/lightning/o/Account/list?filterName=Recent";
    private static final By ACCOUNTS_TITLE_LOCATOR = By.xpath("//span[text()='Accounts' and @class='slds-var-p-right_x-small']");
    @FindBy(xpath = "//div[@title='New']")
    private WebElement NEW_BTN_LOCATOR;
    private static final String ITEM_EDIT_LOCATOR = "//a[@title='%s']//ancestor::tr//td//a[@role='button']";
    private static final By DELETE_BUTTON = By.xpath("//a[@title='Delete']");

    public AccountsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountsPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url") + ACCOUNTS_PAGE_PATH);
        waitForPageLoaded();
        return this;
    }

    public AccountsPage waitForPageOpening() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNTS_TITLE_LOCATOR));
        return this;
    }

    public NewAccountModalPage createNewAccount() {
        NEW_BTN_LOCATOR.click();
        return new NewAccountModalPage(driver);
    }

    public AccountsPage deleteAccount(String name) {
        driver.findElement(By.xpath(String.format(ITEM_EDIT_LOCATOR, name))).click();
        driver.findElement(DELETE_BUTTON).click();
        return this;
    }
}
