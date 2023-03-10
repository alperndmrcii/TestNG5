package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {
/*
    @BeforeClass      -->   Class ın başında çalışacak   (driver işlemleri)
    @BeforeMethod  -->   Her metoddan(test metodları) önce çalışacak
    @Test      -->   testlerin çalıştığı metodlar
    @Test      -->   testlerin çalıştığı metodlar
    @AfterMethod   -->   Her metoddan sonra çalışacak
    @AfterClass       -->   Class ın çalışmasının sonunda çalışacak (driver kapat)
     */
    @BeforeClass
    public void beforeClass() {
        System.out.println("before class çalıştı");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class çalıştı");
    }

    @BeforeMethod
    public void beforeMethof() {
        System.out.println("before method çalıştı");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after method çalıştı");
    }

    @Test
    public void test1() {
        System.out.println("test1 çalıştı");
    }

    @Test
    public void test2() {
        System.out.println("test2 çalıştı");
    }

}
