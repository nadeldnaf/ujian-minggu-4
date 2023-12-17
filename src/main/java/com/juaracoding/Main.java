package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 30");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("appPackage", "com.google.android.calculator");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, dc);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MobileElement satu = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement dua = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement tambah = (MobileElement) driver.findElementById("com.google.android.calculator:id/op_add");
        MobileElement samaDengan = (MobileElement) driver.findElementById("com.google.android.calculator:id/eq");
        satu.click();
        tambah.click();
        dua.click();
        samaDengan.click();
        //android.widget.TextView[@resource-id='com.google.android.calculator:id/result_final']
        // tambahkan getText()
        MobileElement result = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        System.out.println(result.getText());

    }
}