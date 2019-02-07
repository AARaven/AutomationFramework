package com.automationpractice.Forms.LoginForms;

import com.automationpractice.Pages.AuthorizationPages.PasswordRecoverPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class RetrievePasswordForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id='email']" )
    private WebElement inputEmail;
    
    @FindBy( xpath = "//p[@class='submit']//button[@type='submit']" )
    private WebElement buttonRetrievePassword;
    
    public RetrievePasswordForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public RetrievePasswordForm sendEmail( String email ) {
        this.getInputEmail().clear();
        this.getInputEmail().sendKeys( email );
        return this;
    }
    
    public PasswordRecoverPage clickRetrievePassword() {
        this.getButtonRetrievePassword().click();
        return new PasswordRecoverPage( getDriver() );
    }
}
