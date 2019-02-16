package models.web.table;

import lombok.AccessLevel;
import lombok.Getter;
import models.web.table.enums.CartBodyColumns;
import models.web.table.enums.CartFooterColumns;
import models.web.table.enums.CartFooterRows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@Getter ( AccessLevel.PROTECTED )
public abstract class AbstractWebTable implements WebTable {
    
    protected WebElement table;
    
    private WebElement getHeader() {
        return getTable()
                .findElement( By.cssSelector( "thead" ) );
    }
    
    private WebElement getBody() {
        return getTable()
                .findElement( By.cssSelector( "tbody" ) );
    }
    
    private WebElement getFooter() {
        return getTable()
                .findElement( By.cssSelector( "tfoot" ) );
    }
    
    public List < List < WebElement > > getHeaderContainer() {
        return getHeader().findElements( By.cssSelector( "tr" ) ).stream()
                          .map( webElement -> webElement.findElements( By.cssSelector( "th" ) ) )
                          .collect( Collectors.toList() );
    }
    
    public List < List < WebElement > > getBodyContainer() {
        return getBody().findElements( By.cssSelector( "tr" ) ).stream()
                        .map( webElement -> webElement.findElements( By.cssSelector( "td" ) ) )
                        .collect( Collectors.toList() );
    }
    
    public List < List < WebElement > > getFooterContainer() {
        return getFooter().findElements( By.cssSelector( "tr" ) ).stream()
                          .map( webElement -> webElement.findElements( By.cssSelector( "td" ) ) )
                          .collect( Collectors.toList() );
    }
    
    public WebElement getHeaderCell( int row, int col ) {
        return getHeaderContainer().get( row ).get( col );
    }
    
    public WebElement getBodyCell( int row, int col ) {
        return getBodyContainer().get( row ).get( col );
    }
    
    public WebElement getFooterCell( int row, int col ) {
        return getFooterContainer().get( row ).get( col );
    }
    
    public WebElement getBodyCell( int row, CartBodyColumns columns ) {
        return getBodyContainer().get( row ).get( columns.ordinal() );
    }
    
    public WebElement getFooterCell( CartFooterRows rows, CartFooterColumns columns ) {
        return getFooterContainer().get( rows.ordinal() ).get( columns.ordinal() );
    }
}
