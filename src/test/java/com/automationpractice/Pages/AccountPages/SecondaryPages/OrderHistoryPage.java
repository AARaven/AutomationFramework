package com.automationpractice.Pages.AccountPages.SecondaryPages;

import com.automationpractice.Pages.AccountPages.AccountPage;
import com.automationpractice.Pages.HomePage;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter( AccessLevel.PRIVATE )
public class OrderHistoryPage extends HomePage {
    
    @FindBy( xpath = "//span[contains(text(),'Home')]" )
    private WebElement buttonHome;
    
    @FindBy( xpath = "//ul[@class='footer_links clearfix']//li[1]//a[1]//span[1]" )
    private WebElement buttonBack;
    
    @FindBy( className = "link-button" )
    private WebElement linkPdf;
    
    public HomePage clickHome() {
        this.getButtonHome().click();
        return new HomePage( getDriver() );
    }
    
    public AccountPage clickBack() {
        this.getButtonBack().click();
        return new AccountPage( getDriver() );
    }
    
    public OrderHistoryPage( WebDriver driver ) {
        super( driver );
    }

//    public OrderHistoryPage downloadOrderAsPdf() {
//
//        this.driver.findElements( By.tagName( "a" ) ).stream()
//                   .filter( element -> element.getAttribute( "target" )
//                                              .contains( "_blank" ) )
//                   .findFirst().ifPresent( WebElement::click );
//
//        return this;
//    }
//
//    public boolean isDownloaded() {
//        return takeListFileFromDownloadFolderWithPdfSuffix().isEmpty();
//    }
//
//    @SneakyThrows
//    private List < String > takeListFileFromDownloadFolderWithPdfSuffix() {
//
//        File path = new File( "D:\\Загрузки" );
//
//        return Arrays.stream( path.list() )
//                     .filter( s -> s.endsWith( ".pdf" ) )
//                     .collect( Collectors.toList() );
//    }
//
//    public String getDownloadFileName() {
//
//        File path = new File( "D:\\Загрузки" );
//        String filename = Arrays.stream( path.list() )
//                                .filter( s -> s.endsWith( ".pdf" ) )
//                                .findFirst().get();
//        return filename;
//    }
}