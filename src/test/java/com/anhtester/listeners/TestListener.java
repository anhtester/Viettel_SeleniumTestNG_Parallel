package com.anhtester.listeners;

import com.anhtester.helpers.CaptureHelper;
import com.anhtester.helpers.PropertiesHelper;
import com.anhtester.utils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext result) {
        PropertiesHelper.loadAllFiles();
    }

    @Override
    public void onFinish(ITestContext result) {
    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("################");
        LogUtils.info("*********" + result.getName()+"*********");
        CaptureHelper.startRecord(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("==> " + result.getName() + " is successfully.");
        //CaptureHelper.takeScreenshot(arg0.getName());

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("==> " + result.getName() + " is FAIL.");
        CaptureHelper.takeScreenshot(result.getName());

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.warn("*********" + result.getName()+" is SKIPPED *********");

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LogUtils.info("onTestFailedButWithinSuccessPercentage: " + result.getName());
    }

}
