package testng.ftpclient;

/**
 * This enum represent the fail mode of the FTP client.
 * You can use it in order to simulate fails during your tests.
 * @author Tal Green
 *
 */
public enum FTPFailMode
{
	/**
	 * In this mode - all FTP methods will pass
	 */
	PASS, 
	
	/**
	 * In this mode - all FTP methods will fail
	 */
	FAIL, 
	
	/**
	 * In this mode - the FTP methods will fail randomly. The fail odds are low.
	 */
	RANDOM_LOW,
	
	/**
	 * In this mode - the FTP methods will fail randomly. The fail odds are medium.
	 */
	RANDOM_MED,
	
	/**
	 * In this mode - the FTP methods will fail randomly. The fail odds are high.
	 */
	RANDOM_HIGH
}
