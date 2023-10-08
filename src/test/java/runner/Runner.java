package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features = 
{"C:\\Users\\Siddharth Barthwal\\APIAutomationWithCucumber\\src\\test\\java\\features\\1createRepo.feature", 
		"C:\\Users\\Siddharth Barthwal\\APIAutomationWithCucumber\\src\\test\\java\\features\\2updateRepo.feature",
		"C:\\Users\\Siddharth Barthwal\\APIAutomationWithCucumber\\src\\test\\java\\features\\3readARepo.feature",
		"C:\\Users\\Siddharth Barthwal\\APIAutomationWithCucumber\\src\\test\\java\\features\\4deleteARepo.feature"
},
dryRun = false, glue = {"stepDefinitions"},
plugin = {"pretty", "html: target/cucumber-report.html"}
)
public class Runner 
{
	
}
