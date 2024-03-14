package pages;

import org.openqa.selenium.By;
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
By phone = By.id("phone");
By email = By.id("user_email");
By password = By.id("password");
By robot = By.id("recaptcha-anchor-label");
By signUp = By.id("submitBTN");

    WebDriver driver ;
    public signUpPage(WebDriver driver){
        this.driver=driver;
    }
    public void setFirstName(String name1){
        driver.findElement(firstName).sendKeys(name1);
    }
    public void setLastName(String name2){
        driver.findElement(lastName).sendKeys(name2);
    }
//dropdown ----------------------------------------------------------------------

    public Select findDropDown(){
        return new Select(driver.findElement(countryName));
    }
public void setCountryName(String countryName){
        driver.findElement(By.cssSelector("input.form-control"));
}
    public void selectDropDownElement(String option){
        findDropDown().selectByVisibleText(option);
    }
    public List<String> getSelectedOption(){
        List<WebElement> selectedElement=
                findDropDown().getAllSelectedOptions();
        return selectedElement.stream().map(e->e.getText()).collect(Collectors.toList());

    }
//End of DropDown ----------------------------------------------------------------------

    public void setEmail(String mail){
        driver.findElement(email).sendKeys(mail);
    }
    public void setPassword(String password1){
        driver.findElement(password).sendKeys(password1);
    }

    public void clickRobot(){
        driver.findElement(robot).click();
    }
    public void clickSignUp(){
        driver.findElement(signUp).click();
    }
}
