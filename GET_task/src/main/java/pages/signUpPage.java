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

    By firstName = By.id("firstname");
    By lastName = By.id("last_name");
    By countryName = By.cssSelector("div.filter-option-inner-inner");
    By country = By.xpath("//*[@id=\"bs-select-1-63\"]/span/span");
    By phone = By.id("phone");
    By email = By.id("user_email");
    By password = By.id("password");
    By robot = By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]");
    By signUp = By.id("submitBTN");

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

    //dropdown ----------------------------------------------------------------------
    public void clickCountryName() {
        driver.findElement(countryName).click();
    }

    public void TypeCountryName(String country) {
        driver.findElement(By.cssSelector("input.form-control")).sendKeys(country);
    }

    public void selectCountry() {
        driver.findElement(country).click();
    }


//End of DropDown ----------------------------------------------------------------------

    public void setEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void setPhone(String phone1) {
        driver.findElement(phone).sendKeys(phone1);
    }

    public void setPassword(String password1) {
        driver.findElement(password).sendKeys(password1);
    }

    public void clickRobot() {
        driver.findElement(robot).click();
    }

    public void clickSignUp() {
        driver.findElement(signUp).click();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,500)");
    }
}