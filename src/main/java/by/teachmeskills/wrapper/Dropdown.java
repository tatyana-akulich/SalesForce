package by.teachmeskills.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {
    private WebDriver driver;
    private String dropdownLabel;
    private static final String DROPDOWN_ACCOUNT_LOCATOR = "//label[text()='%s']//ancestor::lightning-combobox//button";
    private static final String ITEM_LOCATOR = "//span[@title='%s']";

    public Dropdown(WebDriver driver, String dropdownLabel) {
        this.driver = driver;
        this.dropdownLabel = dropdownLabel;
    }

    public void fillIn (String value){
        driver.findElement(By.xpath(String.format(DROPDOWN_ACCOUNT_LOCATOR, dropdownLabel))).click();
        driver.findElement((By.xpath(String.format(ITEM_LOCATOR, value)))).click();
    }
}
