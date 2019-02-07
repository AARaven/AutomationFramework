package com.automationpractice.Forms.RegistrationForms;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Getter( AccessLevel.PRIVATE )
public class PersonalInfoForm {
    
    @FindBy( css = "input[id='id_gender1']" )         private   WebElement radioMale;
    @FindBy( css = "input[id='id_gender2']" )         private   WebElement radioFemale;
    @FindBy( css = "input[id='customer_firstname']" ) private   WebElement inputFirstName;
    @FindBy( css = "input[id='customer_lastname']" )  private   WebElement inputLastName;
    @FindBy( css = "input[id='email']" )              private   WebElement inputEmail;
    @FindBy( css = "input[id='passwd']" )             private   WebElement inputPassword;
    @FindBy( css = "select[id='days']" )              private   WebElement selectDays;
    @FindBy( css = "select[id='months']" )            private   WebElement selectMonths;
    @FindBy( css = "select[id='years']" )             private   WebElement selectYears;
    @FindBy( css = "input[id='newsletter']" )         private   WebElement checkboxNewsLetters;
    @FindBy( css = "input[id='optin']" )              private   WebElement checkboxSpecialOffers;
    
    public PersonalInfoForm clickRadioMale() {
        this.getRadioMale().click();
        return this;
    }
    
    public PersonalInfoForm clickRadioFemale() {
        this.getRadioFemale().click();
        return this;
    }
    
    public PersonalInfoForm setGender( String gender ) {
        if ( gender.equals( "Male" ) ) this.getRadioMale().click();
        this.getRadioFemale().click();
        return this;
    }
    
    public PersonalInfoForm sendFirstName( String firstname ) {
        this.getInputFirstName().clear();
        this.getInputFirstName().sendKeys( firstname );
        return this;
    }
    
    public PersonalInfoForm sendLastName( String lastname ) {
        this.getInputLastName().clear();
        this.getInputLastName().sendKeys( lastname );
        return this;
    }
    
    public PersonalInfoForm sendEmail( String email ) {
        this.getInputEmail().clear();
        this.getInputEmail().sendKeys( email );
        return this;
    }
    
    public PersonalInfoForm sendPassword( String password ) {
        this.getInputPassword().clear();
        this.getInputPassword().sendKeys( password );
        return this;
    }
    
    public PersonalInfoForm selectDay( String day ) {
        new Select( this.getSelectDays() ).selectByValue( day );
        return this;
    }
    
    public PersonalInfoForm selectMonth( String month ) {
        if ( month.equals( "0" ) ) {
            new Select( this.getSelectMonths() ).selectByValue( "" );
        } else {
            new Select( this.getSelectMonths() ).selectByValue( month );
        }
        return this;
    }
    
    public PersonalInfoForm selectYear( String year ) {
        new Select( this.getSelectYears() ).selectByValue( year );
        return this;
    }
    
    public PersonalInfoForm clickNewsLetters() {
        this.getCheckboxNewsLetters().click();
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
        PageFactory.initElements( driver, this );
    }
}
