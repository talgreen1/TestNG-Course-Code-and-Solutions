package testng.exercises._13_ftp_client_login_and_file_tests_parameters.tests.file;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testng.exercises._13_ftp_client_login_and_file_tests_parameters.tests.login.LoginParameters;
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

    @Test(testName = "Create non existing file", description = "This test tries to create a non existing file")
    @Parameters({"fileName", "fileContent"})
    public void createNonExistingFile(String fileName, String fileContent){
        FTPClient.createFile(fileName, fileContent);

        // Get the file content and verify
        String actualFileContent = FTPClient.getFileContent(fileName);
        Assert.assertEquals(actualFileContent, fileContent);
    }

    @Test(testName = "Create an existing file", description = "This test tries to create a non existing file",
    expectedExceptions = RuntimeException.class)
    @Parameters({"fileName", "fileContent"})
    public void createExistingFile(String fileName, String fileContent){
        FTPClient.createFile(fileName, fileContent);
        FTPClient.createFile(fileName, fileContent);
    }
}
