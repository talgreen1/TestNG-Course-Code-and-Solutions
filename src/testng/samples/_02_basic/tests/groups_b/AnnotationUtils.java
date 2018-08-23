package testng.samples._02_basic.tests.groups_b;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AnnotationUtils {

    public static boolean isMethodBelongsToGroup(Method method, String theGroup){
        Test annotation = method.getAnnotation(Test.class);
        for (String group: annotation.groups()){
            if (group.equals(theGroup)) {
                return true;
            }
        }
        return false;
    }
}
