package com.automationpractice.tests.ElementsTests;

import com.automationpractice.site.pages.authorization.AccountCreationPage;
import com.automationpractice.site.pages.authorization.AuthorizationPage;
import com.automationpractice.tests.BaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class ElementsTest extends BaseTest {
    
    @Step ( "Verifying that elements on creation an account page is enabled." )
    @Test ( description = "A test that implements " +
                          "the verification of elements on the creation an account page.",
            groups = "elements" )
    public void verifyingElementsIsEnabled() {
        
        AuthorizationPage   authentication = new AuthorizationPage( getDriver() );
        AccountCreationPage creation       = new AccountCreationPage( getDriver() );
        
        authentication
                .open();
        
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
}
