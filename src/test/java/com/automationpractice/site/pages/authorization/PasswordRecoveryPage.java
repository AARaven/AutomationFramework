package com.automationpractice.site.pages.authorization;

import com.automationpractice.site.MainPage;
import com.automationpractice.site.objects.authorization.PasswordRetrieveForm;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter ( AccessLevel.PRIVATE )
public class PasswordRecoveryPage extends MainPage {
    
    @FindBy ( css = "a[title='Back to AuthorizationForm']" )
    private WebElement buttonBackToLogin;
    
    public PasswordRetrieveForm getRetrievePasswordForm() {
        return new PasswordRetrieveForm( getDriver() );
    }
    
    public AuthorizationPage clickBack() {
        getButtonBackToLogin().click();
        return new AuthorizationPage( getDriver() );
    }
    
    public PasswordRecoveryPage( WebDriver driver ) {
        super( driver );
    }
}
