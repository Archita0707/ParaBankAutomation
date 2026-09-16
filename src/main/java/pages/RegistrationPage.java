package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;

    private By firstName = By.name("customer.firstName");
    private By lastName = By.name("customer.lastName");
    private By address = By.name("customer.address.street");
    private By city = By.name("customer.address.city");
    private By state = By.name("customer.address.state");
    private By zipCode = By.name("customer.address.zipCode");
    private By phone = By.name("customer.phoneNumber");
    private By ssn = By.name("customer.ssn");
    private By username = By.name("customer.username");
    private By password = By.name("customer.password");
    private By confirmPassword = By.id("repeatedPassword");
    private By registerButton = By.cssSelector("input[value='Register']");
    private By successMessage = By.id("rightPanel");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerUser(String fName, String lName, String addr, String cty, String st, String zip, String ph, String ssnNum, String uname, String pwd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(cty);
        driver.findElement(state).sendKeys(st);
        driver.findElement(zipCode).sendKeys(zip);
        driver.findElement(phone).sendKeys(ph);
        driver.findElement(ssn).sendKeys(ssnNum);
        driver.findElement(username).sendKeys(uname);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(pwd);
        driver.findElement(registerButton).click();
    }

    public boolean isRegistrationSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.or(
                ExpectedConditions.textToBePresentInElementLocated(successMessage, "Welcome"),
                ExpectedConditions.textToBePresentInElementLocated(successMessage, "created successfully")
            ));
            String text = driver.findElement(successMessage).getText();
            return text.contains("Your account was created successfully") || text.toLowerCase().contains("welcome");
        } catch (Exception e) {
            return false;
        }
    }
}
