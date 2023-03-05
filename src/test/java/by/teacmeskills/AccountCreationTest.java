package by.teacmeskills;

import by.teachmeskills.page.AccountsPage;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.NewAccountModalPage;
import by.teachmeskills.util.Account;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class AccountCreationTest extends BaseTest {

    @Test
    public void checkAccountCreation() {
        new LoginPage(driver).open()
                .login()
                .waitForPageOpening();
        new AccountsPage(driver).open()
                .waitForPageOpening()
                .createNewAccount();

        Account testAccount = new Account();
        new NewAccountModalPage(driver).fillInAccountInformation(testAccount);
        new AccountsPage(driver).open()
                .waitForPageOpening();
        List<WebElement> accounts = driver.findElements(By.xpath("//a[@data-refid = 'recordId']"));
        List<String> names = accounts.stream()
                .map(element -> element.getAttribute("title"))
                .collect(Collectors.toList());
        Assertions.assertThat(names)
                .as("Account name should be in the list of names")
                .contains(testAccount.getName());
    }
}
