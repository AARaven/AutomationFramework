package com.automationpractice.Tests;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


@Log4j2( topic = "BaseTest class" )
@Listeners( { ScreenShot.class } )
public class BaseTest {
    
    private static final String WEBDRIVER_PROPERTIES_PATH =
            "./src/main/resources/PropertyFiles/webdriver.properties";
    
    private static final ThreadLocal < WebDriver > WEBDRIVER_BOX = new ThreadLocal <>();
    
    @SneakyThrows
    private String getWebDriverProperties( String key ) {
        Properties prop = new Properties();
        prop.load( new FileInputStream( WEBDRIVER_PROPERTIES_PATH ) );
        return prop.getProperty( key );
    }
    
    private void setWebDriverProperties() {
        System.setProperty
                ( getWebDriverProperties( "chromeDriverName" ),
                  getWebDriverProperties( "chromeDriverPath" ) );
    }
    
    private void killDriver() {
        WEBDRIVER_BOX.get().manage().deleteAllCookies();
        WEBDRIVER_BOX.get().close();
        WEBDRIVER_BOX.get().quit();
        WEBDRIVER_BOX.remove();
    }
    
    public WebDriver getDriver() {
        
        WebDriver threadSafeDriver = WEBDRIVER_BOX.get();
        
        if ( threadSafeDriver == null ) {
            
            this.setWebDriverProperties();
            
            threadSafeDriver = new ChromeDriver();
            
            threadSafeDriver.manage()
                            .timeouts().implicitlyWait( 7, TimeUnit.SECONDS );
            
            threadSafeDriver.manage()
                            .window().maximize();
            
            WEBDRIVER_BOX.set( threadSafeDriver );
            log.debug( "Thread-safe instance of webdriver created." );
        }
        log.debug( "Getting thread-safe instance of webdriver" );
        return threadSafeDriver;
    }
    
    @BeforeSuite( description = "Getting thread-safe instance of webdriver.",
                  enabled = true ,alwaysRun = true)
    protected void beforeSuiteMethod() {
        log.debug( "Before suite method :" );
        this.getDriver();
    }
    
    @AfterSuite( description = "Killing thread-safe instance of webdriver.",
                 enabled = true ,alwaysRun = true)
    protected void afterSuiteMethod() {
        log.debug( "After suite method :" );
        this.killDriver();
    }
    
    @BeforeClass( description = "Method that run before test class running.",
                  enabled = false )
    protected void beforeClassMethod() {
        log.debug( "Before class method :" );
    }
    
    @AfterClass( description = "Method that run after test class ending.",
                 enabled = false )
    protected void afterClassMethod() {
        log.debug( "After class method :" );
    }
    
    @BeforeGroups( description = "Method that run before groups running in the test.",
                   enabled = false )
    protected void beforeGroupsMethod() {
        log.debug( "Before groups method :" );
    }
    
    @AfterGroups( description = "Method that run after groups ending in the test.",
                  enabled = false )
    protected void afterGroupsMethod() {
        log.debug( "After groups method :" );
    }
    
    @BeforeTest( description = "Method that run before the test running.",
                 enabled = false )
    protected void beforeTestMethod() {
        log.debug( "Before test method :" );
    }
    
    @AfterTest( description = "Method that run after the test ending.",
                enabled = false )
    protected void afterTestMethod() {
        log.debug( "After test method :" );
    }
    
    @BeforeMethod( description = "Method that run before method running in the test.",
                   enabled = false )
    protected void beforeMethod() {
        log.debug( "Before method :" );
    }
    
    @AfterMethod( description = "Method that run after method ending in the test.",
                  enabled = false )
    protected void afterMethod() {
        log.debug( "After method :" );
    }
}


