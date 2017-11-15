package testng.samples._11_listeners._1_without;

import org.testng.annotations.BeforeSuite;

public class GlobalInit {

    @BeforeSuite
    public void globalInit(){
        System.out.println("Global Init");
    }

}
