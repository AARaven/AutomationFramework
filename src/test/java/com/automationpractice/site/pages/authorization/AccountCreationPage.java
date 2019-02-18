package com.automationpractice.site.pages.authorization;

import com.automationpractice.site.MainPage;
import com.automationpractice.site.objects.registration.AddressForm;
import com.automationpractice.site.objects.registration.PersonalInfoForm;
import com.automationpractice.site.pages.account.AccountPage;
import lombok.AccessLevel;
import lombok.Getter;
import models.user.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.asserts.SoftAssert;

import java.util.List;

@Getter ( AccessLevel.PRIVATE )
public class AccountCreationPage extends MainPage {

    private static final String ERRORS_JSON_PATH =
            "./src/main/resources/errors/errors.json";

    @FindBys ( { @FindBy ( css = "form[id='account-creation_form']" ) ,
                 @FindBy ( css = "button[id='submitAccount'][name='submitAccount']" ) } )
    private WebElement          buttonSubmit;
    @FindBys ( { @FindBy ( css = "div.alert-danger" ) ,
                 @FindBy ( css = "li" ) } )
    private List < WebElement > errorList;

    public AccountCreationPage fillAddressForm( User user ) {
        new AddressForm( getDriver() )
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
        new PersonalInfoForm( getDriver() )
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
        getButtonSubmit().click();
        return new AccountPage( getDriver() );
    }

    public SoftAssert verifyEmptyErrors() {

        SoftAssert softAssert = new SoftAssert();

        String[] expectedErrors = getJsonToStrings( "EmptyDataErrors" , ERRORS_JSON_PATH );
        String[] actualErrors = getErrorList().stream()
                                              .map( WebElement :: getText )
                                              .toArray( String[] ::new );

        for ( int i = 0 ; i < expectedErrors.length ; i++ ) {
            softAssert.assertEquals( expectedErrors[ i ] ,
                                     actualErrors[ i ] );
        }

        return softAssert;
    }

    public SoftAssert verifyIncorrectDataErrors() {

        SoftAssert softAssert = new SoftAssert();

        String[] expectedErrors = getJsonToStrings( "IncorrectDataErrors" , ERRORS_JSON_PATH );
        String[] actualErrors = getErrorList().stream()
                                              .map( WebElement :: getText )
                                              .toArray( String[] ::new );

        for ( int i = 0 ; i < expectedErrors.length ; i++ ) {
            softAssert.assertEquals( expectedErrors[ i ] ,
                                     actualErrors[ i ] );
        }

        return softAssert;
    }

    public SoftAssert verifyLongDataErrors() {

        SoftAssert softAssert = new SoftAssert();

        String[] expectedErrors = getJsonToStrings( "LongDataErrors" , ERRORS_JSON_PATH );
        String[] actualErrors = getErrorList().stream()
                                              .map( WebElement :: getText )
                                              .toArray( String[] ::new );

        for ( int i = 0 ; i < expectedErrors.length ; i++ ) {
            softAssert.assertEquals( expectedErrors[ i ] ,
                                     actualErrors[ i ] );
        }

        return softAssert;
    }

    public AccountCreationPage( WebDriver driver ) {
        super( driver );
    }
}