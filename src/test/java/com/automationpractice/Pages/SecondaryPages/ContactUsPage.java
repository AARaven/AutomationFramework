package com.automationpractice.Pages.SecondaryPages;

import com.automationpractice.Forms.TextForms.MessageForm;
import com.automationpractice.Pages.HomePage;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends HomePage {
    
    public MessageForm getMessage() {
        return new MessageForm( getDriver() );
    }
    
    public ContactUsPage( WebDriver driver ) {
        super( driver );
    }
}
