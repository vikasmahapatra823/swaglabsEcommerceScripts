package Runner;

import Constants.ApplicationConstatnt;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = {"classpath:FeatureFiles/Swag_Labs_End_to_End_flow.feature"},
        glue = {"classpath:stepDefinition"},
        tags = "@Test_01",
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)

public class swaglabEndToEndRunner extends AbstractTestNGCucumberTests {


    public static WebDriver driver;




   @BeforeClass
    public static void Setup() {

        String BrowserName = "Chrome";
        launchBrowser(BrowserName);
        ApplicationConstatnt.driverMap.put(Thread.currentThread().threadId(), driver);
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown() {
//        driver.quit();


    }

    public static void launchBrowser(String browserName) {

        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "FireFox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser not found");

        }
    }
}
