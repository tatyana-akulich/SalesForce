package by.teacmeskills;

import by.teachmeskills.dto.Account;
import by.teachmeskills.page.AccountDetailsPage;
import by.teachmeskills.page.AccountsPage;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.NewAccountModalPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountCreationTest extends BaseTest {
    private Account testAccount;
    private WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void createAccount() {
        testAccount = Account.builder().name(new Faker().name().fullName())
                .fax(new Faker().phoneNumber().phoneNumber())
                .phone(new Faker().phoneNumber().cellPhone())
                .website(new Faker().internet().domainName())
                .parentAccount("Concetta Walker")
                .build();
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

        NewAccountModalPage modalPage = new NewAccountModalPage(driver)
                .fillInAccountInformation(testAccount);
        WebElement alert = modalPage.getAlert();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));
        assertThat(alert.isDisplayed())
                .as("Alert message should be displayed")
                .isTrue();

        WebElement alertText = modalPage.getAlertText();
        assertThat(alertText.getText())
                .as("Alert message should include account name")
                .contains(testAccount.getName());

        assertThat(testAccount)
                .as("Saved account information should be equal to entered")
                .isEqualTo(new AccountDetailsPage(driver).getAccount());


        AccountsPage accountsPage = new AccountsPage(driver).open()
                .waitForPageOpening();
        List<String> names = accountsPage.getNamesOfAccounts();
        assertThat(names)
                .as("Account name should be in the list of names")
                .contains(testAccount.getName());

        accountsPage.deleteAccount(testAccount.getName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Delete Account']")));
        WebElement messageDelete = accountsPage.getDeleteMessage();
        assertThat(messageDelete.isDisplayed())
                .as("Alert message should be displayed")
                .isTrue();

        ((JavascriptExecutor) driver).executeScript("document.querySelector('[title=\"Delete\"]').focus();");
        ((JavascriptExecutor) driver).executeScript("document.querySelector('[title=\"Delete\"]').click();");

        alert = accountsPage.getAlert();
        assertThat(alert.isDisplayed())
                .as("Alert message should be displayed")
                .isTrue();

        alertText = accountsPage.getAlertText();
        assertThat(alertText.getText())
                .as("Alert message should include account name")
                .contains(testAccount.getName());

        names = accountsPage.getNamesOfAccounts();
        assertThat(names)
                .as("Account name shouldn't be in the list of names, account was deleted")
                .doesNotContain(testAccount.getName());
    }
}
