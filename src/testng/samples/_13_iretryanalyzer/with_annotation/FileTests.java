package testng.samples._13_iretryanalyzer.with_annotation;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FileTests
{

	private static int failCount = 0;
	public static boolean isNeedToFail(){
		if (failCount<3){
			failCount++;;
			return true;
		}
		return false;
	}

	@BeforeClass
	public void init()
	{
		System.out.println("\n\t In FileTests1 - Init \n");
	}
	
	@Test(retryAnalyzer = Retry3Times.class)
	private void test1()
	{
		System.out.println("\t In FileTests1 - Test 1");
		if (isNeedToFail()){
			Assert.assertTrue(false);
		}
	}
	
	
	@Test
	private void test3()
	{
		System.out.println("\t In FileTests1 - Test 3");
	}
	
	@Test(retryAnalyzer = Retry3Times.class)
	private void test2()
	{
		System.out.println("\t In FileTests1 - Test 2");
		Assert.assertTrue(false);
	}
	
	@AfterClass
	public void teardown()
	{
		System.out.println("\n\t In FileTests1 - teardown \n\n");
	}
	
	
}
