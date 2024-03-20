package registerTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.registerPage;
import pages.successfulRegisterPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class badScenariosRegister extends baseTest.baseTest {



    @Test
    public void verifyFirstNameAndLastNameCapitalLetterTest() throws InterruptedException {
        // it’s a bug because first name and last name must start with capital letter

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        registerPage signUpPage = new registerPage(driver);
        successfulRegisterPage successfulRegisterPage = new successfulRegisterPage(driver);
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
        String option1 = "January";
        signUpPage.selectMonthDropDownElement(option1);
        var selectedOption1 = signUpPage.getSelectedMonthOption();
        assertEquals(selectedOption.size(), 1, "incorrect number of selections");
        assertTrue(selectedOption1.contains(option1), "incorrect option");
        signUpPage.checkHowDidYouKnowAboutUs();
        signUpPage.scrollDown();


        signUpPage.clickRegister();


        //•	Recover from Assertion failures and other exceptions by
        // closing the browser window, terminating test execution

        try {
            WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"nf-form-errors-3\"]/nf-errors/nf-section/div"));
            Assert.assertEquals(errorMessage.getText(), "Please correct errors before submitting this form.");
            }
        catch (AssertionError | Exception e){
           // Reporter.log("Exception occurred: " + e.getMessage());
            System.out.println("Error occurred: " + e.getMessage());
            driver.quit();
        }


    }

    @Test
    public void verifyFirstNameAndLastNameAreNotEqualsTest() throws InterruptedException {
        // it’s a bug because first name and last name must Not be equals but the registration succeeded

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        registerPage signUpPage = new registerPage(driver);
        successfulRegisterPage successfulRegisterPage = new successfulRegisterPage(driver);
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

        registerPage signUpPage = new registerPage(driver);
        successfulRegisterPage successfulRegisterPage = new successfulRegisterPage(driver);
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