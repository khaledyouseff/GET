package baseTest;

import com.aventstack.extentreports.ExtentReports;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import signUpTest.signUpTest;

import java.io.File;
import java.io.IOException;

public class baseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().browserVersion("122.0.6261.129").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://codenboxautomationlab.com/registration-form/");

    }

    /*
    @AfterMethod
    public void tearDown(){
        this.driver.quit();
    }
*/
    @AfterMethod
    public void takeScreenShot(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            //create reference of taken screen
            TakesScreenshot ts = (TakesScreenshot)driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

        }
    }
}
