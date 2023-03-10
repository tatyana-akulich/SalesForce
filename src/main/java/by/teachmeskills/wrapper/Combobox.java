package by.teachmeskills.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Combobox {
    private WebDriver driver;
    private String comboboxLabel;
    private static final String ACCOUNT_ITEM_LOCATOR = "//div[@title='%s']//ancestor::a";
    private static final String CONTACT_ITEM_LOCATOR = "//span[@title='%s']";
    private static final String COMBOBOX_ACCOUNT_LOCATOR = Input.INPUT_ACCOUNT_LOCATOR;
    private static final String COMBOBOX_CONTACT_LOCATOR = "//label[text()='%s']//ancestor::lightning-grouped-combobox//input";

    public Combobox(WebDriver driver, String comboboxLabel) {
        this.driver = driver;
        this.comboboxLabel = comboboxLabel;
    }

    public void fillInAccount(String value) {
        driver.findElement(By.xpath(String.format(COMBOBOX_ACCOUNT_LOCATOR, comboboxLabel))).click();
        driver.findElement(By.xpath(String.format(ACCOUNT_ITEM_LOCATOR, value))).click();
    }

    public void fillInContact(String value) {
        driver.findElement(By.xpath(String.format(COMBOBOX_CONTACT_LOCATOR, comboboxLabel))).click();
        driver.findElement(By.xpath(String.format(CONTACT_ITEM_LOCATOR, value))).click();
    }
}
