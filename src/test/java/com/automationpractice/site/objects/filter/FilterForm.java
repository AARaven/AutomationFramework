package com.automationpractice.site.objects.filter;

import com.automationpractice.site.objects.filter.elements.*;
import com.automationpractice.site.pages.ordering.ProductsPage;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.Clothes;
import models.order.Filter;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterForm extends AbstractWebForm {

    @FindBy ( css = "form[id='layered_form']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public ProductsPage filter( Clothes clothes ) {
        new ColourForm( getDriver() )
                .filter( clothes.getColour() );
        new SizeForm( getDriver() )
                .filter( clothes.getSize() );
        return new ProductsPage( getDriver() );
    }

    public ProductsPage filter( Filter filter ) {
        new AvailabilityForm( getDriver() )
                .filter( filter.getAvailabilities() );
        new CategoryForm( getDriver() )
                .filter( filter.getCategories() );
        new ColourForm( getDriver() )
                .filter( filter.getColours() );
        new CompositionForm( getDriver() )
                .filter( filter.getCompositions() );
        new ConditionForm( getDriver() )
                .filter( filter.getConditions() );
        new ManufacturerForm( getDriver() )
                .filter( filter.getManufacturers() );
        new PropertyForm( getDriver() )
                .filter( filter.getProperties() );
        new SizeForm( getDriver() )
                .filter( filter.getSizes() );
        new StyleForm( getDriver() )
                .filter( filter.getStyles() );
        return new ProductsPage( getDriver() );
    }

    public FilterForm( WebDriver driver ) {
        super( driver );
    }
}
