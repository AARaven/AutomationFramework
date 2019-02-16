package com.automationpractice.site.pages.authorization;

import com.automationpractice.site.MainPage;
import com.automationpractice.site.objects.authorization.ForgotPasswordForm;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

@Getter ( AccessLevel.PRIVATE )
public class PasswordRecoveryPage extends MainPage {
    
    @Setter ( AccessLevel.PRIVATE )
    private ForgotPasswordForm forgotPasswordForm;
    
    @FindBys ( { @FindBy ( css = "ul[class='footer_links']" ),
                 @FindBy ( css = "a[class='btn'][title='Back to Login']" ) } )
    private WebElement buttonBackToLogin;
    
    public PasswordRecoveryPage restorePassword( String email ) {
        return getForgotPasswordForm().sendEmail( email )
                                      .clickRetrievePassword();
    }
    
    public AuthorizationPage clickBackToLogin() {
        getButtonBackToLogin().click();
        return new AuthorizationPage( getDriver() );
    }
    
    public PasswordRecoveryPage( WebDriver driver ) {
        super( driver );
        setForgotPasswordForm( new ForgotPasswordForm( driver ) );
    }
}
