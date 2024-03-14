package signUpTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.signUpPage;
import pages.successfulSignUpPage;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class badScenariosSignUp extends baseTest.baseTest {



    @Test
    public void verifyFirstNameAndLastNameCapitalLetterTest() throws InterruptedException {
        // it’s a bug because first name and last name must start with capital letter

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        signUpPage signUpPage = new signUpPage(driver);
        successfulSignUpPage successfulSignUpPage = new successfulSignUpPage(driver);
        //NOT starting with capital letter
        signUpPage.setFirstName("khaled"); // starts with small letter

        signUpPage.setLastName("yousef"); // starts with small letter
        signUpPage.setEmail("khaledYoussouph36@gmail.com");
        signUpPage.setPhone("01140342431");
        signUpPage.scrollDown();


        String option = "Selenium Automation";
        signUpPage.selectCourseDropDownElement(option);
        var selectedOption = signUpPage.getSelectedCourseOption();
        assertEquals(selectedOption.size(), 1, "incorrect number of selections");
        assertTrue(selectedOption.contains(option), "incorrect option");
// starts with small letter
        String option1 = "January";
        signUpPage.selectMonthDropDownElement(option1);
        var selectedOption1 = signUpPage.getSelectedMonthOption();
        assertEquals(selectedOption.size(), 1, "incorrect number of selections");
        assertTrue(selectedOption1.contains(option1), "incorrect option");
        signUpPage.checkHowDidYouKnowAboutUs();
        signUpPage.scrollDown();

        //WebElement registerButton=driver.findElement(By.id("nf-field-15"));
        //Assert.assertTrue(registerButton.isDisplayed() , "this is a bug");
        signUpPage.clickRegister();
        WebElement errorMessage =driver.findElement(By.xpath("//*[@id=\"nf-form-errors-3\"]/nf-errors/nf-section/div"));
        Assert.assertEquals(errorMessage.getText() , "Please correct errors before submitting this form.");



    }

    @Test
    public void verifyFirstNameAndLastNameAreNotEqualsTest() throws InterruptedException {
        // it’s a bug because first name and last name must Not be equals but the registration succeeded

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        signUpPage signUpPage = new signUpPage(driver);
        successfulSignUpPage successfulSignUpPage = new successfulSignUpPage(driver);
        signUpPage.setFirstName("Khaled"); //First name = Last name
        signUpPage.setLastName("Khaled");  //First name = Last name

        signUpPage.setEmail("khaledYoussouph36@gmail.com");
        signUpPage.setPhone("01140342431");
        signUpPage.scrollDown();

        String option = "Selenium Automation";
        signUpPage.selectCourseDropDownElement(option);
        var selectedOption = signUpPage.getSelectedCourseOption();
        assertEquals(selectedOption.size(), 1, "incorrect number of selections");
        assertTrue(selectedOption.contains(option), "incorrect option");

        String option1 = "January";
        signUpPage.selectMonthDropDownElement(option1);
        var selectedOption1 = signUpPage.getSelectedMonthOption();
        assertEquals(selectedOption.size(), 1, "incorrect number of selections");
        assertTrue(selectedOption1.contains(option1), "incorrect option");
        signUpPage.checkHowDidYouKnowAboutUs();
        signUpPage.scrollDown();
        signUpPage.clickRegister();

        WebElement errorMessage =driver.findElement(By.xpath("//*[@id=\"nf-form-errors-3\"]/nf-errors/nf-section/div"));
        Assert.assertEquals(errorMessage.getText() , "Please correct errors before submitting this form.");

    }
    @Test
    public void invalidPhoneNumberTest() throws InterruptedException {
        // it’s a bug because phone number must be in a valid form

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        signUpPage signUpPage = new signUpPage(driver);
        successfulSignUpPage successfulSignUpPage = new successfulSignUpPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nf-field-17")));

        signUpPage.setFirstName("Khaled");

        signUpPage.setLastName("Yousef");
        signUpPage.setEmail("khaledYoussouph36@gmail.com");
        signUpPage.setPhone("654kbkb25415"); // invalid mobile number format
        signUpPage.scrollDown();


        String option = "Selenium Automation";
        signUpPage.selectCourseDropDownElement(option);
        var selectedOption = signUpPage.getSelectedCourseOption();
        assertEquals(selectedOption.size(), 1, "incorrect number of selections");
        assertTrue(selectedOption.contains(option), "incorrect option");

        String option1 = "January";
        signUpPage.selectMonthDropDownElement(option1);
        var selectedOption1 = signUpPage.getSelectedMonthOption();
        assertEquals(selectedOption.size(), 1, "incorrect number of selections");
        assertTrue(selectedOption1.contains(option1), "incorrect option");
        signUpPage.checkHowDidYouKnowAboutUs();
        signUpPage.scrollDown();
        signUpPage.clickRegister();
        WebElement errorMessage =driver.findElement(By.xpath("//*[@id=\"nf-form-errors-3\"]/nf-errors/nf-section/div"));
        Assert.assertEquals(errorMessage.getText() , "Please correct errors before submitting this form.");

    }

}