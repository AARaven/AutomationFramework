package com.automationpractice.Forms.LoginForms;

import com.automationpractice.Pages.AuthorizationPages.CreateAccountPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class CreateAccountForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id='email_create']" )  private WebElement inputEmail;
    @FindBy( css = "button[id='SubmitCreate']" ) private WebElement buttonSubmit;
    
    public CreateAccountForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CreateAccountForm sendEmail( String email ) {
        this.getInputEmail().clear();
        this.getInputEmail().sendKeys( email );
        return this;
    }
    
    public CreateAccountPage clickSubmit() {
        this.getButtonSubmit().click();
        return new CreateAccountPage( getDriver() );
    }
}
