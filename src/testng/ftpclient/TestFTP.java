package testng.ftpclient;

import java.time.LocalDateTime;

public class TestFTP
{

	public static void main(String[] args)
	{
		
		System.out.println(LocalDateTime.now().getSecond());
		FTPClient.setFailMode(FTPFailMode.RANDOM_HIGH);
//		System.out.println(FTPClient.login("a", "a"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		System.out.println(FTPClient.login("admin", "admin"));
		
		
		FTPClient.createFile("c://temp//file1.txt", "Content of file1.txt");
		FTPClient.createFile("c://temp//file2.txt", "Content of file222.txt");
		
		
		System.out.println(FTPClient.getFileContent("c://temp//file1.txt"));
		System.out.println(FTPClient.getFileContent("c://temp//file2.txt"));

	}

}
