package testng.exercises._16_ftp.dataprovider_excel.files;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testng.excelutils.ExcelUtils;
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
	public Object[][] getFileParameters() throws Exception
	{
		return ExcelUtils.getTableArray("./src/testng/exercises/_16_ftp/dataprovider_excel/ParamsClass.xlsx", "File");
	}
}
