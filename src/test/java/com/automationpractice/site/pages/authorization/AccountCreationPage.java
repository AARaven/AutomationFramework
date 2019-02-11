package com.automationpractice.site.pages.authorization;

import com.automationpractice.site.MainPage;
import com.automationpractice.site.objects.registration.AccountCreationForm;
import com.automationpractice.site.pages.account.AccountPage;
import lombok.AccessLevel;
import lombok.Getter;
import models.user.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

@Getter ( AccessLevel.PRIVATE )
public class AccountCreationPage extends MainPage {
    
    private static final String ERRORS_JSON_PATH = "./src/main/resources/errors/errors.json";
    
    @FindBy ( css = ".alert > ol > li" ) private List < WebElement > errorList;
    
    public SoftAssert verifyEmptyErrors() {
        SoftAssert softAssert     = new SoftAssert();
        String[]   expectedErrors = getJsonAsString( "EmptyDataErrors", ERRORS_JSON_PATH );
        String[] actualErrors = getErrorList().stream()
                                              .map( WebElement :: getText )
                                              .toArray( String[] ::new );
        
        for ( int i = 0 ; i < expectedErrors.length ; i++ ) {
            softAssert.assertEquals( expectedErrors[ i ],
                                     actualErrors[ i ] );
        }
        
        return softAssert;
    }
    
    public SoftAssert verifyIncorrectDataErrors() {
        SoftAssert softAssert     = new SoftAssert();
        String[]   expectedErrors = getJsonAsString( "IncorrectDataErrors", ERRORS_JSON_PATH );
        String[] actualErrors = getErrorList().stream()
                                              .map( WebElement :: getText )
                                              .toArray( String[] ::new );
        
        for ( int i = 0 ; i < expectedErrors.length ; i++ ) {
            softAssert.assertEquals( expectedErrors[ i ],
                                     actualErrors[ i ] );
        }
        
        return softAssert;
    }
    
    public SoftAssert verifyLongDataErrors() {
        SoftAssert softAssert     = new SoftAssert();
        String[]   expectedErrors = getJsonAsString( "LongDataErrors", ERRORS_JSON_PATH );
        String[] actualErrors = getErrorList().stream()
                                              .map( WebElement :: getText )
                                              .toArray( String[] ::new );
        
        for ( int i = 0 ; i < expectedErrors.length ; i++ ) {
            softAssert.assertEquals( expectedErrors[ i ],
                                     actualErrors[ i ] );
        }
        
        return softAssert;
    }
    
    public AccountCreationPage fillAddressForm( User user ) {
        new AccountCreationForm( getDriver() )
                .getAddressForm()
                .sendFirstName( user.getFirstName() )
                .sendLastName( user.getLastName() )
                .sendCompany( user.getAddress().getCompany() )
                .sendAddressOne( user.getAddress().getAddress() )
                .sendAddressTwo( user.getAddress().getAddressSecondLine() )
                .sendCity( user.getAddress().getCity() )
                .selectState( Integer.toString( user.getAddress().getState().getNumber() ) )
                .sendPostCode( user.getAddress().getZipCode() )
                .selectCountry( user.getAddress().getCountry() )
                .sendOther( user.getAdditionalInfo() )
                .sendPhone( user.getHomePhone() )
                .sendPhoneMobile( user.getMobilePhone() )
                .sendAlias( user.getAlias() );
        return this;
    }
    
    public AccountCreationPage fillPersonalInfoForm( User user ) {
        new AccountCreationForm( getDriver() )
                .getPersonalInfoForm()
                .setGender( user.getGender() )
                .sendFirstName( user.getFirstName() )
                .sendLastName( user.getLastName() )
                .sendEmail( user.getEmail() )
                .sendPassword( user.getPassword() )
                .selectDay( user.getDay() )
                .selectMonth( Integer.toString( user.getMonths().getNumber() ) )
                .selectYear( user.getYear() )
                .setNewsLetters( user.isNewsLetter() )
                .setSpecialOffers( user.isSpecialOffers() );
        return this;
    }
    
    public AccountPage clickSubmit() {
        return new AccountCreationForm( getDriver() ).clickSubmit();
    }
    
    public AccountCreationPage( WebDriver driver ) {
        super( driver );
    }
}