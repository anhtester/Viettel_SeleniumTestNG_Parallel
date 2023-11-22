package com.anhtester.dataprovider;

import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

    //Khai báo nơi cung cấp dữ liệu - dùng @DataProvider
    @DataProvider(name = "dataLogin", parallel = true)
    public Object[][] dataLogin() {
        return new Object[][]{
                {"admin3@example.com", "123456", "tcs 1"},
                {"admin1@example.com", "1234567", "tcs 2"},
                {"admin2@example.com", "12345678", "tcs 3"}
        };
    }

    @DataProvider(name = "dataAddCustomer")
    public Object[][] dataAddCustomer() {
        return new Object[][]{
                {"Hùng", 25, "Hà Nội"},
                {"Phương", 32, "Hồ Chí Minh"},
                {"Diệu", 36, "Hà Nội"}
        };
    }

    @DataProvider(name = "dataLoginFromExcel", parallel = true)
    public Object[][] dataLoginFromExcel() {

        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/testdata/LoginData.xlsx", "LoginData");

        System.out.println("Extract data from excel file: " + data);
        return data;
    }

    @DataProvider(name = "dataLoginFromExcelMultipleRow", parallel = false)
    public Object[][] dataLoginFromExcelMultipleRow() {

        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable("src/test/resources/testdata/LoginData.xlsx", "LoginData", 2, 3);

        System.out.println("Extract data from excel file: " + data);
        return data;
    }

}
