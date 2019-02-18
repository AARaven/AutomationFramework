package com.automationpractice.site.pages.authorization;

import com.automationpractice.site.MainPage;
import com.automationpractice.site.objects.authorization.CreateAccountForm;
import com.automationpractice.site.objects.authorization.LoginForm;
import com.automationpractice.site.pages.account.AccountPage;
import models.user.User;
import org.openqa.selenium.WebDriver;

public class AuthorizationPage extends MainPage {

    public CreateAccountForm getCreateAccountForm() {
        return new CreateAccountForm( getDriver() );
    }

    public LoginForm getLoginForm() {
        return new LoginForm( getDriver() );
    }

    public AccountCreationPage createUser( User user ) {
        return getCreateAccountForm().sendEmail( user.getEmail() )
                                     .clickSubmit();
    }

    public AccountPage authorizeUser( User user ) {
        return getLoginForm().sendEmail( user.getEmail() )
                             .sendPassword( user.getPassword() )
                             .clickSignIn();
    }

    public PasswordRecoveryPage restorePassword() {
        return getLoginForm().clickRecoverPassword();
    }

    public AuthorizationPage( WebDriver driver ) {
        super( driver );
    }
}
