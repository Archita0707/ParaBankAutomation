package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExcelUtils;

public class LoginDataDrivenTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return ExcelUtils.getSheetData(ConfigReader.get("testDataFile"), "LoginData");
    }

    @Test(dataProvider = "loginData", description = "Data-driven login test using Excel dataset")
    public void testLoginWithExcelData(String username, String password, String expectedResult) {
        HomePage homePage = new HomePage(getDriver());
        if (homePage.isLoginSuccessful()) {
            homePage.logout();
        }
        getDriver().get(ConfigReader.get("url"));

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username != null ? username : "", password != null ? password : "");

        boolean isLogged = homePage.isLoginSuccessful();

        if ("invalid".equalsIgnoreCase(expectedResult)) {
            Assert.assertFalse(isLogged, "Login should fail for invalid credentials: username='" + username + "'");
        } else if ("valid".equalsIgnoreCase(expectedResult)) {
            Assert.assertTrue(isLogged, "Login should succeed for valid credentials: username='" + username + "'");
            homePage.logout();
        }
    }
}
