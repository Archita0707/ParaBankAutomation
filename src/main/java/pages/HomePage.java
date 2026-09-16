package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private By registerLink = By.linkText("Register");
    private By accountsOverviewLink = By.linkText("Accounts Overview");
    private By updateContactInfoLink = By.linkText("Update Contact Info");
    private By logoutLink = By.linkText("Log Out");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegister() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    public void clickAccountsOverview() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(accountsOverviewLink)).click();
    }

    public void clickUpdateContactInfo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(updateContactInfoLink)).click();
    }

    public void logout() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(logoutLink));
        } catch (Exception ignored) {}
    }

    public boolean isLoginSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
