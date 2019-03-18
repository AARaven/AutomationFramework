package com.sperasoft.edu.bdd.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith ( Cucumber.class )
@CucumberOptions ( features = "./src/test/resources/features/",
                   glue = { "com.sperasoft.edu.bdd" },
                   plugin = { "pretty" } )
public class CucumberRunner {
}
