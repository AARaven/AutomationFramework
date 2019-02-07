package com.automationpractice.Forms.FilterForms;

import Models.Order.Clothes.Clothes;
import Models.Order.Filter;
import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FilterForm {
    
    @Getter( AccessLevel.PRIVATE )
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    private AvailabilityForm getAvailabilityForm() {
        return new AvailabilityForm( getDriver() );
    }
    
    private CategoryForm getCategoryForm() {
        return new CategoryForm( getDriver() );
    }
    
    private ColourForm getColorForm() {
        return new ColourForm( getDriver() );
    }
    
    private CompositionForm getCompositionForm() {
        return new CompositionForm( getDriver() );
    }
    
    private ConditionForm getConditionForm() {
        return new ConditionForm( getDriver() );
    }
    
    private ManufacturerForm getManufacturerForm() {
        return new ManufacturerForm( getDriver() );
    }
    
    private PropertyForm getPropertyForm() {
        return new PropertyForm( getDriver() );
    }
    
    private SizeForm getSizeForm() {
        return new SizeForm( getDriver() );
    }
    
    private StyleForm getStyleForm() {
        return new StyleForm( getDriver() );
    }
    
    public PriceSlideForm getPriceSlideForm() {
        return new PriceSlideForm( getDriver() );
    }
    
    public FilterForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CategoryPage filter( Clothes clothes ) {
        this.getColorForm().filter( clothes.getColour() )
            .getSizeForm() .filter( clothes.getSize() );
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage filter( Filter filter ) {
        this.getAvailabilityForm().filter( filter.getAvailabilities() )
            .getCategoryForm()    .filter( filter.getCategories() )
            .getColorForm()       .filter( filter.getColours() )
            .getCompositionForm() .filter( filter.getCompositions() )
            .getConditionForm()   .filter( filter.getConditions() )
            .getManufacturerForm().filter( filter.getManufacturers() )
            .getPropertyForm()    .filter( filter.getProperties() )
            .getSizeForm()        .filter( filter.getSizes() )
            .getStyleForm()       .filter( filter.getStyles() );
        return new CategoryPage( getDriver() );
    }
}
