package com.automationpractice.Forms.FilterForms;

import Models.Order.Enums.Categories;
import com.automationpractice.Pages.SecondaryPages.CategoryPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class CategoryForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id='layered_category_9']" )  private  WebElement checkboxCasualDresses;
    @FindBy( css = "input[id='layered_category_10']" ) private  WebElement checkboxEveningDresses;
    @FindBy( css = "input[id='layered_category_11']" ) private  WebElement checkboxSummerDresses;
    
    CategoryForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public CategoryPage clickCheckboxCasualDresses() {
        this.getCheckboxCasualDresses().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxEveningDresses() {
        this.getCheckboxEveningDresses().click();
        return new CategoryPage( getDriver() );
    }
    
    public CategoryPage clickCheckboxSummerDresses() {
        this.getCheckboxSummerDresses().click();
        return new CategoryPage( getDriver() );
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
