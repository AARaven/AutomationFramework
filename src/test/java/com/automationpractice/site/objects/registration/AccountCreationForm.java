package com.automationpractice.site.objects.registration;

import com.automationpractice.site.pages.account.AccountPage;
import lombok.AccessLevel;
import lombok.Getter;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

@Getter ( AccessLevel.PROTECTED )
public class AccountCreationForm extends AbstractWebForm {
    
    @FindBy ( css = "form#account-creation_form" )
    protected WebElement mainForm;
    
    @FindBys ( { @FindBy ( css = "form[id='account-creation_form']" ),
                 @FindBy ( css = "button[id='submitAccount'][name='submitAccount']" ) } )
    private WebElement buttonSubmit;
    
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
        super( driver );
        
    }
}
