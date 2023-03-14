package by.teachmeskills.dto;

import com.github.javafaker.Faker;

import java.util.Objects;

public class Contact {
    private String salutation;
    private String firstName;
    private String lastName;
    private String accountName;
    private String title;
    private String phone;
    private String mobile;
    private String email;
    private String reportsTo;

    public Contact() {
        salutation = "Проф.";
        firstName = new Faker().name().firstName();
        lastName = new Faker().name().lastName();
        title = "Professor";
        accountName = "Emelina Jerde II";
        phone = new Faker().phoneNumber().phoneNumber();
        mobile = new Faker().phoneNumber().cellPhone();
        email = new Faker().internet().emailAddress();
        reportsTo = "Alex Forest";
    }

    public String getSalutation() {
        return salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getTitle() {
        return title;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getSalutation(), contact.getSalutation()) &&
                Objects.equals(getFirstName(), contact.getFirstName()) &&
                Objects.equals(getLastName(), contact.getLastName()) &&
                Objects.equals(getAccountName(), contact.getAccountName()) &&
                Objects.equals(getTitle(), contact.getTitle()) &&
                Objects.equals(getPhone(), contact.getPhone()) &&
                Objects.equals(getMobile(), contact.getMobile()) &&
                Objects.equals(getEmail(), contact.getEmail()) &&
                Objects.equals(getReportsTo(), contact.getReportsTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSalutation(), getFirstName(), getLastName(), getAccountName(), getTitle(), getPhone(), getMobile(), getEmail(), getReportsTo());
    }
}

