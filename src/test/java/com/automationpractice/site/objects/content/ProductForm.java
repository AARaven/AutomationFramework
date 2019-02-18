package com.automationpractice.site.objects.content;

import com.automationpractice.utils.FrameWorkUtils;
import lombok.AccessLevel;
import lombok.Getter;
import models.order.Clothes;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

@Getter ( AccessLevel.PROTECTED )
public class ProductForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "ul.product_list.grid.row" ) ,
                 @FindBy ( css = "li" ) ,
                 @FindBy ( css = "a[class='product-name']" ) } )
    private List < WebElement > containerProducts;
    @FindBys ( { @FindBy ( css = "ul.product_list.grid.row" ) ,
                 @FindBy ( css = "a[title='Add to cart']" ) } )
    private List < WebElement > buttonsAddToCart;
    @FindBys ( { @FindBy ( css = "ul.product_list.grid.row" ) ,
                 @FindBy ( css = "a[class='quick-view']" ) } )
    private List < WebElement > buttonsQuickView;
    @FindBys ( { @FindBy ( css = "ul.product_list.grid.row" ) ,
                 @FindBy ( css = "a[title='View']" ) } )
    private List < WebElement > buttonsMore;

    @FindBy ( css = "ul.product_list.grid.row" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public ProductForm navigateToProduct( Clothes clothes ) {
        getContainerProducts().stream()
                              .filter( WebElement :: isDisplayed )
                              .filter( webElement -> webElement.getText()
                                                               .equals( clothes.getName() ) )
                              .findFirst()
                              .ifPresent( webElement -> new Actions( getDriver() ).moveToElement( webElement )
                                                                                  .perform() );
        return this;
    }

    public AddCartForm clickAddToCart() {
        FrameWorkUtils.findElementFromList( getButtonsAddToCart() ).click();
        return new AddCartForm( getDriver() );
    }

    public ProductForm clickQuickView() {
        FrameWorkUtils.findElementFromList( getButtonsQuickView() ).click();
        return this;
    }

    public ProductForm clickMore() {
        FrameWorkUtils.findElementFromList( getButtonsMore() ).click();
        return this;
    }

    public ProductForm( WebDriver driver ) {
        super( driver );
    }
}
