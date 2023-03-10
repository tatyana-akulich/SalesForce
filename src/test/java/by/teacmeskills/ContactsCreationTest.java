package by.teacmeskills;

import by.teachmeskills.page.ContactsPage;
import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.NewContactModalPage;
import by.teachmeskills.dto.Contact;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ContactsCreationTest extends BaseTest {
    private static final By CLOSE_POP_UP_WINDOW = By.xpath("//button[@title='Close']");

    @BeforeClass
    public void addContact(){

    }
    @Test
    public void checkContactTest() {
        new LoginPage(driver).open()
                .login()
                .waitForPageOpening();
        new ContactsPage(driver).open()
                .waitForPageOpening()
                .createNewContact();
        Contact testContact = new Contact();
        new NewContactModalPage(driver).fillInContactInformation(testContact);
        driver.findElement(CLOSE_POP_UP_WINDOW).click();

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
    @AfterClass
    public void deleteContact(){

    }
}

