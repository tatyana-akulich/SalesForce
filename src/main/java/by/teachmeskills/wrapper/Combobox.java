package by.teachmeskills.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Combobox {
    private WebDriver driver;
    private String comboboxLabel;
    private static final String ITEM_LOCATOR = "//div[@title='%s']//ancestor::a";
    private static final String COMBOBOX_ACCOUNT_LOCATOR = Input.INPUT_ACCOUNT_LOCATOR;

    public Combobox(WebDriver driver, String comboboxLabel) {
        this.driver = driver;
        this.comboboxLabel = comboboxLabel;
    }

    public void fillIn(String value) {
        driver.findElement(By.xpath(String.format(COMBOBOX_ACCOUNT_LOCATOR, comboboxLabel))).click();
        By item = By.xpath(String.format(ITEM_LOCATOR, value));
        driver.findElement(item).click();
    }
}
