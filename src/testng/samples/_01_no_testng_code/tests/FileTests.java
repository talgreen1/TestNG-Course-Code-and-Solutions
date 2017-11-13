package testng.samples._01_no_testng_code.tests;


public class FileTests
{



	public void executeTests()
	{
		test1("c:/temp/file1.txt", "hello world");  // sanity
		test1("c:/temp/file2.txt", "hello world");  // sanity
		test2();  // regression
		test3();  // Sanity + regression
	}

	public void init()
	{
		System.out.println("\n\t In FileTests1 - Init \n");
	}

	private void test1(String fileName, String fileContent)
	{
		System.out.println("\t In FileTests1 - Test 1");
		System.out.println("\t   File name = " + fileName);
		System.out.println("\t   File content = " + fileContent);
	}

	private void test3()
	{
		System.out.println("\t In FileTests1 - Test 3");
	}

	private void test2()
	{
		System.out.println("\t In FileTests1 - Test 2");
	}

	public void teardown()
	{
		System.out.println("\n\t In FileTests1 - teardown \n\n");
	}


}
