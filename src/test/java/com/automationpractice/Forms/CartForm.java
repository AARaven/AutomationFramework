package com.automationpractice.Forms;

import com.automationpractice.Pages.SecondaryPages.OrderPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class CartForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "a[title='View my shopping cart']" ) private WebElement linkCart;
    
    private WebElement getLinkCart() {
        return this.linkCart;
    }
    
    public CartForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public OrderPage clickCart() {
        this.getLinkCart().click();
        return new OrderPage( getDriver() );
    }
}
