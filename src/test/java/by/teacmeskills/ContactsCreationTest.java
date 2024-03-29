package by.teacmeskills;

import by.teachmeskills.dto.Contact;
import by.teachmeskills.page.ContactsPage;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.NewContactModalPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ContactsCreationTest extends BaseTest {

    private Contact testContact;

    @BeforeClass
    public void addContact() {
        testContact = new Contact();
    }

    @Test
    public void checkContactTest() {
        new LoginPage(driver).open()
                .login()
                .waitForPageOpening();
        new ContactsPage(driver).open()
                .waitForPageOpening()
                .createNewContact();
        new NewContactModalPage(driver).fillInContactInformation(testContact);

        new ContactsPage(driver).open()
                .waitForPageOpening();

        List<WebElement> accounts = driver.findElements(By.xpath("//a[@data-refid = 'recordId']"));
        List<String> names = accounts.stream()
                .map(element -> element.getAttribute("title"))
                .collect(Collectors.toList());
        Assertions.assertThat(names)
                .as("Contact name should be in the list of names")
                .contains(testContact.getFirstName() + " " + testContact.getLastName());
    }
}

