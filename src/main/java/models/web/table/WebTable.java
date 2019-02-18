package models.web.table;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface WebTable {

    List < List < WebElement > > getHeaderContainer();

    List < List < WebElement > > getBodyContainer();

    List < List < WebElement > > getFooterContainer();

    WebElement getHeaderCell( int row , int col );

    WebElement getBodyCell( int row , int col );

    WebElement getFooterCell( int row , int col );
}
