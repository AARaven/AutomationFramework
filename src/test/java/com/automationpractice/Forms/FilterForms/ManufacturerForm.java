package com.automationpractice.Forms.FilterForms;

import Models.Order.Clothes.Enums.ForUserChoice.Manufacturers;
import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter( AccessLevel.PRIVATE )
public class ManufacturerForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id='layered_manufacturer_1']" ) private WebElement checkboxFashion;
    
    ManufacturerForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CategoryPage clickCheckboxFashion() {
        this.getCheckboxFashion().click();
        return new CategoryPage( getDriver() );
    }
    
    public FilterForm filter( Manufacturers manufacturers ) {
        switch ( manufacturers ) {
            case DEFAULT:
                break;
            case FASHION:
                getCheckboxFashion().click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}
