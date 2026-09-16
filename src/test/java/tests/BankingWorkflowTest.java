package tests;

import base.BaseTest;

import java.util.UUID;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class BankingWorkflowTest extends BaseTest {

    private static String username;
    private static String password = "password123";

    @Test(priority = 1, description = "1- Navigate to application & Register user to create valid credentials")
    public void test1_navigateToApplicationAndRegister() {
    	username = "user_" + UUID.randomUUID().toString().substring(0, 8);
    	HomePage homePage = new HomePage(getDriver());
        homePage.clickRegister();

        RegistrationPage regPage = new RegistrationPage(getDriver());
        regPage.registerUser("John", "Doe", "123 Main St", "City", "State", "12345", "9876543210", "123-45-6789", username, password);
        Assert.assertTrue(regPage.isRegistrationSuccessful(), "User registration should succeed");
    }

    @Test(priority = 2, dependsOnMethods = "test1_navigateToApplicationAndRegister", description = "2- Login with valid credentials and verify Successfully Login")
    public void test2_loginWithValidCredentials() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isLoginSuccessful(), "Login with valid credentials should succeed");
    }

    @Test(priority = 3, dependsOnMethods = "test2_loginWithValidCredentials", description = "3- Click on Accounts Overview and check the total Balance is displayed")
    public void test3_verifyAccountsOverviewTotalBalance() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAccountsOverview();

        AccountsOverviewPage accountsPage = new AccountsOverviewPage(getDriver());
        Assert.assertTrue(accountsPage.isAccountsOverviewDisplayed(), "Accounts Overview table should be displayed");

        String balance = accountsPage.getTotalBalanceText();
        System.out.println("=================================================");
        System.out.println(">>> TOTAL BALANCE DISPLAYED: " + balance);
        System.out.println("=================================================");
    }

    @Test(priority = 4, dependsOnMethods = "test3_verifyAccountsOverviewTotalBalance", description = "4- Click on Update Contact Info and Edit and update profile")
    public void test4_updateContactInformation() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickUpdateContactInfo();

        UpdateProfilePage profilePage = new UpdateProfilePage(getDriver());
        profilePage.updateAddressAndPhone("456 Updated St", "9876543210");
    }

    @Test(priority = 5, dependsOnMethods = "test4_updateContactInformation", description = "5- Verify the confirmation message 'Your updated address and phone number have been added to the system.'")
    public void test5_verifyConfirmationMessage() {
        UpdateProfilePage profilePage = new UpdateProfilePage(getDriver());
        String confirmationMsg = profilePage.getConfirmationMessageText();

        System.out.println("=================================================");
        System.out.println(">>> CONFIRMATION MESSAGE DISPLAYED: " + confirmationMsg);
        System.out.println("=================================================");

        Assert.assertTrue(confirmationMsg.toLowerCase().contains("your updated address and phone number have been added to the system"),
                "Confirmation message should match expected text! Got: '" + confirmationMsg + "'");

        HomePage homePage = new HomePage(getDriver());
        homePage.logout();
    }
}
