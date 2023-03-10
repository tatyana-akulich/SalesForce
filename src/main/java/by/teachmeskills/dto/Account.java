package by.teachmeskills.dto;

import com.github.javafaker.Faker;

import java.util.Objects;

public class Account {
    private String name;
    private String fax;
    private String phone;
    private String website;
    private String parentAccount = "Concetta Walker"; //default

    public Account() {
        name = new Faker().name().fullName();
        fax = new Faker().phoneNumber().phoneNumber();
        phone = new Faker().phoneNumber().cellPhone();
        website = new Faker().internet().domainName();
    }

    public Account(String name) {
        this.name = name;
        fax = new Faker().phoneNumber().phoneNumber();
        phone = new Faker().phoneNumber().cellPhone();
        website = new Faker().internet().domainName();
    }

    public Account(String name, String parentAccount) {
        this.name = name;
        this.parentAccount = parentAccount;
    }

    public Account(String name, String fax, String phone, String website, String parentAccount) {
        this.name = name;
        this.fax = fax;
        this.phone = phone;
        this.website = website;
        this.parentAccount = parentAccount;
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

    public String getParentAccount() {
        return parentAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getName(), account.getName()) &&
                Objects.equals(getFax(), account.getFax()) &&
                Objects.equals(getPhone(), account.getPhone()) &&
                Objects.equals(getWebsite(), account.getWebsite()) &&
                Objects.equals(parentAccount, account.parentAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFax(), getPhone(), getWebsite(), parentAccount);
    }
}
