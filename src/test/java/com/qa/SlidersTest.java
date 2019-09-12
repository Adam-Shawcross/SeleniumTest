package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class SlidersTest {

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
    public void sliderTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        WebElement dragMe = driver.findElementByName("range");
        action.dragAndDropBy(dragMe, 300, 200).perform();
        Thread.sleep(3000);
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {

        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        WebElement dragMe = driver.findElementByXPath("//*[@id=\"todrag\"]/span[1]");
        WebElement dragHere = driver.findElementByXPath("//*[@id=\"mydropzone\"]");
        action.dragAndDropBy(dragMe, 100,-10).build().perform();
        Thread.sleep(1000);




    }
}
