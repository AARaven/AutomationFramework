package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import com.automationpractice.site.pages.ordering.ProductsPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import models.order.enums.Sizes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class SizeForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "input[id='layered_id_attribute_group_1']" ) private WebElement checkboxSmall;
    @FindBy ( css = "input[id='layered_id_attribute_group_2']" ) private WebElement checkboxMedium;
    @FindBy ( css = "input[id='layered_id_attribute_group_3']" ) private WebElement checkboxLarge;
    
    public SizeForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public ProductsPage clickCheckboxSmall() {
        getCheckboxSmall().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxMedium() {
        getCheckboxMedium().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxLarge() {
        getCheckboxLarge().click();
        return new ProductsPage( getDriver() );
    }
    
    public FilterForm filter( Sizes sizes ) {
        switch ( sizes ) {
            case DEFAULT:
                break;
            case S:
                getCheckboxSmall()
                        .click();
                break;
            case M:
                getCheckboxMedium()
                        .click();
                break;
            case L:
                getCheckboxLarge()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}
