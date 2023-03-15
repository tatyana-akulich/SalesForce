package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.dto.Account;
import by.teachmeskills.wrapper.Combobox;
import by.teachmeskills.wrapper.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewAccountModalPage extends BasePage {
    private static final By SAVE_BUTTON = By.xpath("//button[@title='Save']");
    private static final By LOCATOR_FOR_WAITER = By.xpath("//span[text()='Billing Address']");
    public static final By ALERT_WINDOW = By.xpath("//div[@role='alertdialog']");
    public static final By ALERT_TEXT = By.xpath("//span[@data-aura-class = 'forceActionsText']");

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected NewAccountModalPage waitForPageOpening() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR_FOR_WAITER));
        return this;
    }

    public NewAccountModalPage fillInAccountInformation(Account account) {

        new Input(driver, "Account Name").fillInAccount(account.getName());
        new Input(driver, "Fax").fillInAccount(account.getFax());
        new Input(driver, "Phone").fillInAccount(account.getPhone());
        new Input(driver, "Website").fillInAccount(account.getWebsite());
        new Combobox(driver, "Parent Account").fillInAccount(account.getParentAccount());

        driver.findElement(SAVE_BUTTON).click();
        return this;
    }

    public WebElement getAlert() {
        return driver.findElement(ALERT_WINDOW);
    }

    public WebElement getAlertText (){
        return driver.findElement(ALERT_TEXT);
    }
}
