package com.automationpractice.site.objects.authorization;

import com.automationpractice.site.pages.authorization.AccountCreationPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

@Getter ( AccessLevel.PRIVATE )
public class CreateAccountForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBys ( { @FindBy ( css = "form[id='create-account_form']" ),
                 @FindBy ( css = "input[id='email_create'][name='email_create']" ) } )
    private WebElement inputEmail;
    
    @FindBys ( { @FindBy ( css = "form[id='create-account_form']" ),
                 @FindBy ( css = "button[id='SubmitCreate'][name='SubmitCreate']" ) } )
    private WebElement buttonSubmit;
    
    @FindBys ( { @FindBy ( css = "form[id='create-account_form']" ),
                 @FindBy ( css = "div[id='create_account_error'][class='alert']" ) } )
    private WebElement alertInvalidEmail;
    
    public CreateAccountForm sendEmail( String email ) {
        getInputEmail().clear();
        getInputEmail().sendKeys( email );
        return this;
    }
    
    public AccountCreationPage clickSubmit() {
        getButtonSubmit().click();
        return new AccountCreationPage( getDriver() );
    }
    
    public SoftAssert clickSubmitNegative() {
        getButtonSubmit().click();
        SoftAssert softAssert = new SoftAssert();
        
        new WebDriverWait( getDriver(), 5, 100 )
                .until( ExpectedConditions
                                .visibilityOf( getAlertInvalidEmail() ) );
        
        softAssert.assertTrue( getAlertInvalidEmail().isEnabled() );
        softAssert.assertTrue( getAlertInvalidEmail().isDisplayed() );
        softAssert.assertEquals( getAlertInvalidEmail().getText(),
                                 "Invalid email address." );
        return softAssert;
    }
    
    public CreateAccountForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}
