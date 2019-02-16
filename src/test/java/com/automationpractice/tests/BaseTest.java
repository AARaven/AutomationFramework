package com.automationpractice.tests;

import com.automationpractice.tests.listeners.ScreenShot;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.Properties;


@Log4j2
@Listeners ( { ScreenShot.class } )
public abstract class BaseTest {
    
    private static final String WEB_DRIVER_PROPERTIES_PATH =
            "./src/main/resources/properties/webdriver.properties";
    
    private static final ThreadLocal < WebDriver > WEB_DRIVER_THREAD_LOCAL =
            new ThreadLocal <>();
    
    @SneakyThrows
    private String getProperties( String key ) {
        Properties prop = new Properties();
        prop.load( new FileInputStream( WEB_DRIVER_PROPERTIES_PATH ) );
        return prop.getProperty( key );
    }
    
    private void setWebDriverProperties() {
        System.setProperty
                ( getProperties( "chromeDriverName" ),
                  getProperties( "chromeDriverPath" ) );
    }
    
    private void killDriver() {
        WEB_DRIVER_THREAD_LOCAL.get().manage().deleteAllCookies();
        WEB_DRIVER_THREAD_LOCAL.get().quit();
        WEB_DRIVER_THREAD_LOCAL.remove();
    }
    
    public WebDriver getDriver() {
        
        WebDriver threadSafeDriver = WEB_DRIVER_THREAD_LOCAL.get();
        
        if ( threadSafeDriver == null ) {
            
            setWebDriverProperties();
            
            threadSafeDriver = new ChromeDriver();

//            threadSafeDriver.manage()
//                            .timeouts().implicitlyWait( 7,
//                                                        TimeUnit.SECONDS );
            
            threadSafeDriver.manage()
                            .window().maximize();
            
            WEB_DRIVER_THREAD_LOCAL.set( threadSafeDriver );
            log.debug( "Thread-safe instance of webdriver created." );
        }
        return threadSafeDriver;
    }
    
    @BeforeSuite ( description = "Getting thread-safe instance of webdriver.",
                   enabled = true, alwaysRun = true )
    protected void beforeSuiteMethod() {
        log.debug( "Before suite method : Getting thread-safe instance of webdriver." );
        getDriver();
    }
    
    @AfterSuite ( description = "Killing thread-safe instance of webdriver.",
                  enabled = true, alwaysRun = true )
    protected void afterSuiteMethod() {
        log.debug( "Killing thread-safe instance of webdriver." );
        killDriver();
    }
    
    @BeforeClass ( description = "Method that run before test class running.",
                   enabled = false )
    protected void beforeClassMethod() {
        log.debug( "Before class method :" );
    }
    
    @AfterClass ( description = "Method that run after test class ending.",
                  enabled = false )
    protected void afterClassMethod() {
        log.debug( "After class method :" );
    }
    
    @BeforeGroups ( description = "Method that run before groups running in the test.",
                    enabled = false )
    protected void beforeGroupsMethod() {
        log.debug( "Before groups method :" );
    }
    
    @AfterGroups ( description = "Method that run after groups ending in the test.",
                   enabled = false )
    protected void afterGroupsMethod() {
        log.debug( "After groups method :" );
    }
    
    @BeforeTest ( description = "Method that run before the test running.",
                  enabled = false )
    protected void beforeTestMethod() {
        log.debug( "Before test method :" );
    }
    
    @AfterTest ( description = "Method that run after the test ending.",
                 enabled = false )
    protected void afterTestMethod() {
        log.debug( "After test method :" );
    }
    
    @BeforeMethod ( description = "Method that run before method running in the test.",
                    enabled = false )
    protected void beforeMethod() {
        log.debug( "Before method :" );
    }
    
    @AfterMethod ( description = "Method that run after method ending in the test.",
                   enabled = false )
    protected void afterMethod() {
        log.debug( "After method :" );
    }
}


