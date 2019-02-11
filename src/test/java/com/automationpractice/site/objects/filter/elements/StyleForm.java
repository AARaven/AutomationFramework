package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import com.automationpractice.site.pages.ordering.ProductsPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import models.order.enums.Styles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class StyleForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "input[id='layered_id_feature_11']" ) private WebElement checkboxCasual;
    @FindBy ( css = "input[id='layered_id_feature_13']" ) private WebElement checkboxGirly;
    @FindBy ( css = "input[id='layered_id_feature_16']" ) private WebElement checkboxDressy;
    
    public StyleForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public ProductsPage clickCheckboxCasual() {
        getCheckboxCasual().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxGirly() {
        getCheckboxGirly().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxDressy() {
        getCheckboxDressy().click();
        return new ProductsPage( getDriver() );
    }
    
    public FilterForm filter( Styles styles ) {
        switch ( styles ) {
            case DEFAULT:
                break;
            case CASUAL:
                getCheckboxCasual()
                        .click();
                break;
            case DRESSY:
                getCheckboxDressy()
                        .click();
                break;
            case GIRLY:
                getCheckboxGirly()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}