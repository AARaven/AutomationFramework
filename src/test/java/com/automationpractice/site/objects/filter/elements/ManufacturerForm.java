package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import com.automationpractice.site.pages.ordering.ProductsPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import models.order.enums.Manufacturers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter ( AccessLevel.PRIVATE )
public class ManufacturerForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "input[id='layered_manufacturer_1']" ) private WebElement checkboxFashion;
    
    public ManufacturerForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public ProductsPage clickCheckboxFashion() {
        getCheckboxFashion().click();
        return new ProductsPage( getDriver() );
    }
    
    public FilterForm filter( Manufacturers manufacturers ) {
        switch ( manufacturers ) {
            case DEFAULT:
                break;
            case FASHION:
                getCheckboxFashion()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}
