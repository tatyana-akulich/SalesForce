package by.teachmeskills.util;

import com.github.javafaker.Faker;

public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;

    public Contact() {
        firstName = new Faker().name().firstName();
        lastName = new Faker().name().lastName();
        mobile = new Faker().phoneNumber().phoneNumber();
        email = new Faker().internet().emailAddress();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }
}

