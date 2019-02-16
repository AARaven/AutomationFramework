package models.web.form;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter ( AccessLevel.PROTECTED )
@Setter ( AccessLevel.PRIVATE )
public abstract class AbstractWebForm {
    
    private WebDriver     driver;
    private WebDriverWait wait;
    
    protected WebElement mainForm;
    
    public AbstractWebForm( WebDriver driver ) {
        setDriver( driver );
        PageFactory.initElements( driver, this );
        setWait( new WebDriverWait( driver, 5, 100 ) );
        getWait().until( ExpectedConditions.visibilityOf( getMainForm() ) );
    }
}
