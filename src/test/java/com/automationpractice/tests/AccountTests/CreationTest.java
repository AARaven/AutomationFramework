package com.automationpractice.tests.AccountTests;

import com.automationpractice.data.UserData;
import com.automationpractice.site.pages.account.AccountPage;
import com.automationpractice.site.pages.authorization.AccountCreationPage;
import com.automationpractice.site.pages.authorization.AuthorizationPage;
import com.automationpractice.tests.BaseTest;
import io.qameta.allure.Step;
import models.user.User;
import org.testng.annotations.Test;

public class CreationTest extends BaseTest {
    
    @Step ( "Navigate to authentication page and create a new account." )
    @Test ( description = "Test that implement creation an account.",
            dataProvider = "Users", dataProviderClass = UserData.class,
            groups = "positive" )
    public void testAccountCreation( User user ) {
        
        AuthorizationPage   authentication = new AuthorizationPage( getDriver() );
        AccountCreationPage creation       = new AccountCreationPage( getDriver() );
        AccountPage         account        = new AccountPage( getDriver() );
        
        //Go to authentication page :
        authentication
                .openPage();
        
        //Type user email and password to text input areas and click 'CreateAccount' :
        authentication
                .getCreateAccountForm()
                .sendEmail( user.getEmail() )
                .clickSubmit();
        
        //Fill account data and click 'CreateAccount' :
        creation
                .fillPersonalInfoForm( user )
                .fillAddressForm( user )
                .clickSubmit();
        
        //Verifying that account created :
        account
                .getAccountRowForm()
                .verifyUser( user )
                .assertAll();
        
        //Sign out :
        account
                .getAccountRowForm()
                .clickSignOut();
    }
    
    @Test ( dataProvider = "EmptyUser", dataProviderClass = UserData.class,
            groups = "negative" )
    public void testEmptyUserDataCreation( User user ) {
        
        AuthorizationPage   authentication = new AuthorizationPage( getDriver() );
        AccountCreationPage creation       = new AccountCreationPage( getDriver() );
        
        authentication.openPage();
        
        authentication
                .getCreateAccountForm()
                .sendEmail( user.getEmail() )
                .clickSubmit();
        
        creation
                .fillPersonalInfoForm( user )
                .fillAddressForm( user )
                .clickSubmit();
        
        creation.verifyEmptyErrors()
                .assertAll();
    }
    
    @Test ( dataProvider = "IncorrectUser", dataProviderClass = UserData.class,
            groups = "negative" )
    public void testInvalidUserDataCreation( User user ) {
        
        AuthorizationPage   authentication = new AuthorizationPage( getDriver() );
        AccountCreationPage creation       = new AccountCreationPage( getDriver() );
        
        authentication.openPage();
        
        authentication
                .getCreateAccountForm()
                .sendEmail( user.getEmail() )
                .clickSubmit();
    
        creation
                .fillPersonalInfoForm( user )
                .fillAddressForm( user )
                .clickSubmit();
    
        creation
                .verifyIncorrectDataErrors()
                .assertAll();
    }
    
    @Test ( dataProvider = "LongDataUser", dataProviderClass = UserData.class,
            groups = "negative" )
    public void testLongUserDataCreation( User user ) {
    
        AuthorizationPage   authentication = new AuthorizationPage( getDriver() );
        AccountCreationPage creation       = new AccountCreationPage( getDriver() );
    
        authentication.openPage();
    
        authentication
                .getCreateAccountForm()
                .sendEmail( user.getEmail() )
                .clickSubmit();
    
        creation
                .fillPersonalInfoForm( user )
                .fillAddressForm( user )
                .clickSubmit();
    
       creation
               .verifyLongDataErrors()
               .assertAll();
    }
}
