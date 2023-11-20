package com.anhtester.Bai28_ReadExcelFile;

import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoReadExcelFile {

    @Test
    public void testGetDataFromExcelFile(){
        //Gọi hàm setExcelFile để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "Sheet1");

        //Gọi hàm getCellData để đọc data theo từng ô
        System.out.println(excelHelper.getCellData("email", 1));
        System.out.println(excelHelper.getCellData("email", 2));
        System.out.println(excelHelper.getCellData("password", 1));
        System.out.println(excelHelper.getCellData("role", 1));
        System.out.println(excelHelper.getCellData(0, 1));
    }

    @Test
    public void testSetDataToExcelFile(){
        //Gọi hàm setExcelFile để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "Sheet2");

        //Gọi hàm setCellData để ghi data vào từng ô chỉ định theo cột và dòng
        excelHelper.setCellData("anhtester@email.com", "email", 1);
        excelHelper.setCellData("123456", "password", 1);
        excelHelper.setCellData("project manager", "role", 1);
    }

}
