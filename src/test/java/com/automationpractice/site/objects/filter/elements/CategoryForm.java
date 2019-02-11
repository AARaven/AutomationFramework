package com.automationpractice.site.objects.filter.elements;

import models.order.enums.Categories;
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
public class CategoryForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "input[id='layered_category_9']" )  private WebElement checkboxCasualDresses;
    @FindBy ( css = "input[id='layered_category_10']" ) private WebElement checkboxEveningDresses;
    @FindBy ( css = "input[id='layered_category_11']" ) private WebElement checkboxSummerDresses;
    
    public CategoryForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public ProductsPage clickCheckboxCasualDresses() {
        getCheckboxCasualDresses().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxEveningDresses() {
        getCheckboxEveningDresses().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickCheckboxSummerDresses() {
        getCheckboxSummerDresses().click();
        return new ProductsPage( getDriver() );
    }
    
    public FilterForm filter( Categories categories ) {
        switch ( categories ) {
            case DEFAULT:
                break;
            case CASUAL:
                this.getCheckboxCasualDresses().click();
                break;
            case EVENING:
                this.getCheckboxEveningDresses().click();
                break;
            case SUMMER:
                this.getCheckboxSummerDresses().click();
                break;
        }
        return new FilterForm( getDriver() );
    }
}
