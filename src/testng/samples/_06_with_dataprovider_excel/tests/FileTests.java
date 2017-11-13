package testng.samples._06_with_dataprovider_excel.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testng.excelutils.ExcelUtils;



public class FileTests
{
	
	
	
	
	@BeforeClass
	public void init()
	{
		System.out.println("\n\t In FileTests1 - Init \n");
	}
	
	@Test (dataProvider="fileParametersDP")
	private void test1(String testName, String fileName, String fileContent)
	{
		System.out.println("\t In FileTests1 - Test 1");
		System.out.println("\t   Test name = " + testName);
		System.out.println("\t   File name = " + fileName);
		System.out.println("\t   File content = " + fileContent);
	}
	
	@DataProvider(name="fileParametersDP")
	private Object [][] fileParametersDP() throws Exception
	{
		return ExcelUtils.getTableArray("./src/testng/_06_with_dataprovider_excel/fileParameters.xlsx", "File");
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
