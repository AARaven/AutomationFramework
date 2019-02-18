package com.automationpractice.site.objects.registration;

import lombok.AccessLevel;
import lombok.Getter;
import models.user.enums.Genders;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter ( AccessLevel.PRIVATE )
public class PersonalInfoForm extends AbstractWebForm {

    @FindBy ( css = "input[id='id_gender1']" )
    private WebElement radioMale;
    @FindBy ( css = "input[id='id_gender2']" )
    private WebElement radioFemale;
    @FindBy ( css = "input[id='customer_firstname']" )
    private WebElement inputFirstName;
    @FindBy ( css = "input[id='customer_lastname']" )
    private WebElement inputLastName;
    @FindBy ( css = "input[id='email']" )
    private WebElement inputEmail;
    @FindBy ( css = "input[id='passwd']" )
    private WebElement inputPassword;
    @FindBy ( css = "select[id='days']" )
    private WebElement selectDays;
    @FindBy ( css = "select[id='months']" )
    private WebElement selectMonths;
    @FindBy ( css = "select[id='years']" )
    private WebElement selectYears;
    @FindBy ( css = "input[id='newsletter']" )
    private WebElement checkboxNewsLetters;
    @FindBy ( css = "input[id='optin']" )
    private WebElement checkboxSpecialOffers;

    @FindBy ( css = "form[id='account-creation_form']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public PersonalInfoForm clickRadioMale() {
        getRadioMale().click();
        return this;
    }

    public PersonalInfoForm clickRadioFemale() {
        getRadioFemale().click();
        return this;
    }

    public PersonalInfoForm setGender( Genders gender ) {
        switch ( gender ) {
            case DEFAULT:
                break;
            case MALE:
                getRadioMale().click();
                break;
            case FEMALE:
                getRadioFemale().click();
                break;
        }
        return this;
    }

    public PersonalInfoForm sendFirstName( String firstname ) {
        getInputFirstName().clear();
        getInputFirstName().sendKeys( firstname );
        return this;
    }

    public PersonalInfoForm sendLastName( String lastname ) {
        getInputLastName().clear();
        getInputLastName().sendKeys( lastname );
        return this;
    }

    public PersonalInfoForm sendEmail( String email ) {
        getInputEmail().clear();
        getInputEmail().sendKeys( email );
        return this;
    }

    public PersonalInfoForm sendPassword( String password ) {
        getInputPassword().clear();
        getInputPassword().sendKeys( password );
        return this;
    }

    public PersonalInfoForm selectDay( String day ) {
        new Select( getSelectDays() ).selectByValue( day );
        return this;
    }

    public PersonalInfoForm selectMonth( String month ) {
        if ( month.equals( "0" ) ) {
            new Select( getSelectMonths() ).selectByValue( "" );
        } else {
            new Select( getSelectMonths() ).selectByValue( month );
        }
        return this;
    }

    public PersonalInfoForm selectYear( String year ) {
        new Select( getSelectYears() ).selectByValue( year );
        return this;
    }

    public PersonalInfoForm clickNewsLetters() {
        getCheckboxNewsLetters().click();
        return this;
    }

    public PersonalInfoForm setNewsLetters( boolean newsletter ) {
        if ( newsletter ) this.getCheckboxNewsLetters().click();
        return this;
    }

    public PersonalInfoForm clickSpecialOffers() {
        this.getCheckboxSpecialOffers().click();
        return this;
    }

    public PersonalInfoForm setSpecialOffers( boolean specialOffers ) {
        if ( specialOffers ) this.getCheckboxSpecialOffers().click();
        return this;
    }

    public PersonalInfoForm( WebDriver driver ) {
        super( driver );
    }
}
