package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class successfulSignUpPage {

WebDriver driver;

    public successfulSignUpPage(WebDriver driver){
        this.driver=driver;
    }
    public String findText(){
       return driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/main/article/div/div[1]/div/div[1]/p")).getText();
    }



}
