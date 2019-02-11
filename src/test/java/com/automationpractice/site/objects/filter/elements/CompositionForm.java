package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.objects.filter.FilterForm;
import com.automationpractice.site.pages.ordering.ProductsPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import models.order.enums.Compositions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class CompositionForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "input[id='layered_id_feature_1']" ) private WebElement checkboxPolyester;
    @FindBy ( css = "input[id='layered_id_feature_3']" ) private WebElement checkboxViscose;
    @FindBy ( css = "input[id='layered_id_feature_5']" ) private WebElement checkboxCotton;
    
    public CompositionForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public ProductsPage clickCheckboxPolyester() {
        getCheckboxPolyester().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxViscose() {
        getCheckboxViscose().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxCotton() {
        getCheckboxCotton().click();
        return new ProductsPage( getDriver() );
    }
    
    public FilterForm filter( Compositions compositions ) {
        switch ( compositions ) {
            case DEFAULT:
                break;
            case COTTON:
                getCheckboxCotton()
                        .click();
                break;
            case POLYESTER:
                getCheckboxPolyester()
                        .click();
                break;
            case VISCOSE:
                getCheckboxViscose()
                        .click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}