package com.automationpractice.site.objects.filter.elements;

import models.order.enums.Availabilities;
import com.automationpractice.site.objects.filter.FilterForm;
import com.automationpractice.site.pages.ordering.ProductsPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class AvailabilityForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "input[id='layered_quantity_1']" ) private WebElement checkboxInStock;
    
    public AvailabilityForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public ProductsPage clickInStock() {
        getCheckboxInStock().click();
        return new ProductsPage( getDriver() );
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
