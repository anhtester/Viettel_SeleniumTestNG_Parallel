package com.anhtester.common;

import com.anhtester.drivers.DriverManager;
import com.anhtester.helpers.CaptureHelper;
import com.anhtester.helpers.PropertiesHelper;
import com.anhtester.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(@Optional("chrome") String browserName) {
        //WebDriver driver = setBrowser(browserName);

        PropertiesHelper.loadAllFiles();
        WebDriver driver = setBrowser(PropertiesHelper.getValue("browser"));

        DriverManager.setDriver(driver);
    }

    public WebDriver setBrowser(String browserName) {
        WebDriver driver = null;


        if (browserName.trim().toLowerCase().equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (PropertiesHelper.getValue("HEADLESS").equals("true")) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        }
        if (browserName.trim().toLowerCase().equals("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (PropertiesHelper.getValue("HEADLESS").equals("true")) {
                options.addArguments("--headless");
            }
            driver = new EdgeDriver(options);
        }
        if (browserName.trim().toLowerCase().equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (PropertiesHelper.getValue("HEADLESS").equals("true")) {
                options.addArguments("--headless");
            }
            driver = new FirefoxDriver(options);
        }

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().window().maximize();

        return driver;
    }

    @AfterMethod
    public void closeBrowser(ITestResult iTestResult) {
        DriverManager.quit();
    }

}