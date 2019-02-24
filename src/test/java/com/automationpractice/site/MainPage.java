package com.automationpractice.site;

import com.automationpractice.site.conditions.AdditionalConditions;
import com.automationpractice.site.objects.navigation.account.AccountRowForm;
import com.automationpractice.site.objects.navigation.search.SearchFieldForm;
import models.web.page.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MainPage extends AbstractWebPage {

    protected MainPage( WebDriver driver ) {
        super( driver );
    }

    public AccountRowForm getAccountRowForm() {
        return new AccountRowForm( getDriver() );
    }

    public SearchFieldForm getSearchFieldForm() {
        return new SearchFieldForm( getDriver() );
    }

    public void waitJQueryAJAXCallsHaveCompleted() {
        new WebDriverWait( getDriver() , 60 , 100 )
                .until( AdditionalConditions.jQueryAJAXCallsHaveCompleted() );
    }
}
