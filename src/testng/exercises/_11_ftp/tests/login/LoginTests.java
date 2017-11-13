package testng.exercises._11_ftp.tests.login;

import org.testng.annotations.Test;

import testng.ftpclient.FTPClient;
import testng.ftpclient.FTPLoginResult;

/**
 * This class contains all the tests of the FTP Client login feature.
 * @author Tal Green
 *
 */
public class LoginTests
{
	/**
	 * Test valid login flow.
	 */
	@Test(testName = "Valid Login Test", description = "This test checks the valid login process")
	public void validLoginTest()
	{
		FTPLoginResult loginResult = FTPClient.login(LoginParameters.VALID_USERNAME, LoginParameters.VALID_PASSWORD);

		// Need to find a way to check that loginResult is FTPLoginResult.LOGIN_OK
	}

	/**
	 * Test invalid login flow
	 */
	@Test(testName = "Invalid Login Test", description = "This test checks the invalid login process")
	public void invalidLoginTest()
	{
		FTPLoginResult loginResult = FTPClient.login(LoginParameters.INVALID_USERNAME, LoginParameters.INVALID_PASSWORD);

		// Need to find a way to check that loginResult is FTPLoginResult.LOGIN_FAIL.
	}
}
