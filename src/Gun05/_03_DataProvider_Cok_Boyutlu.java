package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvider_Cok_Boyutlu {


    @Test(dataProvider = "UserData")
    void UserNameTest(String username, String password) {
        System.out.println("user = " + username + " " + password);
    }

    @DataProvider
    public Object[][] UserData() {
        Object[][] data =
                {
                        {"Nurhayat", "122333"},

                        {"Alper", "ererer"},

                        {"Uğur", "ererer3343"},

                        {"Hakan", "sdsdsd"}
                };
        return data;
    }
}