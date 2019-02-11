package com.automationpractice.site.objects.content;

import com.automationpractice.site.pages.ordering.ProductsPage;
import com.automationpractice.site.pages.ordering.OrderPage;
import com.automationpractice.utils.FrameWorkUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter ( AccessLevel.PRIVATE )
public class AddCartForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @Setter(AccessLevel.PRIVATE)
    private WebDriverWait webDriverWait;
    
    @FindBy ( css = "span[title='Continue shopping']" ) private  WebElement buttonContinue;
    @FindBy ( css = "a[title='Proceed to checkout']" )  private  WebElement buttonProceedToCheckout;
    @FindBy ( css = "span[title='Close window']" )      private  WebElement buttonClose;
    
    public ProductsPage clickButtonContinue() {
        FrameWorkUtils.clickWhenClickable( getDriver(), getButtonContinue() );
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickButtonClose() {
        FrameWorkUtils.clickWhenClickable( getDriver(), getButtonClose() );
        return new ProductsPage( getDriver() );
    }
    
    public OrderPage clickButtonProceedToCheckout() {
        FrameWorkUtils.clickWhenClickable( getDriver(), getButtonProceedToCheckout() );
        return new OrderPage( getDriver() );
    }
    
    public AddCartForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver , this );
    }
}
