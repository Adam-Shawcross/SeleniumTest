package com.qa;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class SeleniumPractice {
    private ChromeDriver driver;
    private ExtentReports extent;
    ExtentTest test;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\SeleniumTest\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        extent = new ExtentReports("C:\\Users\\Admin\\Documents\\seleniumtest.html", true);

    }


    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void singleInputTest() throws InterruptedException {
        test = extent.startTest("Loading Webpage");
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(3000);
        test.log(LogStatus.INFO, "Browser started");
        test.log(LogStatus.INFO, "Sending keys");
        WebElement textBox =  driver.findElement(By.id("user-message"));
        textBox.sendKeys("abc");
        Thread.sleep(3000);
        WebElement showMessage = driver.findElementByXPath("//*[@id=\"get-input\"]/button");
        test.log(LogStatus.INFO, "clicking button");
        showMessage.click();
        Thread.sleep(3000);
        WebElement message = driver.findElementById("display");
        assertEquals("abc", message.getText());
        test.log(LogStatus.PASS, "inputs are equal");
        extent.endTest(test);
        extent.flush();
        Thread.sleep(10000);

    }

    @Test
    public void addTwo() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(3000);
        WebElement sum1 =driver.findElementById("sum1");
        WebElement sum2 = driver.findElementById("sum2");
        sum1.sendKeys("3");
        Thread.sleep(2000);
        sum2.sendKeys("7");
        Thread.sleep(3000);
        WebElement total = driver.findElementByXPath("//*[@id=\"gettotal\"]/button");
        total.click();
        Thread.sleep(2000);
        WebElement totalVal = driver.findElementById("displayvalue");
        assertEquals("10", totalVal.getText());
        Thread.sleep(2000);

    }



}
