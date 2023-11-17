package com.anhtester.Bai27_ReadPropertiesFile;

import com.anhtester.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class DemoReadPropertiesFile {
    @Test
    public void testReadFile() {
        //Load all properties file
        PropertiesHelper.loadAllFiles();

        //Get value
        System.out.println("BROWSER: " + PropertiesHelper.getValue("browser"));
        System.out.println("URL: " + PropertiesHelper.getValue("url"));
        System.out.println("EMAIL: " + PropertiesHelper.getValue("email"));
        System.out.println("PASSWORD: " + PropertiesHelper.getValue("password"));
        System.out.println("MESSAGE1: " + PropertiesHelper.getValue("message1"));

    }

    @Test
    public void setDataToProperties(){
        //Chỉ định file cần set data
        PropertiesHelper.setFile("src/test/resources/configs/local.properties");
        //PropertiesHelper.loadAllFiles();

        //Gọi hàm setValue
        PropertiesHelper.setValue("headless", "yes");
    }
}
