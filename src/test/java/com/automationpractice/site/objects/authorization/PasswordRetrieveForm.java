package com.automationpractice.site.objects.authorization;

import com.automationpractice.site.pages.authorization.PasswordRecoveryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class PasswordRetrieveForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "input[id='email']" )                              private  WebElement inputEmail;
    @FindBy ( xpath = "//p[@class='submit']//button[@type='submit']" ) private  WebElement buttonRetrievePassword;
    
    public PasswordRetrieveForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public PasswordRetrieveForm sendEmail( String email ) {
        getInputEmail().clear();
        getInputEmail().sendKeys( email );
        return this;
    }
    
    public PasswordRecoveryPage clickRetrievePassword() {
        getButtonRetrievePassword().click();
        return new PasswordRecoveryPage( getDriver() );
    }
}
