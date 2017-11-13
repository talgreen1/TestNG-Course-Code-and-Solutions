package testng.exercises._05_.tests;

import org.testng.annotations.Test;

public class WebTests
{
	public void init()
	{
		System.out.println("\n\t In WebTests - Init\n");
		// Open browser
		
	}
	
	private void login()
	{	
		System.out.println("\t\t login");
	}
	
	public void executeTests()
	{
		test1();
		test2();
		test3();
	}

	@Test
	private void test1()
	{
		login();
		System.out.println("\t In WebTests - Test 1");
	}

	@Test
	private void test2()
	{
		login();
		System.out.println("\t In WebTests - Test 2");
	}

	@Test
	private void test3()
	{
		login();
		System.out.println("\t In WebTests - Test 3");
	}
	
	public void teardown()
	{
		System.out.println("\n\t In WebTests - teardown \n\n");
	}
}
