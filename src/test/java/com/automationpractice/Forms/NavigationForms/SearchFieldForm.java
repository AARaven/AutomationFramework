package com.automationpractice.Forms.NavigationForms;

import com.automationpractice.Pages.SecondaryPages.SearchPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter( AccessLevel.PRIVATE )
public class SearchFieldForm {
    
    @Setter( AccessLevel.PRIVATE )
    private WebDriver driver;
    
    @FindBy( css = "input[id=search_query_top]" ) private WebElement inputSearch;
    @FindBy( css = "button[name=submit_search]" ) private WebElement buttonSubmit;
    
    public SearchFieldForm( WebDriver driver ) {
        this.setDriver( driver );
        PageFactory.initElements( driver, this );
    }
    
    public SearchPage sendText( String text ) {
        this.getInputSearch().clear();
        this.getInputSearch().sendKeys( text );
        this.getButtonSubmit().click();
        return new SearchPage( getDriver() );
    }
}
