package testng.ftpclient;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class FTPClient
{
	private static boolean isLogin = false;
	private static FTPFailMode failMode = FTPFailMode.PASS;

	private static Map<String, String> filesMap = new HashMap<String, String>();

	/**
	 * Perform login to the FTP client.<br>
	 * Valid username & password: admin/admin
	 * @param userName	The username. Valid username: admin
	 * @param password	The password. Valid password: admin
	 */
	public static FTPLoginResult login(String userName, String password)
	{

		checkFail();
		if ((!userName.equals("admin") || !password.equals("admin")))
		{
			isLogin = false;
			return FTPLoginResult.LOGIN_FAIL;
		} else
		{
			isLogin = true;
			return FTPLoginResult.LOGIN_OK;
		}
	}
	
	/**
	 * This method perform logout
	 */
	public static void logout()
	{
		checkFail();
		
		if (!isLogin)
			throw new RuntimeException("You are not logged in");
		
		isLogin = false;
	}
	
	/**
	 * Sets the fail mode of the FTP client. 
	 * In order to simulate errors in your tests you can use 3 modes:<br><br>
	 * {@link FTPFailMode#PASS}		All methods will pass<br>
	 * {@link FTPFailMode#FAIL}		All methods will fail<br>
	 * {@link FTPFailMode#RANDOM_LOW}	Methods will fail randomly. The fail odds are low<br>
	 * {@link FTPFailMode#RANDOM_MED}	Methods will fail randomly. The fail odds are medium<br>
	 * {@link FTPFailMode#RANDOM_HIGH}	Methods will fail randomly. The fail odds are high<br>
	 * @param failMode	The expected fail mode
	 */
	public static void setFailMode(FTPFailMode newFailMode)
	{
		failMode = newFailMode;
	}

	public static FTPFailMode getFailMode()
	{
		return failMode;
	}

	/**
	 * This method creates new file in the remote machine.
	 * If the file already exists, runtime exception will be throw.
	 * @param filePath		The full file path & name to be created
	 * @param fileContent	The file content
	 */
	public static void createFile(String filePath, String fileContent)
	{
		checkFail();
		checkLogin();

		if (filesMap.containsKey(filePath))
			throw new RuntimeException("The file " + filePath + " already exists. Can not create it again.");

		filesMap.put(filePath, fileContent);
	}

	/**
	 * This method deletes all the files
	 */
	public static void deleteAllFiles()
	{
		checkFail();
		
		filesMap.clear();
	}
	
	/**
	 * This method returns the content of a file.
	 * If the file does not exists, a runtime exception will be thrown.
	 * @param filePath	The file path to return the content of
	 * @return	The content of the file
	 */
	public static String getFileContent(String filePath)
	{
		checkFail();
		checkLogin();

		if (filesMap.containsKey(filePath))
			return filesMap.get(filePath);
		else
			throw new RuntimeException("The file " + filePath + " does not exists.");

	}

	private static void checkLogin()
	{
		if (!isLogin)
			throw new RuntimeException("You are note logged in. Please login.");
	}

	private static void checkFail()
	{
		Random rnd = new Random();

		switch (failMode)
		{
		case PASS:
			break;
		case FAIL:
			throw new RuntimeException("Somthing went wrong...");
		case RANDOM_LOW:
			if (rnd.nextBoolean() && rnd.nextBoolean() && rnd.nextBoolean())
			{
				throw new RuntimeException("Somthing went wrong...");
			}
			break;
		case RANDOM_MED:
			if (rnd.nextBoolean())
			{
				throw new RuntimeException("Somthing went wrong...");
			}
			break;
		case RANDOM_HIGH:
			if (rnd.nextBoolean() || rnd.nextBoolean())
			{
				throw new RuntimeException("Somthing went wrong...");
			}
			break;

		}

	}
}
