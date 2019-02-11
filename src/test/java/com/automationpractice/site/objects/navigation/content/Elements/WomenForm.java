package com.automationpractice.site.objects.navigation.content.Elements;

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
public class WomenForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "a[title='Women']" ) private WebElement buttonWomen;
    
    
    public WomenSubMenu navigate() {
        new Actions( getDriver() ).moveToElement( getButtonWomen() )
                                  .build()
                                  .perform();
        return new WomenSubMenu( getDriver() );
    }
    
    public ProductsPage click() {
        getButtonWomen().click();
        return new ProductsPage( getDriver() );
    }
    
    public WomenForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}
