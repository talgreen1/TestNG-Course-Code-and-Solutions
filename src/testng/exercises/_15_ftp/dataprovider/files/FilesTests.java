package testng.exercises._15_ftp.dataprovider.files;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
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

	@Test(testName = "Create File Test", description = "This test check the file creation flow", dataProvider="getFileParameters")
	public void createFileTest(String fileName, String fileContent)
	{
		FTPClient.createFile(fileName, fileContent);
		String newFileContent = FTPClient.getFileContent(fileName);

		Assert.assertEquals(newFileContent, fileContent);
	}

	@DataProvider
	public Object[][] getFileParameters()
	{
		return new Object[][] { { "c:/temp/file1.txt", "content 1" },
								{ "c:/temp/file2.txt", "content 2" },
								{ "c:/temp/file3.txt", "content 3" } };
	}
}
