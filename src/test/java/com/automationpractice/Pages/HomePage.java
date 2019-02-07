package com.automationpractice.Pages;

import Models.WebPage.BasePage;
import com.automationpractice.Forms.ContentForms.ProductForm;
import com.automationpractice.Forms.NavigationForms.AccountRowForm;
import com.automationpractice.Forms.NavigationForms.ContentForm;
import com.automationpractice.Forms.NavigationForms.SearchFieldForm;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    
    public ProductForm getProductForm() {
        return new ProductForm( getDriver() );
    }
    
    public AccountRowForm getAccountRow() {
        return new AccountRowForm( getDriver() );
    }
    
    public SearchFieldForm getSearchField() {
        return new SearchFieldForm( getDriver() );
    }
    
    public ContentForm getContentForm() {
        return new ContentForm( getDriver() );
    }
    
    public HomePage( WebDriver driver ) {
        super( driver );
    }
}
