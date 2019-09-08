package com.techpath.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
	        format={"pretty","json:path/to/json_repot.json"},
	        features = "Features",
	        glue="com.techpath.stepDefinitions",
	        tags={"@SmokeTest"}
	        )


public class TestRunner extends AbstractTestNGCucumberTests {

}