package testng.exercises._09_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

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
