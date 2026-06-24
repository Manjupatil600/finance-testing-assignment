package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    // TC_01 - valid login should go to dashboard
    @Test
    public void validLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.openPage(loginUrl);
        lp.doLogin("Admin", "admin123");

        String heading = lp.getDashboardHeading();
        Assert.assertEquals(heading, "Dashboard");
    }

    // TC_03 - wrong password should show error
    @Test
    public void invalidPasswordTest() {
        LoginPage lp = new LoginPage(driver);
        lp.openPage(loginUrl);
        lp.doLogin("Admin", "wrongpass123");

        String error = lp.getErrorMessage();
        Assert.assertEquals(error, "Invalid credentials");
    }

    // TC_04 - empty username
    @Test
    public void emptyUsernameTest() {
        LoginPage lp = new LoginPage(driver);
        lp.openPage(loginUrl);
        lp.enterUsername("");
        lp.enterPassword("admin123");
        lp.clickLogin();

        Assert.assertEquals(lp.getUsernameError(), "Required");
    }

    // TC_05 - empty password
    @Test
    public void emptyPasswordTest() {
        LoginPage lp = new LoginPage(driver);
        lp.openPage(loginUrl);
        lp.enterUsername("Admin");
        lp.enterPassword("");
        lp.clickLogin();

        Assert.assertEquals(lp.getPasswordError(), "Required");
    }

    // TC_06 - both empty
    @Test
    public void bothFieldsEmptyTest() {
        LoginPage lp = new LoginPage(driver);
        lp.openPage(loginUrl);
        lp.enterUsername("");
        lp.enterPassword("");
        lp.clickLogin();

        Assert.assertEquals(lp.getUsernameError(), "Required");
        Assert.assertEquals(lp.getPasswordError(), "Required");
    }
}
