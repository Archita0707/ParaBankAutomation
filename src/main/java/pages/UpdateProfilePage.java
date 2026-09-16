package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UpdateProfilePage {

    private WebDriver driver;

    private By firstNameField = By.name("customer.firstName");
    private By lastNameField = By.name("customer.lastName");
    private By addressField = By.name("customer.address.street");
    private By cityField = By.name("customer.address.city");
    private By stateField = By.name("customer.address.state");
    private By zipCodeField = By.name("customer.address.zipCode");
    private By phoneField = By.name("customer.phoneNumber");
    private By updateButton = By.cssSelector("input[value='Update Profile']");
    private By resultContainer = By.id("updateProfileResult");

    public UpdateProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void updateAddressAndPhone(String newAddress, String newPhone) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressField));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        fillFieldIfEmpty(firstNameField, "John");
        fillFieldIfEmpty(lastNameField, "Doe");
        fillFieldIfEmpty(addressField, "123 Main St");
        fillFieldIfEmpty(cityField, "City");
        fillFieldIfEmpty(stateField, "State");
        fillFieldIfEmpty(zipCodeField, "12345");
        fillFieldIfEmpty(phoneField, "9876543210");

        if (newAddress != null && !newAddress.isEmpty()) {
            setFieldValue(addressField, newAddress);
        }
        if (newPhone != null && !newPhone.isEmpty()) {
            setFieldValue(phoneField, newPhone);
        }

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(updateButton));
        btn.click();
    }

    private void fillFieldIfEmpty(By locator, String value) {
        try {
            WebElement elem = driver.findElement(locator);
            String currentVal = elem.getAttribute("value");
            if (currentVal == null || currentVal.trim().isEmpty()) {
                elem.clear();
                elem.sendKeys(value);
            }
        } catch (Exception ignored) {}
    }

    private void setFieldValue(By locator, String value) {
        try {
            WebElement elem = driver.findElement(locator);
            elem.clear();
            elem.sendKeys(value);
        } catch (Exception ignored) {}
    }

    public String getConfirmationMessageText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(resultContainer));
            wait.until(d -> !d.findElement(resultContainer).getText().trim().isEmpty());

            List<WebElement> paragraphs = driver.findElements(By.cssSelector("#updateProfileResult p"));
            for (WebElement p : paragraphs) {
                String pt = p.getText().trim();
                if (!pt.isEmpty()) {
                    return pt;
                }
            }
            return driver.findElement(resultContainer).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }
}
