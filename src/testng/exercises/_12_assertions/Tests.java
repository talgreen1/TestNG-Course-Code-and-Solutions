package testng.exercises._12_assertions;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests
{
	@Test
	public void checkSeconds()
	{
		int seconds = LocalDateTime.now().getSecond();
		System.out.println("Seconds = " + seconds);
		Assert.assertEquals(seconds % 2, 0);
	}
}
