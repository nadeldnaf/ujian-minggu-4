package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class CatatanKeuanganTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "OPPO A9 20202");
        dc.setCapability("autoGrantPermissions", true);
        dc.setCapability("udid", "4ddd37a7");
        dc.setCapability("platformName", "android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
    }

    @AfterClass
    public void finish(){
        driver.quit();
    }

    @Test (priority = 1)
    public void testPengeluaran() throws InterruptedException {

        Thread.sleep(5000); // Waktu untuk loading splash screen

        try {
            MobileElement tutupNotifikasi = (MobileElement) driver.findElementById("android:id/button2");
            tutupNotifikasi.click();
            System.out.println("Notifikasi belum disetujui, setujui notifikasi dahulu");
        } catch (NoSuchElementException e) {
            System.out.println("Notifikasi sudah di setujui.");
        }

        MobileElement tambahBaru = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        tambahBaru.click();

        MobileElement jumlahPengeluaran = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        MobileElement catatanPengeluaran = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        MobileElement simpanData = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");

        jumlahPengeluaran.sendKeys("2000000");
        catatanPengeluaran.sendKeys("Pengeluaran Darurat");

        System.out.println(jumlahPengeluaran.getText());
        System.out.println(catatanPengeluaran.getText());
        Assert.assertEquals(jumlahPengeluaran.getText(), "2,000,000");
        Assert.assertEquals(catatanPengeluaran.getText(), "Pengeluaran Darurat");

        simpanData.click();

    }

    @Test (priority = 2)
    public void testPemasukan(){
        MobileElement tambahBaru = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        tambahBaru.click();

        MobileElement tabPemasukan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
        tabPemasukan.click();

        MobileElement jumlahPemasukan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        MobileElement catatanPemasukan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        MobileElement simpanData = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");

        jumlahPemasukan.sendKeys("3000000");
        catatanPemasukan.sendKeys("Gaji Bulanan");

        System.out.println(jumlahPemasukan.getText());
        System.out.println(catatanPemasukan.getText());
        Assert.assertEquals(jumlahPemasukan.getText(), "3,000,000");
        Assert.assertEquals(catatanPemasukan.getText(), "Gaji Bulanan");

        simpanData.click();

    }
}
