package testng.samples._02_basic.tests.groups_a;

import org.testng.annotations.*;


public class FileTests {

    @BeforeMethod
    public void beforeAllMethods(){
        System.out.println("In before all methods");
    }

    @BeforeMethod(groups = {"sanity"})
    public void beforeSanity(){
        System.out.println("Before sanity methods");
    }

    @BeforeMethod(groups = {"regression"})
    public void beforeRegression(){
        System.out.println("Before regression methods");
    }

    @Test(groups = {"sanity"})
    private void test1() {
        System.out.println("\t In FileTests1 - Test 1");
    }

    @Test(groups = {"sanity", "regression"})
    private void test2() {
        System.out.println("\t In FileTests1 - Test 2");
    }

    @Test(groups = {"regression"})
    private void test3() {
        System.out.println("\t In FileTests1 - Test 3");
    }



}
