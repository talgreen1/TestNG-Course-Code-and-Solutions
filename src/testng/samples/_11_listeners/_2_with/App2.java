package testng.samples._11_listeners._2_with;

import org.testng.Assert;
import org.testng.annotations.Test;

public class App2 {


    @Test
    public void test(){
        System.out.println("App 2 - Test");
        Assert.assertEquals(true, false);
    }


}
