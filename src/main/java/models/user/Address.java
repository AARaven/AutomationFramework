package models.user;

import lombok.Data;
import models.user.enums.States;

@Data
public class Address {

    private String country;
    private States state;
    private String city;
    private String zipCode;
    private String address;
    private String addressSecondLine;
    private String company;
}
