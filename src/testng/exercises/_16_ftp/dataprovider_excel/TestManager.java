package testng.exercises._16_ftp.dataprovider_excel;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import testng.exercises._10_ftp.tests.login.LoginParameters;
import testng.ftpclient.FTPClient;
import testng.ftpclient.FTPFailMode;

public class TestManager
{
	@BeforeSuite
	public void initSuite()
	{
		System.out.println("in initSuite");
		FTPClient.login(LoginParameters.VALID_USERNAME, LoginParameters.VALID_PASSWORD);
//		FTPClient.setFailMode(FTPFailMode.RANDOM_LOW);
	}

	@AfterSuite
	public void endSuite()
	{
		System.out.println("in endSuite");
		FTPClient.logout();
	}
}
