package com.sperasoft.edu.bdd.steps;

import com.sperasoft.edu.bdd.GooglePage;
import com.sperasoft.edu.bdd.WebDriverProvider;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class GoogleStepsImp {

    @Autowired
    private WebDriverProvider driverStorage;

    @Given ( "I open google page" )
    public void iOpenGooglePage() {
        GooglePage googlePage = new GooglePage( this.driverStorage.getDriver() );
        googlePage.openPage();
    }

    @Given ( "I type search request {string}" )
    public void iTypeSearchRequest( String text ) {
        GooglePage googlePage = new GooglePage( this.driverStorage.getDriver() );
        googlePage.sendSearchRequest( text );
    }
}
