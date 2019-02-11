package com.automationpractice.site.pages;

import com.automationpractice.site.objects.text.MessageForm;
import com.automationpractice.site.MainPage;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends MainPage {
    
    public MessageForm getMessage() {
        return new MessageForm( getDriver() );
    }
    
    public ContactUsPage( WebDriver driver ) {
        super( driver );
    }
}
