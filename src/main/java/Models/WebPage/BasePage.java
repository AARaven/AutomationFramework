package Models.WebPage;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

@Getter( AccessLevel.PROTECTED )
@Setter( AccessLevel.PRIVATE )
public abstract class BasePage implements WebPage {
    
    private static final String PROPERTIES_WEB_PAGES_PATH =
            "./src/main/resources/PropertyFiles/page.properties";
    
    private URL       url;
    private WebDriver driver;
    
    private String getTitle() {
        return this.getDriver().getTitle();
    }
    
    @SneakyThrows
    private String getWebPageProperty( String key ) {
        Properties prop = new Properties();
        prop.load( new FileInputStream( PROPERTIES_WEB_PAGES_PATH ) );
        return prop.getProperty( key );
    }
    
    @SneakyThrows
    protected BasePage( WebDriver driver ) {
        this.setDriver( driver );
        this.setUrl( new URL( getWebPageProperty( getClass().getSimpleName() ) ) );
        PageFactory.initElements( driver, this );
    }
    
    @SneakyThrows
    protected String[] getJsonAsStringArray( String key, String path ) {
        ObjectMapper mapper  = new ObjectMapper();
        String[]     strings;
        HashMap      hashMap = mapper.readValue( new File( path ), HashMap.class );
        strings = mapper.convertValue( hashMap.get( key ), String[].class );
        return strings;
    }
    
    protected void navigateToElement( WebElement element ) {
        new Actions( getDriver() )
                .moveToElement( element )
                .build()
                .perform();
    }
    
    @Override public void nextPage() {
        this.getDriver().navigate().forward();
    }
    
    @Override public void previousPage() {
        this.getDriver().navigate().back();
    }
    
    @Override public void refreshPage() {
        this.getDriver().navigate().refresh();
    }
    
    @Override public void openPage() {
        this.getDriver().navigate().to( this.getUrl() );
    }
    
    @Override public void openPage( URL url ) {
        this.getDriver().navigate().to( getUrl() );
    }
    
    @Override public void closePage() {
        this.getDriver().close();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash( this.getDriver(),
                             this.getUrl() );
    }
    
    @Override
    public String toString() {
        return String.format( "%s {" +
                              "\nURL : %s" +
                              "\nTitle : %s }",
                              this.getClass()
                                  .getSimpleName(),
                              this.getUrl(),
                              this.getTitle() );
    }
}
