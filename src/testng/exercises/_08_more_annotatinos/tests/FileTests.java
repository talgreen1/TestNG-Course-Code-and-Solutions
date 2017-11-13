package testng.exercises._08_more_annotatinos.tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileTests
{

	@BeforeClass
	public void init()
	{
		System.out.println("\n\t In FileTests1 - Init \n");
	}

	@Test(testName="File test - test 1", description="Description of file test 1", groups = { "sanity"} )
	private void test1()
	{
		System.out.println("\t In FileTests1 - Test 1");
	}

	@Test(testName="File test - test 3", description="Description of file test 3", groups = { "sanity", "regression" })
	private void test3()
	{
		System.out.println("\t In FileTests1 - Test 3");
	}

	@Test(testName="File test - test 2", description="Description of file test 2", groups = { "regression", "ignore" })
	private void test2()
	{
		System.out.println("\t In FileTests1 - Test 2");
	}
	
	@AfterClass
	public void teardown()
	{
		System.out.println("\n\t In FileTests1 - teardown \n\n");
	}
	
	
}
