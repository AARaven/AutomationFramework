package com.automationpractice.Forms.FilterForms;

import Models.Order.Enums.Availabilities;
import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class AvailabilityForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id='layered_quantity_1']" ) private WebElement checkboxInStock;
    
    AvailabilityForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CategoryPage clickInStock() {
        this.getCheckboxInStock().click();
        return new CategoryPage( getDriver() );
    }
    
    public FilterForm filter( Availabilities availabilities ) {
        switch ( availabilities ) {
            case DEFAULT:
                break;
            case IN_STOCK:
                this.getCheckboxInStock().click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}
