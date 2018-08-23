package testng.samples._02_basic.tests.groups_b;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class FileTests {

    @BeforeMethod
    public void beforeAllMethods(){
        System.out.println("In before all methods");
    }

    @BeforeMethod()
    public void beforeSanity(Method method){

        if (!AnnotationUtils.isMethodBelongsToGroup(method, "sanity")){
            return;
        }
        System.out.println("Before sanity methods");
    }

    @BeforeMethod()
    public void beforeRegression(Method method){

        if (!AnnotationUtils.isMethodBelongsToGroup(method, "regression")){
            return;
        }
        System.out.println("Before regression methods");
    }
//
//    @BeforeMethod()
//    public void beforeRegression(){
//        System.out.println("Before regression methods");
//    }

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
