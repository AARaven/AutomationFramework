package com.automationpractice.site.pages.account;

import com.automationpractice.site.MainPage;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter ( AccessLevel.PRIVATE )
public class PersonalInfoPage extends MainPage {
    
    public PersonalInfoPage( WebDriver driver ) {
        super( driver );
    }
    
    @FindBy ( css = "button[name='submitIdentity']" ) private WebElement buttonSubmit;
    
    public PersonalInfoPage clickSubmit() {
        getButtonSubmit().click();
        return this;
    }
}
