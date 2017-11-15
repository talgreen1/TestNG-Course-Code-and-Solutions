package testng.samples._10_dependencies.test_order;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class App {

    @BeforeClass
    public void classSetup(){
        System.out.println("Before class");
//        throw new AssertionError();
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
//        throw new AssertionError();
    }

    @Test(priority = 2)
    public void test1(){
        System.out.println("Test 1");
//        throw new AssertionError();
    }

    @Test(priority = 1)
    public void test2(){
        System.out.println("Test 2");
//        throw new AssertionError();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
//        throw new AssertionError();
    }

}
