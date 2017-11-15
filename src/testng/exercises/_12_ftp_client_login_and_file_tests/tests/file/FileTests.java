package testng.exercises._12_ftp_client_login_and_file_tests.tests.file;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testng.exercises._12_ftp_client_login_and_file_tests.tests.login.LoginParameters;
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
    public void createNonExistingFile(){
        FTPClient.createFile(FileParameters.FILE_NAME, FileParameters.FILE_CONTENT);

        // Get the file content and verify
        String fileContent = FTPClient.getFileContent(FileParameters.FILE_NAME);
        Assert.assertEquals(fileContent, FileParameters.FILE_CONTENT);
    }

    @Test(testName = "Create an existing file", description = "This test tries to create a non existing file",
    expectedExceptions = RuntimeException.class)
    public void createExistingFile(){
        FTPClient.createFile(FileParameters.FILE_NAME, FileParameters.FILE_CONTENT);
        FTPClient.createFile(FileParameters.FILE_NAME, FileParameters.FILE_CONTENT);
    }
}
