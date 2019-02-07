package com.automationpractice.Tests.Positive;

import Models.User.User;
import com.automationpractice.Data.UserData;
import com.automationpractice.Pages.AuthorizationPages.AuthenticationPage;
import com.automationpractice.Pages.AuthorizationPages.CreateAccountPage;
import com.automationpractice.Pages.HomePage;
import com.automationpractice.Tests.BaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class PageElementsTest extends BaseTest {
    
    @Test( description = "A test that implements " +
                         "the verification of elements on the creation an account page." )
    @Step( "Verifying that elements on creation an account page is enabled." )
    public void verifyingElementsIsEnabled() {
        
        AuthenticationPage authentication = new AuthenticationPage( getDriver() );
        CreateAccountPage  creation       = new CreateAccountPage( getDriver() );
        
        authentication
                .openPage();
        
        authentication
                .getCreateAccountForm()
                .sendEmail( "string@string.domain" )
                .clickSubmit();

//        creation
//                .verifyInputElementsOnPageIsEnabled()
//                .assertAll();
//
//        creation
//                .verifySelectElementsOnPageIsEnabled()
//                .assertAll();
//
//        creation
//                .verifyTextAreaElementsOnPageIsEnabled()
//                .assertAll();
    }

    
    @Test( dataProvider = "ValidUser", dataProviderClass = UserData.class )
    public void testTest( User user ) {
        HomePage home = new HomePage( getDriver() );
        
        home
                .openPage();
    
        home.getContentForm()
            .clickButtonWomen().getFilterForm();
    }
}
