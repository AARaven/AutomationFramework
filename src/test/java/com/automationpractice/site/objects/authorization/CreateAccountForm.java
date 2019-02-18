package com.automationpractice.site.objects.authorization;

import com.automationpractice.site.pages.authorization.AccountCreationPage;
import lombok.AccessLevel;
import lombok.Getter;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

@Getter ( AccessLevel.PRIVATE )
public class CreateAccountForm extends AbstractWebForm {

    @FindBy ( css = "form[id='create-account_form']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    @FindBys ( { @FindBy ( css = "form[id='create-account_form']" ) ,
                 @FindBy ( css = "input[id='email_create'][name='email_create']" ) } )
    private WebElement inputEmail;

    @FindBys ( { @FindBy ( css = "form[id='create-account_form']" ) ,
                 @FindBy ( css = "button[id='SubmitCreate'][name='SubmitCreate']" ) } )
    private WebElement buttonSubmit;

    @FindBys ( { @FindBy ( css = "form[id='create-account_form']" ) ,
                 @FindBy ( css = "div[id='create_account_error'][class='alert']" ) } )
    private WebElement alertInvalidEmail;

    public CreateAccountForm( WebDriver driver ) {
        super( driver );
    }

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

        getWait().until( ExpectedConditions
                                 .visibilityOf( getAlertInvalidEmail() ) );

        softAssert.assertTrue( getAlertInvalidEmail().isEnabled() );
        softAssert.assertTrue( getAlertInvalidEmail().isDisplayed() );
        softAssert.assertEquals( getAlertInvalidEmail().getText() ,
                                 "Invalid email address." );
        return softAssert;
    }


}
