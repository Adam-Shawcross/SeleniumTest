package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

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
    public void searchTest() throws InterruptedException {
        driver.get("http://google.com");
        Thread.sleep(2000);
        WebElement searchField = driver.findElement(By.name("q"));
        assertTrue(searchField.isDisplayed());
        searchField.sendKeys("funny cat pics");
        Thread.sleep(2000);
        WebElement submitbutton = driver.findElement(By.name("btnK"));
        submitbutton.click();
        Thread.sleep(2000);
        WebElement linkToBigCats = driver.findElementByLinkText("Images for funny cat");
        linkToBigCats.click();
        Thread.sleep(4000);
        WebElement cuteCat = driver.findElementById("c06tNVL-sDc9sM:");
        cuteCat.click();

        Thread.sleep(4000);
        WebElement cuteCatBig = driver.findElementByClassName("irc_mic");
        Actions action= new Actions(driver);
        action.contextClick(cuteCatBig).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
        Thread.sleep(4000);

    }










}
