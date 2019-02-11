package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import com.automationpractice.site.pages.ordering.ProductsPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import models.order.enums.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class PropertyForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "input[id='layered_id_feature_17']" ) private WebElement checkboxShortSleeve;
    @FindBy ( css = "input[id='layered_id_feature_18']" ) private WebElement checkboxColorfulDress;
    @FindBy ( css = "input[id='layered_id_feature_19']" ) private WebElement checkboxShortDress;
    @FindBy ( css = "input[id='layered_id_feature_20']" ) private WebElement checkboxMidiDress;
    @FindBy ( css = "input[id='layered_id_feature_21']" ) private WebElement checkboxMaxiDress;
    
    public PropertyForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public ProductsPage clickCheckboxShortSleeve() {
        getCheckboxShortSleeve().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxColorfulDress() {
        getCheckboxColorfulDress().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxShortDress() {
        getCheckboxShortDress().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxMidiDress() {
        getCheckboxMidiDress().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxMaxiDress() {
        getCheckboxMaxiDress().click();
        return new ProductsPage( getDriver() );
    }
    
    public FilterForm filter( Properties properties ) {
        switch ( properties ) {
            case DEFAULT:
                break;
            case COLORFUL:
                getCheckboxColorfulDress()
                        .click();
                break;
            case MAXI:
                getCheckboxMaxiDress()
                        .click();
                break;
            case MIDI:
                getCheckboxMidiDress()
                        .click();
                break;
            case SHORT:
                getCheckboxShortSleeve()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}