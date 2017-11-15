package testng.exercises._14_ftp_client_login_and_file_tests_dataprovider.tests.file;

import org.testng.Assert;
import org.testng.annotations.*;
import testng.exercises._14_ftp_client_login_and_file_tests_dataprovider.tests.login.LoginParameters;
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
    public Object[][] fileDetailsDataProvider() {
        return new Object[][]{
                {"c:/temp/f.txt", "content1"},
                {"d:/file.dat", "content2"}
        };
    }

    @Test(testName = "Create an existing file", description = "This test tries to create a non existing file",
    expectedExceptions = RuntimeException.class)
    public void createExistingFile(){
        FTPClient.createFile(FileParameters.FILE_NAME, FileParameters.FILE_CONTENT);
        FTPClient.createFile(FileParameters.FILE_NAME, FileParameters.FILE_CONTENT);
    }
}
