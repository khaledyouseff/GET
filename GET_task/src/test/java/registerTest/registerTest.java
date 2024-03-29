package registerTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.registerPage;
import pages.successfulRegisterPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class registerTest extends baseTest.baseTest {

    @Test
    public void successfulSignUPTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        registerPage signUpPage = new registerPage(driver);
        successfulRegisterPage successfulRegisterPage = new successfulRegisterPage(driver);
        signUpPage.setFirstName("Khaled");
        signUpPage.setLastName("yousef");
        signUpPage.setEmail("khaledYoussouph36@gmail.com");
        signUpPage.setPhone("01140342431");
        signUpPage.scrollDown();


        String option ="Selenium Automation";
        signUpPage.selectCourseDropDownElement(option);
        var selectedOption = signUpPage.getSelectedCourseOption();
        assertEquals(selectedOption.size(), 1 , "incorrect number of selections");
        assertTrue(selectedOption.contains(option),"incorrect option");

        String option1 ="January";
        signUpPage.selectMonthDropDownElement(option1);
        var selectedOption1 = signUpPage.getSelectedMonthOption();
        assertEquals(selectedOption.size(), 1 , "incorrect number of selections");
        assertTrue(selectedOption1.contains(option1),"incorrect option");
        signUpPage.checkHowDidYouKnowAboutUs();
        signUpPage.scrollDown();
        signUpPage.clickRegister();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/main/article/div/div[1]/div/div[1]/p")));
        String successfulRegistrationMessage= successfulRegisterPage.findText();
        assertEquals(successfulRegistrationMessage, "Your registration is completed. We will contact with you soon. Thank you !", "invalid");











    }

}
