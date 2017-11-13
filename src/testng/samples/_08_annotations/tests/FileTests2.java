package testng.samples._08_annotations.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class FileTests2
{



//	public void executeTests()
//	{
//		test1("c:/temp/file1.txt", "hello world");  // sanity
//		test1("c:/temp/file2.txt", "hello world");  // sanity
//		test2();  // regression
//		test3();  // Sanity + regression
//	}

	@BeforeClass
	public void init()
	{
		System.out.println("\n\t In FileTests2 - Init \n");
	}

	@Test
	private void test1()
	{
		System.out.println("\t In FileTests2 - Test 1");
	}


	@Test
	private void test3()
	{
		System.out.println("\t In FileTests2 - Test 3");
	}

	@Test
	private void test2()
	{
		System.out.println("\t In FileTests2 - Test 2");
	}

	@AfterClass
	public void teardown()
	{
		System.out.println("\n\t In FileTests2 - teardown \n\n");
	}

	@AfterClass
	public void testMethod()
	{
		System.out.println("****************  In test method File - Before Suite******************");
		throw new RuntimeException();


	}

}
