package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // locators
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.cssSelector("button[type='submit']");
    By errorMsg = By.cssSelector(".oxd-alert-content-text");
    By usernameErr = By.xpath("//input[@name='username']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]");
    By passwordErr = By.xpath("//input[@name='password']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]");
    By dashboardTitle = By.cssSelector(".oxd-topbar-header-breadcrumb h6");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void enterUsername(String uname) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        field.clear();
        field.sendKeys(uname);
    }

    public void enterPassword(String pwd) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        field.clear();
        field.sendKeys(pwd);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public void doLogin(String uname, String pwd) {
        enterUsername(uname);
        enterPassword(pwd);
        clickLogin();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).getText();
    }

    public String getUsernameError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameErr)).getText();
    }

    public String getPasswordError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordErr)).getText();
    }

    public String getDashboardHeading() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTitle)).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
