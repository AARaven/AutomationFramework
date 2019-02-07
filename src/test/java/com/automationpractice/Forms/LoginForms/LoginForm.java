package com.automationpractice.Forms.LoginForms;

import com.automationpractice.Pages.AccountPages.AccountPage;
import com.automationpractice.Pages.AuthorizationPages.PasswordRecoverPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class LoginForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id='email']" )
    private WebElement inputEmail;
    
    @FindBy( css = "input[id='passwd']" )
    private WebElement inputPassword;
    
    @FindBy( css = "a[title='Recover your forgotten password']" )
    private WebElement linkRecoverForgottenPassword;
    
    @FindBy( css = "button[id='SubmitLogin']" )
    private WebElement buttonSubmit;
    
    public LoginForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public LoginForm sendEmail( String email ) {
        this.getInputEmail().clear();
        this.getInputEmail().sendKeys( email );
        return this;
    }
    
    public LoginForm sendPassword( String password ) {
        this.getInputPassword().clear();
        this.getInputPassword().sendKeys( password );
        return this;
    }
    
    public PasswordRecoverPage clickRecoverPassword() {
        this.getLinkRecoverForgottenPassword().click();
        return new PasswordRecoverPage( getDriver() );
    }
    
    public AccountPage clickSignIn() {
        this.getButtonSubmit().click();
        return new AccountPage( getDriver() );
    }
}
