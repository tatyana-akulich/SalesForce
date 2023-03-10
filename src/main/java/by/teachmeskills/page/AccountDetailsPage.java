package by.teachmeskills.page;

import by.teachmeskills.BasePage;
import by.teachmeskills.dto.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPage extends BasePage {
    private static final By ACCOUNT_NAME_LOCATOR =
            By.xpath("//span[text()='Account Name']//ancestor::records-record-layout-item//lightning-formatted-text");
    private static final String ITEM_LOCATOR = "//span[text()='%s']//ancestor::records-record-layout-item//a";

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage waitForPageOpening() {
        return null;
    }

    public Account getAccount() {
        return new Account(driver.findElement(ACCOUNT_NAME_LOCATOR).getText(),
                driver.findElement(By.xpath(String.format(ITEM_LOCATOR, "Fax"))).getText(),
                driver.findElement(By.xpath(String.format(ITEM_LOCATOR, "Phone"))).getText(),
                driver.findElement(By.xpath(String.format(ITEM_LOCATOR, "Website"))).getText(),
                driver.findElement(By.xpath(String.format(ITEM_LOCATOR + "//span", "Parent Account"))).getText());
    }
}
