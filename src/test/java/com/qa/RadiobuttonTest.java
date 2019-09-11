package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class RadiobuttonTest {

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
    public void radiobuttonTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        Thread.sleep(2000);
        WebElement maleRadio = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input");
        WebElement femaleRadio = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[2]/input");
        maleRadio.click();
        Thread.sleep(2000);
        WebElement showButton = driver.findElementById("buttoncheck");
        showButton.click();
        Thread.sleep(3000);
        WebElement text = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[3]");

        assertEquals("Radio button 'Male' is checked", text.getText() );
        Thread.sleep(3000);

        femaleRadio.click();
        Thread.sleep(3000);
        showButton.click();
        Thread.sleep(3000);
        assertEquals("Radio button 'Female' is checked", text.getText());

    }

    @Test
    public void
}
