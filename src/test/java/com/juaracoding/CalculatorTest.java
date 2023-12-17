package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 30");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("appPackage", "com.google.android.calculator");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
    }

    @AfterClass
    public void finish() {
            driver.quit();
        }
    @Test
    public void testPengurangan(){
        MobileElement tiga = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement empat = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement kurang = (MobileElement) driver.findElementById("com.google.android.calculator:id/op_sub");
        MobileElement samaDengan = (MobileElement) driver.findElementById("com.google.android.calculator:id/eq");
        tiga.click();
        kurang.click();
        empat.click();
        samaDengan.click();
        // tambahkan getText()
        MobileElement result = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        System.out.println(result.getText());
        Assert.assertEquals(result.getText(),"−1");
    }
}
