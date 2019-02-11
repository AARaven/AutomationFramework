package com.automationpractice.site.pages;

import com.automationpractice.site.objects.content.ProductForm;
import com.automationpractice.site.objects.navigation.content.ContentRowForm;
import com.automationpractice.site.MainPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends MainPage {
    
    
    public ProductForm getProductForm() {
        return new ProductForm( getDriver() );
    }
    
    public ContentRowForm getContentForm() {
        return new ContentRowForm( getDriver() );
    }
    
    public HomePage( WebDriver driver ) {
        super( driver );
    }
}
