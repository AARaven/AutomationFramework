package com.automationpractice.site.objects.navigation.account;

import com.automationpractice.site.pages.ContactUsPage;
import com.automationpractice.site.pages.authorization.AuthorizationPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import models.user.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

@Getter ( AccessLevel.PRIVATE )
public class AccountRowForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "a[class=login]" ) private       WebElement buttonSignIn;
    @FindBy ( css = "a[class=logout]" ) private      WebElement buttonSignOut;
    @FindBy ( css = "div[id=contact-link]" ) private WebElement buttonContactUs;
    @FindBy ( css = "a[class=account]" ) private     WebElement buttonAccount;
    
    public AccountRowForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public AuthorizationPage clickSignIn() {
        getButtonSignIn().click();
        return new AuthorizationPage( getDriver() );
    }
    
    public ContactUsPage clickContactUs() {
        getButtonContactUs().click();
        return new ContactUsPage( getDriver() );
    }
    
    public void clickAccountButton() {
        getButtonAccount().click();
    }
    
    public AuthorizationPage clickSignOut() {
        getButtonSignOut().click();
        return new AuthorizationPage( getDriver() );
    }
    
    public SoftAssert verifyUser( User user ) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( getButtonAccount().getText(),
                                 user.getFirstName() + " " + ( user.getLastName() ) );
        return softAssert;
    }
}
