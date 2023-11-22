package com.anhtester.Bai29_DataProvider;

import com.anhtester.dataprovider.DataProviderFactory;
import com.anhtester.keywords.WebUI;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class DemoDataProvider {

    //Truyền nơi cung cấp dữ liệu vào trong test case @Test
    @Test(dataProvider = "dataLogin", dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccess(String email, String password, String message) {
        System.out.println("EMAIL: " + email);
        System.out.println("PASSWORD: " + password);
        System.out.println("MESSAGE: " + message);
        WebUI.sleep(2);
    }

    @Test(dataProvider = "dataAddCustomer", dataProviderClass = DataProviderFactory.class)
    public void testAddNewCustomer(String name, int age, String address) {
        System.out.println("HỌ TÊN: " + name);
        System.out.println("TUỔI: " + age);
        System.out.println("ĐỊA CHỈ: " + address);
    }

    @Test(dataProvider = "dataLoginFromExcel", dataProviderClass = DataProviderFactory.class)
    public void testLoginFromExcelFile(String email, String password) {
        System.out.println("EMAIL: " + email);
        System.out.println("PASSWORD: " + password);
    }

    @Test(dataProvider = "dataLoginFromExcelMultipleRow", dataProviderClass = DataProviderFactory.class)
    public void testLoginFromExcelFileMultipleRow(Hashtable<String, String> data) {
        System.out.println("EMAIL: " + data.get("email")); //email là tên cột trong file excel (dòng đầu)
        System.out.println("PASSWORD: " + data.get("password")); //password là tên cột trong file excel (dòng đầu)
    }

}
