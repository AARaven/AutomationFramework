package com.automationpractice.site.pages.authorization;

import com.automationpractice.site.MainPage;
import com.automationpractice.site.objects.authorization.CreateAccountForm;
import com.automationpractice.site.objects.authorization.LoginForm;
import com.automationpractice.site.pages.account.AccountPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import models.user.User;
import org.openqa.selenium.WebDriver;

@Getter ( AccessLevel.PUBLIC )
@Setter ( AccessLevel.PRIVATE )
public class AuthorizationPage extends MainPage {
    
    private CreateAccountForm createAccountForm;
    private LoginForm         loginForm;
    
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
        setCreateAccountForm( new CreateAccountForm( driver ) );
        setLoginForm( new LoginForm( driver ) );
    }
}
