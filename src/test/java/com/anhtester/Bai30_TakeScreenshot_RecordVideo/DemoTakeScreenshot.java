package com.anhtester.Bai30_TakeScreenshot_RecordVideo;

import com.anhtester.Bai26_ParallelExecutionPOM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.helpers.CaptureHelper;
import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoTakeScreenshot extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        System.out.println("=====testLoginCRM_Success=====");
        CaptureHelper.startRecord("testLoginCRM_Success");

        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "LoginSuccess");

        loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );

        //CaptureHelper.takeScreenshot("testLoginCRM_Success");
        //WebUI.sleep(2);
        //CaptureHelper.stopRecord();

        loginPage.verifyLoginSuccess();

    }

    @Test
    public void testLoginCRM_Fail() {
        System.out.println("=====testLoginCRM_Success=====");
        CaptureHelper.startRecord("testLoginCRM_Fail");

        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "LoginSuccess");

        loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 2),
                excelHelper.getCellData("PASSWORD", 2)
        );

        loginPage.verifyLoginSuccess();

    }

}
