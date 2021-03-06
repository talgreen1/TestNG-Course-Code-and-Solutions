package testng.samples._04_with_dataprovider.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class FileTests
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
		System.out.println("\n\t In FileTests1 - Init \n");
	}
	
	@Test (dataProvider="fileParametersDP")
	private void test1(String fileName, String fileContent)
	{
		System.out.println("\t In FileTests1 - Test 1");
		System.out.println("\t   File name = " + fileName);
		System.out.println("\t   File content = " + fileContent);
	}
	
	@DataProvider(name="fileParametersDP")
	private Object [][] fileParametersDP()
	{
		return new Object [][] {{"file1.txt", "content of file 1"}, {"file2.txtx", "content of file 2"}};
	}

	@Test
	private void test3()
	{
		System.out.println("\t In FileTests1 - Test 3");
	}
	
	@Test
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
