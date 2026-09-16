package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUp(String browser) {

        boolean headless = Boolean.parseBoolean(
                ConfigReader.get("headless")
        );

        WebDriver webDriver;

        if ("firefox".equalsIgnoreCase(browser)) {

            FirefoxOptions options = new FirefoxOptions();

            if (headless) {
                options.addArguments("-headless");
            }

            webDriver = new FirefoxDriver(options);

        } else if ("edge".equalsIgnoreCase(browser)) {

            EdgeOptions options = new EdgeOptions();

            if (headless) {
                options.addArguments("--headless=new");
            }

            webDriver = new EdgeDriver(options);

        } else {

            ChromeOptions options = new ChromeOptions();

            if (headless) {
                options.addArguments("--headless=new");
            }

            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--incognito");
            options.addArguments(
                    "--no-sandbox",
                    "--disable-dev-shm-usage"
            );

            webDriver = new ChromeDriver(options);
        }

        driver.set(webDriver);

        getDriver().manage().window().maximize();

        int waitSec = ConfigReader.getInt("implicitWait");

        getDriver().manage().timeouts().implicitlyWait(
                Duration.ofSeconds(waitSec > 0 ? waitSec : 2)
        );

        getDriver().get(ConfigReader.get("url"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {

        WebDriver webDriver = driver.get();

        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
    }
}