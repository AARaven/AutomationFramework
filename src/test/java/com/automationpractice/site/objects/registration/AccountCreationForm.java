package com.automationpractice.site.objects.registration;

import com.automationpractice.site.pages.account.AccountPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class AccountCreationForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "button[id='submitAccount']" ) private WebElement buttonSubmit;
    
    public AccountPage clickSubmit() {
        getButtonSubmit().click();
        return new AccountPage( getDriver() );
    }
    
    public PersonalInfoForm getPersonalInfoForm() {
        return new PersonalInfoForm( getDriver() );
    }
    
    public AddressForm getAddressForm() {
        return new AddressForm( getDriver() );
    }
    
    public AccountCreationForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}