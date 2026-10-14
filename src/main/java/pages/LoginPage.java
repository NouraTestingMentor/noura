package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    private final WebDriver driver ;
    private final WebDriverWait wait;
    private By userNameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.cssSelector(".oxd-alert.oxd-alert--error");
    private By requiredMessage = By.xpath("//span[text()='Required']");


    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username){
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
        field.clear();
        field.sendKeys(username);

    }

    public void enterPassword(String password){
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        field.clear();
        field.sendKeys(password);

    }

    public void clickLoginButton(){
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        button.click();

    }

    public  void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    public List<String> getRequiredMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(requiredMessage));

        List<String> texts =new ArrayList<>();
       for (WebElement message: driver.findElements(requiredMessage)){
           texts.add(message.getText());
       }
       return texts;
    }

    public  boolean isRedirected(){
        return wait.until(ExpectedConditions.urlContains("/dashboard"));
    }


}
