package com.automationpractice.Pages.AuthorizationPages;

import com.automationpractice.Forms.LoginForms.RetrievePasswordForm;
import com.automationpractice.Pages.HomePage;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter( AccessLevel.PRIVATE )
public class PasswordRecoverPage extends HomePage {
    
    @FindBy( css = "a[title='Back to LoginForm']" )
    private WebElement buttonBackToLogin;
    
    public RetrievePasswordForm getRetrievePasswordForm() {
        return new RetrievePasswordForm( getDriver() );
    }
    
    public AuthenticationPage clickBack() {
        this.getButtonBackToLogin().click();
        return new AuthenticationPage( getDriver() );
    }
    
    public PasswordRecoverPage( WebDriver driver ) {
        super( driver );
    }
}
