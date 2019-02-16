package models.web.page;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

@Getter ( AccessLevel.PROTECTED )
@Setter ( AccessLevel.PRIVATE )
public abstract class AbstractWebPage implements WebPage {
    
    private static final String PROPERTIES_WEB_PAGES_PATH =
            "./src/main/resources/properties/page.properties";
    
    private URL           url;
    private WebDriver     driver;
    
    @SneakyThrows
    private String getProperties( String key ) {
        Properties prop = new Properties();
        prop.load( new FileInputStream( PROPERTIES_WEB_PAGES_PATH ) );
        return prop.getProperty( key );
    }
    
    @SneakyThrows
    protected AbstractWebPage( WebDriver driver ) {
        setDriver( driver );
        setUrl( new URL( getProperties( getClass().getSimpleName() ) ) );
        PageFactory.initElements( driver, this );
    }
    
    @SneakyThrows
    protected String[] getJsonToStrings( String key, String path ) {
        ObjectMapper mapper  = new ObjectMapper();
        String[]     strings;
        HashMap      hashMap = mapper.readValue( new File( path ), HashMap.class );
        strings = mapper.convertValue( hashMap.get( key ), String[].class );
        return strings;
    }
    
    @Override public void next() {
        getDriver().navigate().forward();
    }
    
    @Override public void back() {
        getDriver().navigate().back();
    }
    
    @Override public void refresh() {
        getDriver().navigate().refresh();
    }
    
    @Override public void open() {
        getDriver().navigate().to( getUrl() );
    }
    
    @Override public void open( URL url ) {
        getDriver().navigate().to( url );
    }
    
    @Override public void close() {
        getDriver().close();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash( getUrl(),
                             getDriver() );
        
    }
    
    @Override
    public String toString() {
        return String.format( "%s {" +
                              "\nURL : %s" +
                              "\nTitle : %s }",
                              getClass().getSimpleName(),
                              getDriver().getCurrentUrl(),
                              getDriver().getTitle() );
    }
}
