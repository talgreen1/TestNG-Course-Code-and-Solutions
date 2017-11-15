package testng.exercises._15_ftp_client_login_and_file_tests_dataprovider_excel.tests.file;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.excelutils.ExcelUtils;
import testng.exercises._15_ftp_client_login_and_file_tests_dataprovider_excel.tests.login.LoginParameters;
import testng.ftpclient.FTPClient;

public class FileTests {

    @BeforeClass
    public void login(){
        System.out.println("Before the very first file test - do login");
        FTPClient.login(LoginParameters.VALID_USERNAME, LoginParameters.VALID_PASSWORD);
    }

    @BeforeMethod
    public void deleteAllFiles(){
        System.out.println("Before file test - deleting all files");
        FTPClient.deleteAllFiles();
    }

    @Test(testName = "Create non existing file", description = "This test tries to create a non existing file",
    dataProvider = "fileDetailsDP")
    public void createNonExistingFile(String fileName, String fileContent){
        FTPClient.createFile(fileName, fileContent);

        // Get the file content and verify
        String actualFileContent = FTPClient.getFileContent(fileName);
        Assert.assertEquals(actualFileContent, fileContent);
    }

    @DataProvider(name = "fileDetailsDP")
    public Object[][] fileDetailsDataProvider() throws Exception {
        return ExcelUtils.getTableArray("./src/testng/exercises/_15_ftp_client_login_and_file_tests_dataprovider_excel/Parameters.xlsx", "File");
    }

    @Test(testName = "Create an existing file", description = "This test tries to create a non existing file",
    expectedExceptions = RuntimeException.class)
    public void createExistingFile(){
        FTPClient.createFile(FileParameters.FILE_NAME, FileParameters.FILE_CONTENT);
        FTPClient.createFile(FileParameters.FILE_NAME, FileParameters.FILE_CONTENT);
    }
}
