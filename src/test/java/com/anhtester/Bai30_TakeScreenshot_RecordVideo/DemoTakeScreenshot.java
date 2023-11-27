package com.anhtester.Bai30_TakeScreenshot_RecordVideo;

import com.anhtester.Bai26_ParallelExecutionPOM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.drivers.DriverManager;
import com.anhtester.helpers.CaptureHelper;
import com.anhtester.helpers.ExcelHelper;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

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
                excelHelper.getCellData("email", 1),
                excelHelper.getCellData("password", 1)
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
                excelHelper.getCellData("email", 2),
                excelHelper.getCellData("password", 2)
        );

        loginPage.verifyLoginSuccess();

    }

}
