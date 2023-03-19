package runnerfile;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = {"src/test/resources/com.assessment.featurefile"},
        glue = {"/com/assessment/stepdefinition","hooks"},
        monochrome = true,
        publish = true,
        plugin ={"pretty","html:target/CucumberReports/CucumberReport.html",
                "json:test-output/jsonReport.json",
                "junit:test-output/junitReport.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}


)

public class TestRunner {

}
