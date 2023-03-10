package by.teachmeskills.wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    private WebDriver driver;
    private String inputLabel;

    public static final String INPUT_ACCOUNT_LOCATOR = "//span[text()='%s']//ancestor::div[@class='slds-form-element__control']//input";
    private static final String INPUT_CONTACT_LOCATOR = "//label[text()='%s']//ancestor::lightning-input//input";

    public Input(WebDriver driver, String inputLabel) {
        this.driver = driver;
        this.inputLabel = inputLabel;
    }

    public void fillInAccount(String value) {
        driver.findElement(By.xpath(String.format(INPUT_ACCOUNT_LOCATOR, inputLabel))).sendKeys(value);
    }

    public void fillInContact(String value) {
        driver.findElement(By.xpath(String.format(INPUT_CONTACT_LOCATOR, inputLabel))).sendKeys(value);
    }
}
