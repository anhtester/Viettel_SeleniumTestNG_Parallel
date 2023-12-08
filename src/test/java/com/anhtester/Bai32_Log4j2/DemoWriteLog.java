package com.anhtester.Bai32_Log4j2;

import com.anhtester.utils.LogUtils;
import org.testng.annotations.Test;

public class DemoWriteLog {
    @Test
    public void testWriteLogToFile1(){
        LogUtils.info("Đây là log thứ 1");
    }

    @Test
    public void testWriteLogToFile2(){
        LogUtils.info("Đây là log thứ 2");
    }

    @Test
    public void testWriteLogToFile3(){
        LogUtils.info("Đây là log thứ 3");
    }

    @Test
    public void testWriteLogToFile4(){
        LogUtils.info("Đây là log thứ 4");
    }
}
