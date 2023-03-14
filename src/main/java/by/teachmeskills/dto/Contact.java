package by.teachmeskills.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
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
}

