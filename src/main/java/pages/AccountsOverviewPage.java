package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountsOverviewPage {

    private WebDriver driver;

    private By accountTable = By.id("accountTable");
    private By totalBalance = By.xpath("//b[contains(text(),'Total')]/parent::td/following-sibling::td | //td[contains(text(),'$')]");

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountsOverviewDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(accountTable)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getTotalBalanceText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(totalBalance)).getText().trim();
        } catch (Exception e) {
            return "N/A";
        }
    }
}
