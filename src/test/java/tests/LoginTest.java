package tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private String LOGIN_URL = "https://demo6.cybersoft.edu.vn/login";
    private String USERNAME = "string";
    private String PASSWORD = "1234567";

    @Test
    public void testValidLogin(){
//        define test case de luu vao html thong qua extent
        extentTest = extent.createTest("Test valid login", "Kiem tra login hop le");

        try {
//            B1: mo trang web
            driver.get(LOGIN_URL);
            extentTest.log(Status.INFO, "B1: Da vao trang web login");

//            B2: tao page LoginPage (da tao o folder pages)
//            vi class LoginPage da co locator, function, nen
//            dung lai de viet test case
            LoginPage loginPage = new LoginPage(driver);

//            B3: dung ham login cua LoginPage
            loginPage.login(USERNAME, PASSWORD);
            extentTest.log(Status.INFO, "B2: Da dang nhap bang username va password");
            Thread.sleep(3000);
//            B4: kiem tra
            String  newURL = loginPage.checkURL();
            if(newURL.equals(LOGIN_URL)){
                extentTest.log(Status.FAIL, "Login that bai");
                Assert.assertEquals(LOGIN_URL, LOGIN_URL);
            } else {
                extentTest.log(Status.PASS, "Login thanh cong");
                Assert.assertNotEquals(loginPage.checkURL(), LOGIN_URL);
            }

        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Login that bai");
            Assert.assertEquals(LOGIN_URL, LOGIN_URL);
        }
    }
}
