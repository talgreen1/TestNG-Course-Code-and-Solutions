package testng.samples._12_iannotationtransformer.by_name;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Transformer implements IAnnotationTransformer {
    // Do not worry about calling this method as testNG calls it behind the scenes before EVERY method (or test).
    // It will disable single tests, not the entire suite like SkipException
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        // If we have chose not to run this test then disable it.
        if (disableMe(testMethod)) {
            annotation.setEnabled(false);
        }
    }

    // logic YOU control
    private boolean disableMe(Method testMethod) {
        if (testMethod.getName().equals("test2")) {
            return true;
        } else {
            return false;
        }

    }
}
