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
public class DressesForm {
    
    @Setter ( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy ( css = "a[title='Casual Dresses']" ) private  WebElement buttonCasualDresses;
    @FindBy ( css = "a[title='Evening Dresses']" ) private WebElement buttonEveningDresses;
    @FindBy ( css = "a[title='Summer Dresses']" ) private  WebElement buttonSummerDresses;
    
    public ProductsPage clickButtonCasualDresses() {
        getButtonCasualDresses().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickButtonEveningDresses() {
        getButtonEveningDresses().click();
        return new ProductsPage( getDriver() );
    }
    
    public ProductsPage clickButtonSummerDresses() {
        getButtonSummerDresses().click();
        return new ProductsPage( getDriver() );
    }
    
    public DressesForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
    }
}
