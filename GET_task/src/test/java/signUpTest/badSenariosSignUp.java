package signUpTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.signUpPage;
import pages.successfulSignUpPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class badSenariosSignUp extends baseTest.baseTest {
    @Test
    public void verifyFirstNameAndLastNameCapitalLetterTest() throws InterruptedException {
        // it’s a bug because first name and last name must start with capital letter

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        signUpPage signUpPage = new signUpPage(driver);
        successfulSignUpPage successfulSignUpPage = new successfulSignUpPage(driver);
        //NOT starting with capital letter
        signUpPage.setFirstName("khaled"); // starts with small letter
        //String expectedText = "Khaled";
        //String actualText = driver.findElement(By.id("nf-field-17")).getText();
       //Assert.assertEquals(expectedText , actualText , "first name must start with capital letter");



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
        signUpPage.clickRegister();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/main/article/div/div[1]/div/div[1]/p")));
        String successfulRegistrationMessage = successfulSignUpPage.findText();
        assertEquals(successfulRegistrationMessage, "Your registration is completed. We will contact with you soon. Thank you !", "invalid");


    }

    @Test
    public void verifyFirstNameAndLastNameAreNotEqualsTest() throws InterruptedException {
        // it’s a bug because first name and last name must Not be equals but the registration succeeded

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        signUpPage signUpPage = new signUpPage(driver);
        successfulSignUpPage successfulSignUpPage = new successfulSignUpPage(driver);
        signUpPage.setFirstName("Khaled");
        //String expectedText = "Khaled";
        //String actualText = driver.findElement(By.id("nf-field-17")).getText();
        //Assert.assertEquals(expectedText , actualText , "first name must start with capital letter");

        signUpPage.setLastName("Khaled");
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/main/article/div/div[1]/div/div[1]/p")));
        String successfulRegistrationMessage = successfulSignUpPage.findText();
        assertEquals(successfulRegistrationMessage, "Your registration is completed. We will contact with you soon. Thank you !", "invalid");


    }
    @Test
    public void invalidPhoneNumberTest() throws InterruptedException {
        // it’s a bug because phone number must be in a valid form

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        signUpPage signUpPage = new signUpPage(driver);
        successfulSignUpPage successfulSignUpPage = new successfulSignUpPage(driver);
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/main/article/div/div[1]/div/div[1]/p")));
        String successfulRegistrationMessage = successfulSignUpPage.findText();
        assertEquals(successfulRegistrationMessage, "Your registration is completed. We will contact with you soon. Thank you !", "invalid");


    }

}