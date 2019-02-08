package com.automationpractice.Pages.SecondaryPages;

import com.automationpractice.Forms.ContentForms.CartForm;
import com.automationpractice.Forms.ContentForms.ProductForm;
import com.automationpractice.Forms.FilterForms.FilterForm;
import com.automationpractice.Pages.HomePage;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends HomePage {
    
    public CartForm getCartForm() {
        return new CartForm( getDriver() );
    }
    
    public FilterForm getFilterForm() {
        return new FilterForm( getDriver() );
    }
    
    public ProductForm getProductForm() {
        return new ProductForm(getDriver());
    }
    
    public CategoryPage( WebDriver driver ) {
        super( driver );
    }
}
