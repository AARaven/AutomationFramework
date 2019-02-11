package com.automationpractice.site.objects.navigation.content.Elements;

import com.automationpractice.site.pages.ordering.ProductsPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter ( AccessLevel.PRIVATE )
public class TShirtsForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "a[title='T-shirts']" ) private WebElement buttonTShirts;
    
    public ProductsPage clickButtonTShirts() {
        getButtonTShirts().click();
        return new ProductsPage( getDriver() );
    }
    
    public TShirtsForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}
