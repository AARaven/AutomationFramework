package com.automationpractice.tests.AccountTests;

import com.automationpractice.data.UserData;
import com.automationpractice.site.pages.account.AccountPage;
import com.automationpractice.site.pages.account.AddressPage;
import com.automationpractice.site.pages.account.PersonalInfoPage;
import com.automationpractice.tests.BaseTest;
import io.qameta.allure.Step;
import models.user.User;
import org.testng.annotations.Test;

public class PersonalInfoTest extends BaseTest {
    
    @Step ( "Navigate to personal info page from account page and verify personal info." )
    @Test ( description = "Test that implement verifying account personal info.",
            dataProvider = "getUser", dataProviderClass = UserData.class,
            groups = "positive" )
    public void testVerifyingPersonalInfo( User user ) {
        AccountPage      account      = new AccountPage( getDriver() );
        PersonalInfoPage personalInfo = new PersonalInfoPage( getDriver() );

//        account.open();
//
        account
                .clickPersonalInfo();

//      personalInfo
//              .verifyPersonalInfo( user )
//              .assertAll();
        
        account
                .getAccountRowForm()
                .clickSignOut();
    }
    
    @Step ( "Navigate to address page from account page and verify address." )
    @Test ( description = "Test that implement verifying account address.",
            dataProvider = "getUsers", dataProviderClass = UserData.class,
            groups = "positive" )
    public void testVerifyingAddress( User user ) {
        
        AccountPage account = new AccountPage( getDriver() );
        
        account
                .clickAddresses()
                .clickUpdate();
//              .verifyUserAddress( user )
//              .assertAll();
        account
                .getAccountRowForm()
                .clickSignOut();
    }
    
    @Step ( "Navigate to account page and rewrite personal info." )
    @Test ( description = "Test that implement rewriting personal info in current account.",
            dataProvider = "getUsersPair", dataProviderClass = UserData.class,
            groups = "positive" )
    public void testRewritingPersonalInfo( User user, User otherUser ) {
        
        AccountPage      account      = new AccountPage( getDriver() );
        PersonalInfoPage personalInfo = new PersonalInfoPage( getDriver() );
        
        account
                .clickPersonalInfo();

//      personalInfo
//              .rewriteAll( otherUser )
//              .clickSave();
        
        account
                .getAccountRowForm()
                .clickSignOut();
    }
    
    @Step ( "Navigate to address page from account page and rewrite address." )
    @Test ( description = "Test that implement rewriting address in current account.",
            dataProvider = "getUsersPair", dataProviderClass = UserData.class,
            groups = "positive" )
    public void testRewritingAddress( User user, User otherUser ) {
        
        AccountPage account = new AccountPage( getDriver() );
        AddressPage address = new AddressPage( getDriver() );
        
        account
                .clickAddresses();
        
        address
                .clickUpdate();
//              .rewriteAll( otherUser )
//              .clickSubmitAddress();
        account
                .getAccountRowForm()
                .clickSignOut();
    }
    
}
