package com.automationpractice.site.objects.authorization;

import com.automationpractice.site.pages.authorization.PasswordRecoveryPage;
import lombok.AccessLevel;
import lombok.Getter;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

@Getter ( AccessLevel.PRIVATE )
public class ForgotPasswordForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "form[id='form_forgotpassword']" ) ,
                 @FindBy ( css = "input[id='email']" ) } )
    private WebElement inputEmail;

    @FindBys ( { @FindBy ( css = "form[id='form_forgotpassword']" ) ,
                 @FindBy ( css = "button[type='submit']" ) } )
    private WebElement buttonRetrievePassword;

    @FindBy ( css = "form[id='form_forgotpassword']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public ForgotPasswordForm( WebDriver driver ) {
        super( driver );
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
