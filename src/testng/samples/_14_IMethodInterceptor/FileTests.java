package testng.samples._14_IMethodInterceptor;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testng.samples._13_iretryanalyzer.with_annotation.Retry3Times;


public class FileTests {


    @BeforeClass
    public void init() {
        System.out.println("\n\t In FileTests1 - Init \n");
    }

    @BeforeMethod
    private void before(){
        System.out.println("In before method");
    }

    @Test()
    private void test1() {
        System.out.println("\t In FileTests1 - Test 1");
    }



    @Test(dependsOnMethods = {"test1"})
    private void test2() {
        System.out.println("\t In FileTests1 - Test 2");

    }
    @Test()
    private void test3() {
        System.out.println("\t In FileTests1 - Test 3");
    }

    @Test()
    private void test4() {
        System.out.println("\t In FileTests1 - Test 4");
    }

    @AfterClass
    public void teardown() {
        System.out.println("\n\t In FileTests1 - teardown \n\n");
    }


}
