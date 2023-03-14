package Gun04;

import org.testng.annotations.Test;

public class _03_Groups {
    @Test(groups = {"SmokeTest"})
    void Test1(){
        System.out.println("Test 1");
    }
    @Test(groups = {"SmokeTest"})
    void Test4(){
        System.out.println("Test 4");
    }
    @Test(groups = {"Regression"})
    void Test2(){
        System.out.println("Test 2");
    }
    @Test(groups = {"Regression"})
    void Test3(){
        System.out.println("Test 3");
    }
    @Test(groups = {"Regression"})
    void Test5(){
        System.out.println("Test 5");
    }
    @Test
    void Test7(){
        System.out.println("Test 7");
    }
    @Test(groups = {"SmokeTest"})
    void Test6(){
        System.out.println("Test 6");
    }
}
