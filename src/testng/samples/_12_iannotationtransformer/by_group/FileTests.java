package testng.samples._12_iannotationtransformer.by_group;

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
	
	@Test(groups = {"sanity"})
	private void test1()
	{
		System.out.println("\t In FileTests1 - Test 1");
	}
	
	
	@Test(groups = {"sanity", "regression"})
	private void test3()
	{
		System.out.println("\t In FileTests1 - Test 3");
	}
	
	@Test(groups = {"regression"})
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
