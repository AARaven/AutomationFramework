package com.automationpractice.site.objects.authorization;

import com.automationpractice.site.pages.authorization.AccountCreationPage;
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
    
    @FindBy ( css = "input[id='email_create']" )  private  WebElement inputEmail;
    @FindBy ( css = "button[id='SubmitCreate']" ) private  WebElement buttonSubmit;
    
    public AccountCreationForm sendEmail( String email ) {
        getInputEmail().clear();
        getInputEmail().sendKeys( email );
        return this;
    }
    
    public AccountCreationPage clickSubmit() {
        getButtonSubmit().click();
        return new AccountCreationPage( getDriver() );
    }
    
    public AccountCreationForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}
