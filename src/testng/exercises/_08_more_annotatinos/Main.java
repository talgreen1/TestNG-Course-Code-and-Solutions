package testng.exercises._08_more_annotatinos;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import testng.exercises._05_.tests.FileTests;
import testng.exercises._05_.tests.WebTests;

/**
 * Hello world!
 *
 */
public class Main
{
	public static void main(String[] args)
	{

		// Init the test suite - run once before the very first test
		initTestSuite();

		// Create instance of the file tests
		FileTests fileTests = new FileTests();

		// Start the file test life cycle - init, execute all tests and teardown 
		fileTests.init();
		fileTests.executeTests();
		fileTests.teardown();

		// Create instance of the web tests
		WebTests webTests = new WebTests();

		// Start the file test life cycle - init, execute all tests and teardown 
		webTests.init();
		webTests.executeTests();
		webTests.teardown();

		suiteTeardown();
	}

	@BeforeSuite
	public static void initTestSuite()
	{
		System.out.println("In init test suite");
	}

	@AfterSuite
	public static void suiteTeardown()
	{
		System.out.println("In suite teardown");
	}
}
