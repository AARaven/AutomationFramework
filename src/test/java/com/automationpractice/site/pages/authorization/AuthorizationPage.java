package com.automationpractice.site.pages.authorization;

import com.automationpractice.site.MainPage;
import com.automationpractice.site.objects.authorization.AccountCreationForm;
import com.automationpractice.site.objects.authorization.AuthorizationForm;
import com.automationpractice.site.pages.account.AccountPage;
import models.user.User;
import org.openqa.selenium.WebDriver;

public class AuthorizationPage extends MainPage {
    
    public AccountCreationForm getCreateAccountForm() {
        return new AccountCreationForm( getDriver() );
    }
    
    public AuthorizationForm getLoginForm() {
        return new AuthorizationForm( getDriver() );
    }
    
    public AccountPage authorizeUser( User user ) {
        return getLoginForm().sendEmail( user.getEmail() )
                             .sendPassword( user.getPassword() )
                             .clickSignIn();
    }
    
    public AuthorizationPage( WebDriver driver ) {
        super( driver );
    }
}
