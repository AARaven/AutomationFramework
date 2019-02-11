package com.automationpractice.site;

import com.automationpractice.site.objects.navigation.account.AccountRowForm;
import com.automationpractice.site.objects.navigation.search.SearchFieldForm;
import models.webpage.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class MainPage extends BasePage {
    
    protected MainPage( WebDriver driver ) {
        super( driver );
    }
    
    public AccountRowForm getAccountRowForm() {
        return new AccountRowForm( getDriver() );
    }
    
    public SearchFieldForm getSearchFieldForm() {
        return new SearchFieldForm( getDriver() );
    }
}
