package com.automationpractice.Forms.FilterForms;

import Models.Order.Clothes.Enums.ForOrdering.Properties;
import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class PropertyForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id='layered_id_feature_17']" ) private WebElement checkboxShortSleeve;
    @FindBy( css = "input[id='layered_id_feature_18']" ) private WebElement checkboxColorfulDress;
    @FindBy( css = "input[id='layered_id_feature_19']" ) private WebElement checkboxShortDress;
    @FindBy( css = "input[id='layered_id_feature_20']" ) private WebElement checkboxMidiDress;
    @FindBy( css = "input[id='layered_id_feature_21']" ) private WebElement checkboxMaxiDress;
    
    PropertyForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CategoryPage clickCheckboxShortSleeve() {
        this.getCheckboxShortSleeve().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxColorfulDress() {
        this.getCheckboxColorfulDress().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxShortDress() {
        this.getCheckboxShortDress().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxMidiDress() {
        this.getCheckboxMidiDress().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxMaxiDress() {
        this.getCheckboxMaxiDress().click();
        return new CategoryPage( getDriver() );
    }
    
    public FilterForm filter( Properties properties ) {
        switch ( properties ) {
            case DEFAULT:
                break;
            case COLORFUL:
                this.getCheckboxColorfulDress().click();
                break;
            case MAXI:
                this.getCheckboxMaxiDress().click();
                break;
            case MIDI:
                this.getCheckboxMidiDress().click();
                break;
            case SHORT:
                this.getCheckboxShortSleeve().click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}
