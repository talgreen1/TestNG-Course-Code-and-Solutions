package testng.samples._14_IMethodInterceptor;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestOrderRandomizer implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        long seed = System.nanoTime();
        System.out.println(String.format("Randomizing order of tests with seed: %s", seed));
        Collections.shuffle(methods, new Random(seed));

        return methods;
    }
}
