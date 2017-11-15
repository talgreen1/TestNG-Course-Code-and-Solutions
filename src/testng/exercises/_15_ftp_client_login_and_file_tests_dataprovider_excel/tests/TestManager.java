package testng.exercises._15_ftp_client_login_and_file_tests_dataprovider_excel.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import testng.ftpclient.FTPClient;
import testng.ftpclient.FTPFailMode;

public class TestManager {

    @BeforeSuite
    public void suiteSetup(){
        System.out.println("In suiteSetup - setting fail mode");
        FTPClient.setFailMode(FTPFailMode.PASS);
    }

    @AfterSuite
    public void suiteTeardown(){
        System.out.println("In suiteTeardown - deleting all files and loggin out");
        FTPClient.deleteAllFiles();
        FTPClient.logout();
    }
}
