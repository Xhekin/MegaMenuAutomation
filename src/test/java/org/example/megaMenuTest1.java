package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class megaMenuTest1 {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void megaMenuFirstLayer() {

        driver.get("https://www.teachaway.com");
        By by = By.cssSelector("div[class='nav-collapse']>ul>li");
        wait.until(ExpectedConditions.numberOfElementsToBe(by, 5));
        List<String> megaMenuItems = new ArrayList<>();
        List<String> expectedMegaMenuItems = Arrays.asList("JOBS", "TEFL", "TEACHER CERTIFICATION", "COURSES", "HIRE TEACHERS");
        for (int i = 0; i < 5; i++) {
            megaMenuItems.add(driver.findElements(by).get(i).getText());
        }
        Assert.assertEquals(expectedMegaMenuItems, megaMenuItems);
    }
}
