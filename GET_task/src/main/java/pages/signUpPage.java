package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class signUpPage {

    By firstName = By.id("nf-field-17");
    By lastName = By.id("nf-field-18");

    By phone = By.id("nf-field-20");
    By email = By.id("nf-field-19");

    By course = By.id("nf-field-22");
    By month = By.id("nf-field-24");
    By check = By.id("nf-label-class-field-23-0");
    By register = By.id("nf-field-15");

    WebDriver driver;

    public signUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String name1) {
        driver.findElement(firstName).sendKeys(name1);
    }

    public void setLastName(String name2) {
        driver.findElement(lastName).sendKeys(name2);
    }


    public void setEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void setPhone(String phone1) {
        driver.findElement(phone).sendKeys(phone1);
    }
    // select course from dropDown--------------------------------------------------------------
    public Select findCourseDropDown(){
         return new Select(driver.findElement(course));
    }
    public void selectCourseDropDownElement(String option) {

        findCourseDropDown().selectByVisibleText(option);
    }
        public List<String> getSelectedCourseOption() {
            List<WebElement> selectedCourseElement =
                    findCourseDropDown().getAllSelectedOptions();
            return selectedCourseElement.stream().map(e -> e.getText()).collect(Collectors.toList());

        }
    //End of Drop Down code--------------------------------------------------------------
// select month from dropDown--------------------------------------------------------------
    public Select findMonthDropDown(){
        return new Select(driver.findElement(month));
    }
    public void selectMonthDropDownElement(String option) {

        findMonthDropDown().selectByVisibleText(option);
    }
    public List<String> getSelectedMonthOption() {
        List<WebElement> selectedMonthElement =
                findMonthDropDown().getAllSelectedOptions();
        return selectedMonthElement.stream().map(e -> e.getText()).collect(Collectors.toList());

    }
    //End of Drop Down code--------------------------------------------------------------

public void checkHowDidYouKnowAboutUs(){
        driver.findElement(check).click();
}



    public successfulSignUpPage clickRegister() {
        driver.findElement(register).click();
        return new successfulSignUpPage(driver);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,500)");
    }
}