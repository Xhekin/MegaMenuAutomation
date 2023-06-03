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

public class megaMenuTest2 {

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
    public void megaMenuSecondLayer() {

        driver.get("https://www.teachaway.com");
        By jobsButton = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[1]");
        driver.findElement(jobsButton).click();
        By secondRow = By.xpath("//*[@id=\"tb-megamenu-column-1\"]/div/ul/li");
        wait.until(ExpectedConditions.numberOfElementsToBe(secondRow, 6));
        List<String> megaMenuItems = new ArrayList<>();
        List<String> expectedMegaMenuItems = Arrays.asList("Job Board", "Destinations", "Featured Programs", "Job Openings", "Teach in the US", "Community");
        for (int i = 0; i < 6; i++) {
            megaMenuItems.add(driver.findElements(secondRow).get(i).getText());
        }
        Assert.assertEquals(expectedMegaMenuItems, megaMenuItems);
    }

    @Test
    public void megaMenuSecondLayer2() {

        driver.get("https://www.teachaway.com");
        By teflButton = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[2]/span");
        driver.findElement(teflButton).click();
        By secondRow = By.xpath("//*[@id=\"tb-megamenu-column-10\"]/div/ul/li");
        wait.until(ExpectedConditions.numberOfElementsToBe(secondRow, 2));
        List<String> megaMenuItems = new ArrayList<>();
        List<String> expectedMegaMenuItems = Arrays.asList("TEFL Courses", "TEFL Certification Guide");
        for (int i = 0; i < 2; i++) {
            megaMenuItems.add(driver.findElements(secondRow).get(i).getText());
        }
        Assert.assertEquals(expectedMegaMenuItems, megaMenuItems);
    }

    @Test
    public void megaMenuSecondLayer3() {

        driver.get("https://www.teachaway.com");
        By teacherCertificationButton = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[3]/span");
        driver.findElement(teacherCertificationButton).click();
        By secondRow = By.xpath("//*[@id=\"tb-megamenu-column-11\"]/div/ul/li/a");
        wait.until(ExpectedConditions.numberOfElementsToBe(secondRow, 4));
        List<String> megaMenuItems = new ArrayList<>();
        List<String> expectedMegaMenuItems = Arrays.asList("Teacher Certification Guide", "Certification Programs", "Hawai'i", "Arizona");
        for (int i = 0; i < 4; i++) {
            megaMenuItems.add(driver.findElements(secondRow).get(i).getText());
        }
        Assert.assertEquals(expectedMegaMenuItems, megaMenuItems);
    }

}
