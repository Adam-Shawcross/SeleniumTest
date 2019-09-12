package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class Screenshottest {
    private ChromeDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\SeleniumTest\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void screenshotTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
        Thread.sleep(3000);
        File scrFile =(driver).getScreenshotAs(OutputType.FILE);
        Thread.sleep(4000);
        System.out.println(scrFile.getAbsolutePath());
        Thread.sleep(4000);
    }
}
