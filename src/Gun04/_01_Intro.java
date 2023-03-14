package Gun04;

import org.testng.annotations.*;

public class _01_Intro {
    @BeforeSuite
    void bSuite(){
        System.out.println("Before Suite");
    }

    @BeforeGroups
    void bGroups()
    {
        System.out.println("Before Groups");
    }

    @BeforeClass
    void Bclass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    void Bmethod() {
        System.out.println("Before Method");
    }

    @Test
    void Intro1_Test1() {
        System.out.println("Intro1 -> Test1 ");
    }

    @Test
    void Intro1_Test2() {
        System.out.println("Intro1 -> Test2 ");
    }

    @AfterMethod
    void Amethod() {
        System.out.println("After Method");
    }

    @AfterClass
    void aClass() {
        System.out.println("After Class");
    }
    @AfterGroups
    void aGroups(){
        System.out.println("After Groups");
    }
    @AfterSuite
    void aSuite(){
        System.out.println("After Suite");
    }
}
