package testng.exercises._13_ftp.tests.files;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

	@BeforeMethod
	public void deleteAllFiles()
	{
		System.out.println("Deleting all files");
		FTPClient.deleteAllFiles();
	}

	@Test(testName="Create File Test", description="This test check the file creation flow")
	public void createFileTest()
	{
		FTPClient.createFile(FilesParameters.FILE_NAME, FilesParameters.FILE_CONTENT);
		String fileContent = FTPClient.getFileContent(FilesParameters.FILE_NAME);

		Assert.assertEquals(fileContent, FilesParameters.FILE_CONTENT);

	}
}
