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

public class ContactsPage extends BasePage {

    private static final String CONTACTS_PAGE_PATH = "/lightning/o/Contact/list?filterName=Recent";
    private static final By CONTACTS_TITLE_LOCATOR = By.xpath("//span[text()='Contacts' and @class='slds-var-p-right_x-small']");
    @FindBy(xpath = "//div[@title='New']")
    private WebElement NEW_BTN_LOCATOR;

    public ContactsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ContactsPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("base.url") + CONTACTS_PAGE_PATH);
        waitForPageLoaded();
        return this;
    }

    public ContactsPage waitForPageOpening() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTACTS_TITLE_LOCATOR));
        return this;
    }

    public NewContactModalPage createNewContact() {
        NEW_BTN_LOCATOR.click();
        return new NewContactModalPage(driver);
    }


}
