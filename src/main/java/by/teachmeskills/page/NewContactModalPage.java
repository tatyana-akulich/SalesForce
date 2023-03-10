package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.dto.Contact;
import by.teachmeskills.wrapper.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewContactModalPage extends BasePage {
    private static final By ACCOUNT_NAME_LOCATOR = By.xpath("//label[text()='Account Name']//ancestor::lightning-grouped-combobox//input");
    private static final By SAVE_BUTTON = By.xpath("//button[text()='Save']");
    private static final By LOCATOR_FOR_WAITER = By.xpath("//label[text()='Description']");

    public NewContactModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected NewContactModalPage waitForPageOpening() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR_FOR_WAITER));
        return this;
    }

    public void fillInContactInformation(Contact contact) {
        new Input(driver, "First Name").fillInContact(contact.getFirstName());
        new Input(driver, "Last Name").fillInContact(contact.getLastName());
        new Input(driver, "Email").fillInContact(contact.getEmail());
        new Input(driver, "Mobile").fillInContact(contact.getMobile());
        driver.findElement(ACCOUNT_NAME_LOCATOR).click();
        driver.findElement(By.xpath("//span[@title='Stella Kutch']")).click();
        driver.findElement(SAVE_BUTTON).click();
    }
}
