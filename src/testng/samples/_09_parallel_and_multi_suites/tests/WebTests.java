package testng.samples._09_parallel_and_multi_suites.tests;


import org.testng.annotations.Test;

public class WebTests
{
	private static final int COUNT = 5;
	private static final int TIME_TO_WAIT = 1000;
	@Test
	public void test1()
	{
		for (int i = 0; i < COUNT; i++)
		{
			System.out.println("Web Test 1: " + i + "/" + COUNT );
			try
			{
				Thread.sleep(TIME_TO_WAIT);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test2()
	{
		for (int i = 0; i < COUNT; i++)
		{
			System.out.println("Web Test 2: " + i + "/" + COUNT );
			try
			{
				Thread.sleep(TIME_TO_WAIT);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test3()
	{
		for (int i = 0; i < COUNT; i++)
		{
			System.out.println("Web Test 3: " + i + "/" + COUNT );
			try
			{
				Thread.sleep(TIME_TO_WAIT);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
