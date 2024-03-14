package signUpTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.signUpPage;

import java.time.Duration;

public class signUpTest extends baseTest.baseTest {

    @Test
    public void successfulSignUPTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        signUpPage signUpPage = new signUpPage(driver);
        signUpPage.setFirstName("KHALED");
        signUpPage.setLastName("yousef");
        signUpPage.clickCountryName();
        signUpPage.TypeCountryName("EGYPT");
        signUpPage.selectCountry();
        signUpPage.setPhone("01140342431");
        signUpPage.setEmail("khaledYoussouph36@gmail.com");
        signUpPage.setPassword("Khaledyousef");
        signUpPage.scrollDown();

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(iframeElement);
        //  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div[4]/form/div/div/div/div[6]/div/div/iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@title='reCAPTCHA']")));
        signUpPage.clickRobot();
        driver.switchTo().defaultContent();

        signUpPage.clickSignUp();





    }

}
