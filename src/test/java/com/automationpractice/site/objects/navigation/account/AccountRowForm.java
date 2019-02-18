package com.automationpractice.site.objects.navigation.account;

import com.automationpractice.site.pages.ContactUsPage;
import com.automationpractice.site.pages.authorization.AuthorizationPage;
import lombok.AccessLevel;
import lombok.Getter;
import models.user.User;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.asserts.SoftAssert;

@Getter ( AccessLevel.PRIVATE )
public class AccountRowForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "div[class='row']" ) ,
                 @FindBy ( css = "a[class='login'][title='Log in to your customer account']" ) } )
    private WebElement buttonSignIn;

    @FindBys ( { @FindBy ( css = "div[class='row']" ) ,
                 @FindBy ( css = "a[class='logout'][title='Log me out']" ) } )
    private WebElement buttonSignOut;

    @FindBys ( { @FindBy ( css = "div[class='row']" ) ,
                 @FindBy ( css = "div[id='contact-link'][title='Contact Us']" ) } )
    private WebElement buttonContactUs;
    @FindBys ( { @FindBy ( css = "div[class='row']" ) ,
                 @FindBy ( css = "a[class='account'][title='View my customer account']" ) } )
    private WebElement buttonAccount;

    @FindBy ( css = "div[class='row']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public AccountRowForm( WebDriver driver ) {
        super( driver );
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
        softAssert.assertEquals( getButtonAccount().getText() ,
                                 user.getFirstName() + " " + ( user.getLastName() ) );
        return softAssert;
    }
}
