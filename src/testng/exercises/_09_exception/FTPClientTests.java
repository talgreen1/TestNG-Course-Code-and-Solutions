package testng.exercises._09_exception;

import org.testng.annotations.Test;

import testng.ftpclient.FTPClient;

public class FTPClientTests
{
	@Test (expectedExceptions  = RuntimeException.class)
	public void createFileWithoutLogin()
	{
		//FTPClient.login("admin", "admin");
		FTPClient.createFile("c:/temp/file.txt", "hello");
	}
}
