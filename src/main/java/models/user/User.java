package models.user;

import lombok.Data;
import models.user.enums.Genders;
import models.user.enums.Months;

@Data
public class User {

    private Genders gender;
    private String  firstName;
    private String  lastName;
    private String  email;
    private String  password;
    private String  day;
    private Months  months;
    private String  year;
    private Address address;
    private String  additionalInfo;
    private String  homePhone;
    private String  mobilePhone;
    private String  alias;
    private boolean newsLetter;
    private boolean specialOffers;
}