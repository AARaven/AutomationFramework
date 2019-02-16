package com.automationpractice.site.pages.ordering;

import com.automationpractice.site.MainPage;
import com.automationpractice.site.objects.content.CartForm;
import com.automationpractice.site.objects.content.ProductForm;
import com.automationpractice.site.objects.filter.FilterForm;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

@Getter ( AccessLevel.PRIVATE )
public class ProductsPage extends MainPage {
    
    @FindBy ( css = "h2 > i.icon-ok" ) private WebElement textSuccessfuly;
    
    public CartForm getCartForm() {
        return new CartForm( getDriver() );
    }
    
    public FilterForm getFilterForm() {
        return new FilterForm( getDriver() );
    }
    
    public ProductForm getProductForm() {
        return new ProductForm( getDriver() );
    }
    
    public ProductsPage( WebDriver driver ) {
        super( driver );
    }
    
    public SoftAssert verifyAddToCart() {
        SoftAssert softAssert = new SoftAssert();
        
        new WebDriverWait( getDriver(), 5, 100 )
                .until( ExpectedConditions.visibilityOf( getTextSuccessfuly() ) );
        
        softAssert.assertEquals( getTextSuccessfuly().getText(),
                                 "Product successfully added to your shopping cart" );
        return softAssert;
    }
}
