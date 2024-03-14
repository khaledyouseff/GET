package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import signUpTest.signUpTest;

public class baseTest {
    public WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().browserVersion("122.0.6261.129").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://codenboxautomationlab.com/registration-form/");

    }

    /*
    @AfterClass
    public void tearDown(){
        this.driver.quit();
    }
*/
}
