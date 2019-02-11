package com.automationpractice.site.objects.filter.elements;

import com.automationpractice.site.pages.ordering.ProductsPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class PriceSlideForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( xpath = "//div[@id='layered_price_slider']//a[1]" )
    private WebElement sliderLeftBorder;
    
    @FindBy ( xpath = "//div[@id='layered_price_slider']//a[2]" )
    private WebElement sliderRightBorder;
    
    public PriceSlideForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public ProductsPage slideLeftToRight( int xOffset, int yOffset ) {
        new Actions( getDriver() ).dragAndDropBy(
                getSliderLeftBorder(), xOffset, yOffset );
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage slideRIghtToLeft( int xOffset, int yOffset ) {
        new Actions( getDriver() ).dragAndDropBy(
                getSliderRightBorder(), xOffset, yOffset );
        return new ProductsPage( getDriver() );
    }
}