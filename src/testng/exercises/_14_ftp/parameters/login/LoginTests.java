package testng.exercises._14_ftp.parameters.login;

import org.testng.Assert;
import org.testng.annotations.Parameters;
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
	@Parameters({"username", "password"})
	@Test(testName = "Valid Login Test", description = "This test checks the valid login process")
	public void validLoginTest(String username, String password)
	{
		FTPLoginResult loginResult = FTPClient.login(username, password);

		Assert.assertEquals(loginResult, FTPLoginResult.LOGIN_OK);
	}

	/**
	 * Test invalid login flow
	 */
	@Parameters({"invalidUsername", "invalidPassword"})
	@Test(testName = "Invalid Login Test", description = "This test checks the invalid login process")
	public void invalidLoginTest(String username, String password)
	{
		FTPLoginResult loginResult = FTPClient.login(username, password);

		Assert.assertEquals(loginResult, FTPLoginResult.LOGIN_FAIL);
	}
}
