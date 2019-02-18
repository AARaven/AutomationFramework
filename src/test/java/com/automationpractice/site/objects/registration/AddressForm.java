package com.automationpractice.site.objects.registration;

import lombok.AccessLevel;
import lombok.Getter;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter ( AccessLevel.PRIVATE )
public class AddressForm extends AbstractWebForm {

    @FindBy ( css = "input[id='firstname']" )
    private WebElement inputFirstName;
    @FindBy ( css = "input[id='lastname']" )
    private WebElement inputLastName;
    @FindBy ( css = "input[id='company']" )
    private WebElement inputCompany;
    @FindBy ( css = "input[id='address1']" )
    private WebElement inputAddressOne;
    @FindBy ( css = "input[id='address2']" )
    private WebElement inputAddressTwo;
    @FindBy ( css = "input[id='city']" )
    private WebElement inputCity;
    @FindBy ( css = "select[id='id_state']" )
    private WebElement selectState;
    @FindBy ( css = "input[id='postcode']" )
    private WebElement inputPostCode;
    @FindBy ( css = "select[id='id_country']" )
    private WebElement selectCountry;
    @FindBy ( css = "textarea[id='other']" )
    private WebElement inputOther;
    @FindBy ( css = "input[id='phone']" )
    private WebElement inputPhone;
    @FindBy ( css = "input[id='phone_mobile']" )
    private WebElement inputPhoneMobile;
    @FindBy ( css = "input[id='alias']" )
    private WebElement inputAlias;

    @FindBy ( css = "form[id='account-creation_form']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public AddressForm sendFirstName( String firstname ) {
        getInputFirstName().clear();
        getInputFirstName().sendKeys( firstname );
        return this;
    }

    public AddressForm sendLastName( String lastname ) {
        getInputLastName().clear();
        getInputLastName().sendKeys( lastname );
        return this;
    }

    public AddressForm sendCompany( String company ) {
        getInputCompany().clear();
        getInputCompany().sendKeys( company );
        return this;
    }

    public AddressForm sendAddressOne( String address1 ) {
        getInputAddressOne().clear();
        getInputAddressOne().sendKeys( address1 );
        return this;
    }

    public AddressForm sendAddressTwo( String address2 ) {
        getInputAddressTwo().clear();
        getInputAddressTwo().sendKeys( address2 );
        return this;
    }

    public AddressForm sendCity( String city ) {
        getInputCity().clear();
        getInputCity().sendKeys( city );
        return this;
    }

    public AddressForm selectState( String state ) {
        if ( state.equals( "0" ) ) {
            new Select( getSelectState() ).selectByValue( "" );
        } else {
            new Select( getSelectState() ).selectByValue( state );
        }
        return this;
    }

    public AddressForm sendPostCode( String postcode ) {
        getInputPostCode().clear();
        getInputPostCode().sendKeys( postcode );
        return this;
    }

    public AddressForm selectCountry( String country ) {
        new Select( getSelectCountry() ).selectByVisibleText( country );
        return this;
    }

    public AddressForm sendOther( String additionalInfo ) {
        getInputOther().clear();
        getInputOther().sendKeys( additionalInfo );
        return this;
    }

    public AddressForm sendPhone( String phone ) {
        getInputPhone().clear();
        getInputPhone().sendKeys( phone );
        return this;
    }

    public AddressForm sendPhoneMobile( String phoneMobile ) {
        getInputPhoneMobile().clear();
        getInputPhoneMobile().sendKeys( phoneMobile );
        return this;
    }

    public AddressForm sendAlias( String alias ) {
        getInputAlias().clear();
        getInputAlias().sendKeys( alias );
        return this;
    }

    public AddressForm( WebDriver driver ) {
        super( driver );
    }
}
