package com.automationpractice.site.objects.authorization;

import com.automationpractice.site.pages.authorization.PasswordRecoveryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class ForgotPasswordForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBys ( { @FindBy ( css = "form[id='form_forgotpassword']" ),
                 @FindBy ( css = "input[id='email']" ) } )
    private WebElement inputEmail;
    
    @FindBys ( { @FindBy ( css = "form[id='form_forgotpassword']" ),
                 @FindBy ( css = "button[type='submit']" ) } )
    private WebElement buttonRetrievePassword;
    
    public ForgotPasswordForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public ForgotPasswordForm sendEmail( String email ) {
        getInputEmail().clear();
        getInputEmail().sendKeys( email );
        return this;
    }
    
    public PasswordRecoveryPage clickRetrievePassword() {
        getButtonRetrievePassword().click();
        return new PasswordRecoveryPage( getDriver() );
    }
}
