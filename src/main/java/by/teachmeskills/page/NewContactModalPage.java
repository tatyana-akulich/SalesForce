package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.dto.Contact;
import by.teachmeskills.wrapper.Combobox;
import by.teachmeskills.wrapper.Dropdown;
import by.teachmeskills.wrapper.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewContactModalPage extends BasePage {
    private static final By SAVE_BUTTON = By.xpath("//button[text()='Save']");
    private static final By LOCATOR_FOR_WAITER = By.xpath("//label[text()='Description']");
    private static final By CLOSE_POP_UP_WINDOW = By.xpath("//button[@title='Close']");

    public NewContactModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected NewContactModalPage waitForPageOpening() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR_FOR_WAITER));
        return this;
    }

    public void fillInContactInformation(Contact contact) {
        new Dropdown(driver, "Salutation").fillIn(contact.getSalutation());
        new Input(driver, "First Name").fillInContact(contact.getFirstName());
        new Input(driver, "Last Name").fillInContact(contact.getLastName());
        new Combobox(driver, "Account Name").fillInContact(contact.getAccountName());
        new Input(driver, "Title").fillInContact(contact.getTitle());
        new Input(driver, "Phone").fillInContact(contact.getPhone());
        new Input(driver, "Mobile").fillInContact(contact.getMobile());
        new Input(driver, "Email").fillInContact(contact.getEmail());
        new Combobox(driver, "Reports To").fillInContact(contact.getReportsTo());

        driver.findElement(SAVE_BUTTON).click();
        driver.findElement(CLOSE_POP_UP_WINDOW).click();
    }
}
