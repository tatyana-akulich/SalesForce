package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.util.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class AccountsPage extends BasePage {

    private static final String ACCOUNTS_PAGE_PATH = "/lightning/o/Account/list?filterName=Recent";
    private static final By ACCOUNTS_TITLE_LOCATOR = By.xpath("//span[text()='Accounts' and @class='slds-var-p-right_x-small']");
    @FindBy(xpath = "//div[@title='New']")
    private WebElement NEW_BTN_LOCATOR;
    private static final String ITEM_EDIT_LOCATOR = "//a[@title='%s']//ancestor::tr//td//a[@role='button']";
    private static final By DELETE_BUTTON = By.xpath("//a[@title='Delete']");
    private static final By ACCOUNT_NAMES_LOCATOR = By.xpath("//a[@data-refid = 'recordId']");
    private static final By ALERT_WINDOW = NewAccountModalPage.ALERT_WINDOW;
    private static final By ALERT_TEXT = NewAccountModalPage.ALERT_TEXT;
    private static final By DELETE_CONFIRMATION = By.xpath("//h2[text()='Delete Account']");

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

    public List<String> getNamesOfAccounts() {
        List<WebElement> accounts = driver.findElements(ACCOUNT_NAMES_LOCATOR);
        return accounts.stream()
                .map(element -> element.getAttribute("title"))
                .collect(Collectors.toList());
    }

    public WebElement getAlert() {
        return driver.findElement(ALERT_WINDOW);
    }

    public WebElement getAlertText() {
        return driver.findElement(ALERT_TEXT);
    }

    public WebElement getDeleteMessage() {
        return driver.findElement(DELETE_CONFIRMATION);
    }
}
