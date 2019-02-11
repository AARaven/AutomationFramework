package com.automationpractice.site.objects.content;

import com.automationpractice.utils.FrameWorkUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import models.order.Clothes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter ( AccessLevel.PROTECTED )
public class ProductForm {
    
    @Setter ( AccessLevel.PROTECTED )
    private WebDriver driver;
    
    @FindBy ( css = "a[class='product-name']" ) private List < WebElement > containerProducts;
    @FindBy ( css = "a[title='Add to cart']" )  private List < WebElement > buttonsAddToCart;
    @FindBy ( css = "a[class='quick-view']" )   private List < WebElement > buttonsQuickView;
    @FindBy ( css = "a[title='View']" )         private List < WebElement > buttonsMore;
    
    public ProductForm navigateToProduct( Clothes clothes ) {
        getContainerProducts().stream()
                              .filter( WebElement :: isDisplayed )
                              .filter( webElement -> webElement.getText()
                                                               .equals( clothes.getName() ) )
                              .findAny()
                              .ifPresent( webElement -> new Actions( getDriver() ).moveToElement( webElement )
                                                                                  .perform() );
        return this;
    }
    
    public AddCartForm clickAddToCart() {
        FrameWorkUtils.clickWhenClickable( getDriver(),
                                           FrameWorkUtils.findElementFromList(
                                                   getButtonsAddToCart() ) );
        return new AddCartForm( getDriver() );
    }
    
    public ProductForm clickQuickView() {
        FrameWorkUtils.clickWhenClickable( getDriver(),
                                           FrameWorkUtils.findElementFromList(
                                                   getButtonsQuickView() ) );
        return this;
    }
    
    public ProductForm clickMore() {
        FrameWorkUtils.clickWhenClickable( getDriver(),
                                           FrameWorkUtils.findElementFromList(
                                                   getButtonsMore() ) );
        return this;
    }
    
    public ProductForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}
