package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class CheckBoxTest {

    private ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\SeleniumTest\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void singleCheckboxTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(2000);
        WebElement checkbox = driver.findElementById("isAgeSelected");
        checkbox.click();
        WebElement showMessage = driver.findElementById("txtAge");
        assertEquals("Success - Check box is checked", showMessage.getText());
        Thread.sleep(3000);
    }

    @Test
    public void multiCheckbox() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(2000);
        WebElement checkall = driver.findElementById("check1");
        WebElement hidden = driver.findElementById("isChkd");
        checkall.click();
        Thread.sleep(2000);
        assertEquals("true", hidden.getAttribute("value"));
        Thread.sleep(2000);
        checkall.click();
        Thread.sleep(2000);
        assertEquals("false", hidden.getAttribute("value"));
        Thread.sleep(2000);
        WebElement oneButton = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input");
        checkall.click();
        Thread.sleep(2000);


    }



}
