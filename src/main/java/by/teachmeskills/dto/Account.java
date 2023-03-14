package by.teachmeskills.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
public class Account {
    private String name;
    private String fax;
    private String phone;
    private String website;
    private String parentAccount;
}

