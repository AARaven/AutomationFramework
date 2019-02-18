package com.automationpractice.site.objects.content;

import com.automationpractice.site.pages.ordering.OrderPage;
import lombok.AccessLevel;
import lombok.Getter;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.asserts.SoftAssert;

@Getter ( AccessLevel.PRIVATE )
public class CartForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "div[class='shopping_cart']" ) ,
                 @FindBy ( css = "a[title='View my shopping cart']" ) } )
    private WebElement linkCart;
    @FindBys ( { @FindBy ( css = "div[class='shopping_cart']" ) ,
                 @FindBy ( css = "a[id='button_order_cart'][title='Check out']" ) } )
    private WebElement buttonCheckout;
    @FindBys ( { @FindBy ( css = "div[class='shopping_cart']" ) ,
                 @FindBy ( css = "span[class='ajax_cart_quantity']" ) } )
    private WebElement textProductsQuantity;

    @FindBy ( css = "div[class='shopping_cart']" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public OrderPage clickCart() {
        getLinkCart().click();
        return new OrderPage( getDriver() );
    }

    public OrderPage clickButtonCheckout() {
        getButtonCheckout().click();
        return new OrderPage( getDriver() );
    }

    public CartForm( WebDriver driver ) {
        super( driver );
    }
}
