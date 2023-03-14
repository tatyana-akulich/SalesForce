package by.teacmeskills;

import by.teachmeskills.dto.Account;
import by.teachmeskills.page.AccountDetailsPage;
import by.teachmeskills.page.AccountsPage;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.NewAccountModalPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountCreationTest extends BaseTest {
    private Account testAccount;
    private WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void createAccount() {
        testAccount = new Account();
    }

    @Test
    public void checkAccountCreationAndRemoval() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new LoginPage(driver).open()
                .login()
                .waitForPageOpening();
        new AccountsPage(driver).open()
                .waitForPageOpening()
                .createNewAccount();

        new NewAccountModalPage(driver).fillInAccountInformation(testAccount);

        WebElement alert = driver.findElement(By.xpath("//div[@role='alertdialog']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));
        assertThat(alert.isDisplayed())
                .as("Alert message should be displayed")
                .isTrue();

        WebElement alertText = driver.findElement(By.xpath("//span[@data-aura-class = 'forceActionsText']"));
        assertThat(alertText.getText())
                .as("Alert message should include account name")
                .contains(testAccount.getName());

        assertThat(testAccount)
                .as("Saved account information should be equal to entered")
                .isEqualTo(new AccountDetailsPage(driver).getAccount());

        new AccountsPage(driver).open()
                .waitForPageOpening();
        List<WebElement> accounts = driver.findElements(By.xpath("//a[@data-refid = 'recordId']"));
        List<String> names = accounts.stream()
                .map(element -> element.getAttribute("title"))
                .collect(Collectors.toList());
        assertThat(names)
                .as("Account name should be in the list of names")
                .contains(testAccount.getName());

        new AccountsPage(driver).open()
                .waitForPageOpening()
                .deleteAccount(testAccount.getName());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Delete Account']")));
        WebElement messageDelete = driver.findElement(By.xpath("//h2[text()='Delete Account']"));
        assertThat(messageDelete.isDisplayed())
                .as("Alert message should be displayed")
                .isTrue();

        ((JavascriptExecutor) driver).executeScript("document.querySelector('[title=\"Delete\"]').focus();");
        ((JavascriptExecutor) driver).executeScript("document.querySelector('[title=\"Delete\"]').click();");

        alert = driver.findElement(By.xpath("//div[@role='alertdialog']"));
        assertThat(alert.isDisplayed())
                .as("Alert message should be displayed")
                .isTrue();

        alertText = driver.findElement(By.xpath("//span[@data-aura-class = 'forceActionsText']"));
        assertThat(alertText.getText())
                .as("Alert message should include account name")
                .contains(testAccount.getName());

        accounts = driver.findElements(By.xpath("//a[@data-refid = 'recordId']"));
        names = accounts.stream()
                .map(element -> element.getAttribute("title"))
                .collect(Collectors.toList());
        assertThat(names)
                .as("Account name shouldn't be in the list of names, account was deleted")
                .doesNotContain(testAccount.getName());
    }
}
