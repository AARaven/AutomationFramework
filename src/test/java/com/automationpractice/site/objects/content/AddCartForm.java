package com.automationpractice.site.objects.content;

import com.automationpractice.site.pages.ordering.OrderPage;
import com.automationpractice.site.pages.ordering.ProductsPage;
import com.automationpractice.utils.FrameWorkUtils;
import lombok.AccessLevel;
import lombok.Getter;
import models.web.form.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.asserts.SoftAssert;

@Getter ( AccessLevel.PRIVATE )
public class AddCartForm extends AbstractWebForm {

    @FindBys ( { @FindBy ( css = "div[id='layer_cart'" ) ,
                 @FindBy ( css = "span[title='Continue shopping']" ) } )
    private WebElement buttonContinue;
    @FindBys ( { @FindBy ( css = "div[id='layer_cart'" ) ,
                 @FindBy ( css = "a[title='Proceed to checkout']" ) } )
    private WebElement buttonProceedToCheckout;
    @FindBys ( { @FindBy ( css = "div[id='layer_cart'" ) ,
                 @FindBy ( css = "span[title='Close window']" ) } )
    private WebElement buttonClose;
    @FindBys ( { @FindBy ( css = "div[id='layer_cart'" ) ,
                 @FindBy ( css = "div.layer_cart_product" ) ,
                 @FindBy ( css = "h2" ) } )
    private WebElement textSuccessfullyAddedToCart;

    @FindBy ( css = "div[id='layer_cart'" )
    @Getter ( AccessLevel.PROTECTED )
    protected WebElement mainForm;

    public ProductsPage clickButtonContinue() {
        FrameWorkUtils.clickWhenClickable( getDriver() , getButtonContinue() );
        return new ProductsPage( getDriver() );
    }

    public ProductsPage clickButtonClose() {
        FrameWorkUtils.clickWhenClickable( getDriver() , getButtonClose() );
        return new ProductsPage( getDriver() );
    }

    public OrderPage clickButtonProceedToCheckout() {
        FrameWorkUtils.clickWhenClickable( getDriver() , getButtonContinue() );
        return new OrderPage( getDriver() );
    }

    public SoftAssert verifyThatProductAddedToCart() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals( getTextSuccessfullyAddedToCart().getText() ,
                                 "Product successfully added to your shopping cart" );
        getButtonClose().click();
        return softAssert;
    }

    public AddCartForm( WebDriver driver ) {
        super( driver );
    }
}
