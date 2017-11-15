package testng.exercises._11_ftp_login_tests_create_file_without_login.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import testng.ftpclient.FTPClient;
import testng.ftpclient.FTPLoginResult;

/**
 * This class contains all the tests of the FTP Client login feature.
 *
 * @author Tal Green
 */
public class LoginTests {
    /**
     * Test valid login flow.
     */
    @Test(testName = "Valid Login Test", description = "This test checks the valid login process using valid credentials")
    public void validLoginTest() {
        FTPLoginResult loginResult = FTPClient.login(LoginParameters.VALID_USERNAME, LoginParameters.VALID_PASSWORD);

        Assert.assertEquals(loginResult, FTPLoginResult.LOGIN_OK);
    }

    /**
     * Test invalid login flow
     */
    @Test(testName = "Invalid Login Test", description = "This test checks the invalid login process")
    public void invalidLoginTest() {
        FTPLoginResult loginResult = FTPClient.login(LoginParameters.INVALID_USERNAME, LoginParameters.INVALID_PASSWORD);

        Assert.assertEquals(loginResult, FTPLoginResult.LOGIN_FAIL);
    }

    /**
     * Test creating a file _1_without login - should get an exception.
     */
    @Test(testName = "Create file _1_without login", description = "This test tries to create a " +
            "file _1_without login - should get an exception",
    expectedExceptions = RuntimeException.class)
    public void createFileWithoutLoginTest() {
        FTPClient.logout();

        FTPClient.createFile(LoginParameters.FILE_NAME, "");
    }
}
