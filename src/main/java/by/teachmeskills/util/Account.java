package by.teachmeskills.util;

import com.github.javafaker.Faker;

public class Account {
    private String name;
    private String fax;
    private String phone;
    private String website;

    public Account() {
        name = new Faker().name().fullName();
        fax = new Faker().phoneNumber().phoneNumber();
        phone = new Faker().phoneNumber().cellPhone();
        website = new Faker().internet().domainName();
    }

    public String getName() {
        return name;
    }

    public String getFax() {
        return fax;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }
}
