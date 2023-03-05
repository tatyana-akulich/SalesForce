package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.util.Account;
import by.teachmeskills.wrapper.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountModalPage extends BasePage {
    private static final By SAVE_BUTTON = By.xpath("//button[@title='Save']");

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    public void fillInAccountInformation(Account account){
        new Input(driver, "Account Name").fillInAccount(account.getName());
        new Input(driver, "Fax").fillInAccount(account.getFax());
        new Input(driver, "Phone").fillInAccount(account.getPhone());
        new Input(driver, "Website").fillInAccount(account.getWebsite());

        driver.findElement(SAVE_BUTTON).click();
    }
}
