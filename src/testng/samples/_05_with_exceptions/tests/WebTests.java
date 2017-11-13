package testng.samples._05_with_exceptions.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTests
{
	@BeforeClass
	public void init()
	{
		System.out.println("\n\t In WebTests - Init\n");
		// Open browser
		
	}
	
	@BeforeMethod
	private void login()
	{	
		System.out.println("\t\t login");
	}
	
//	public void executeTests()
//	{
//		test1();
//		test2();
//		test3();
//	}
	
	@Test(expectedExceptions = NullPointerException.class)
	private void test1()
	{
		//login();
		System.out.println("\t In WebTests - Test 1");
		throw new NullPointerException();
	}
	
	@Test
	private void test2()
	{
		//login();
		System.out.println("\t In WebTests - Test 2");
	}
	
	@Test
	private void test3()
	{
		//login();
		System.out.println("\t In WebTests - Test 3");
	}
	
	@AfterClass
	public void teardown()
	{
		System.out.println("\n\t In WebTests - teardown \n\n");
	}
}
