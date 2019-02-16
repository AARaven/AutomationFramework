package com.automationpractice.tests.AccountTests;

import com.automationpractice.data.UserData;
import com.automationpractice.site.pages.account.AccountPage;
import com.automationpractice.site.pages.authorization.AuthorizationPage;
import com.automationpractice.tests.BaseTest;
import io.qameta.allure.Step;
import models.user.User;
import org.testng.annotations.Test;

public class AuthorizationTest extends BaseTest {
    
    @Step ( "Navigate to authentication page and authorize an account." )
    @Test ( description = "Test that implement authorization an account.",
            dataProvider = "User", dataProviderClass = UserData.class,
            groups = "positive" )
    public void testAuthorization( User user ) {
        
        AuthorizationPage authentication = new AuthorizationPage( getDriver() );
        AccountPage       account        = new AccountPage( getDriver() );
        
        //Go to authentication page :
        authentication
                .open();
        
        //Type login and password into text input areas and click 'Sign In' :
        authentication
                .getLoginForm()
                .sendEmail( user.getEmail() )
                .sendPassword( user.getPassword() )
                .clickSignIn();
        
        //Verifying :
        account
                .getAccountRowForm()
                .verifyUser( user )
                .assertAll();
    }
    
    @Step ( "Navigate to authentication page and authorize all users accounts." )
    @Test ( description = "Test that implement authorization an accounts.",
            dataProvider = "getUsers", dataProviderClass = UserData.class,
            groups = "positive" )
    public void testUsersAuthorization( User user ) {
        
        AuthorizationPage authentication = new AuthorizationPage( getDriver() );
        AccountPage       account        = new AccountPage( getDriver() );
        
        authentication
                .open();
        
        authentication
                .getLoginForm()
                .sendEmail( user.getEmail() )
                .sendPassword( user.getPassword() )
                .clickSignIn();
        
        account
                .getAccountRowForm()
                .verifyUser( user )
                .assertAll();
        
        account
                .getAccountRowForm()
                .clickSignOut();
    }
}
