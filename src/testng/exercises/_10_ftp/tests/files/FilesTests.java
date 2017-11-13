package testng.exercises._10_ftp.tests.files;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testng.exercises._10_ftp.tests.login.LoginParameters;
import testng.ftpclient.FTPClient;

/**
 * This class contains all the tests of the FTP Client files related features.
 * @author Tal Green
 *
 */
public class FilesTests
{

	/**
	 * This method performs login to the FTP client. It's a '@BeforeClass' method - will be executed
	 * once before the first test in this class.
	 */
	@BeforeClass
	public void login()
	{
		FTPClient.login(LoginParameters.VALID_USERNAME, LoginParameters.VALID_PASSWORD);
	}

	@Test(testName="Create File Test", description="This test check the file creation flow")
	public void createFileTest()
	{
		FTPClient.createFile(FilesParameters.FILE_NAME, FilesParameters.FILE_CONTENT);
		String fileContent = FTPClient.getFileContent(FilesParameters.FILE_NAME);

		// Need to find a way to validate the file content
	}
}
