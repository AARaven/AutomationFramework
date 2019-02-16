package com.automationpractice.site.objects.authorization;

import com.automationpractice.site.pages.account.AccountPage;
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
public class LoginForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBys ( { @FindBy ( css = "form[id='login_form']" ),
                 @FindBy ( css = "input[id='email']" ) } )
    private WebElement inputEmail;
    
    @FindBys ( { @FindBy ( css = "form[id='login_form']" ),
                 @FindBy ( css = "input[id='passwd']" ) } )
    private WebElement inputPassword;
    
    @FindBys ( { @FindBy ( css = "form[id='login_form']" ),
                 @FindBy ( css = "a[title='Recover your forgotten password']" ) } )
    private WebElement linkRecoverForgottenPassword;
    
    @FindBys ( { @FindBy ( css = "form[id='login_form']" ),
                 @FindBy ( css = "button[id='SubmitLogin']" ) } )
    private WebElement buttonSubmit;
    
    public LoginForm sendEmail( String email ) {
        getInputEmail().clear();
        getInputEmail().sendKeys( email );
        return this;
    }
    
    public LoginForm sendPassword( String password ) {
        getInputPassword().clear();
        getInputPassword().sendKeys( password );
        return this;
    }
    
    public PasswordRecoveryPage clickRecoverPassword() {
        getLinkRecoverForgottenPassword().click();
        return new PasswordRecoveryPage( getDriver() );
    }
    
    public AccountPage clickSignIn() {
        getButtonSubmit().click();
        return new AccountPage( getDriver() );
    }
    
    public LoginForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}
