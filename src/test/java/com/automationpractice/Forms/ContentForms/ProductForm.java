package com.automationpractice.Forms.ContentForms;

import Models.Order.Clothes.Clothes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter( AccessLevel.PRIVATE )
public class ProductForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "a[class='product-name']" ) private  List < WebElement > containerProducts;
    @FindBy( css = "a[title='Add to cart']" )  private  List < WebElement > buttonsAddToCart;
    @FindBy( css = "a[class='quick-view']" )   private  List < WebElement > buttonsQuickView;
    @FindBy( css = "a[title='View']" )         private  List < WebElement > buttonsMore;
    
    private void findButton( List < WebElement > buttons ) {
        buttons.stream()
               .filter( WebElement :: isDisplayed )
               .findFirst()
               .ifPresent( WebElement :: click );
    }
    
    public ProductForm navigateToProduct( Clothes clothes ) {
        this.getContainerProducts().stream()
            .filter( webElement -> webElement.getAttribute( "title" )
                                             .contains( clothes.getName() ) )
            .findFirst()
            .ifPresent( webElement -> new Actions( getDriver() ).moveToElement( webElement )
                                                                .build()
                                                                .perform() );
        return this;
    }
    
    public ProductForm navigateToProduct( String  clothes ) {
        this.getContainerProducts().stream()
            .filter( webElement -> webElement.getAttribute( "title" )
                                             .contains( clothes ) )
            .findFirst()
            .ifPresent( webElement -> new Actions( getDriver() ).moveToElement( webElement )
                                                                .build()
                                                                .perform() );
        return this;
    }
    
    public ProductForm clickAddToCart() {
        this.findButton( this.getButtonsAddToCart() );
        return this;
    }
    
    public ProductForm clickQuickView() {
        this.findButton( this.getButtonsQuickView() );
        return this;
    }
    
    public ProductForm clickMore() {
        this.findButton( this.getButtonsMore() );
        return this;
    }
    
    public ProductForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}
