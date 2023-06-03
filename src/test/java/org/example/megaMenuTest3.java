package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class megaMenuTest3 {

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
    public void jobsSecondLayer() {

        driver.get("https://www.teachaway.com");
        By jobs = By.xpath("//*//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[1]/span");
        driver.findElement(jobs).click();
        By jobsAbroad = By.xpath("//*[@id=\"tb-megamenu-column-1\"]/div/ul/li[1]/a");
        driver.findElement(jobsAbroad).click();

        String expectedURL = "https://www.teachaway.com/teaching-jobs-abroad";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, currentURL);
    }

    @Test
    public void teflSecondLayer1() {

        driver.get("https://www.teachaway.com");
        By tefl = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[2]/span");
        driver.findElement(tefl).click();
        By teflCourses = By.xpath("//*[@id=\"tb-megamenu-column-10\"]/div/ul/li[1]/a");
        driver.findElement(teflCourses).click();

        String expectedURL = "https://www.teachaway.com/courses/online-tefl-certification";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, currentURL);
    }

    @Test
    public void teflSecondLayer2() {

        driver.get("https://www.teachaway.com");
        By tefl = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[2]/span");
        driver.findElement(tefl).click();
        By teflCertificationGuide = By.xpath("//*[@id=\"tb-megamenu-column-10\"]/div/ul/li[2]/a");
        driver.findElement(teflCertificationGuide).click();

        String expectedURL = "https://www.teachaway.com/tefl-certification";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, currentURL);


    }

    @Test
    public void teacherCertificationSecondLayer1() {

        driver.get("https://www.teachaway.com");
        By teacherCertification = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[3]/span");
        driver.findElement(teacherCertification).click();
        By teacherCertificationGuide = By.xpath("//*[@id=\"tb-megamenu-column-11\"]/div/ul/li[1]/a");
        driver.findElement(teacherCertificationGuide).click();

        String expectedURL = "https://www.teachaway.com/alternative-teacher-certification";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, currentURL);
    }

    @Test
    public void teacherCertificationSecondLayer2() {

        driver.get("https://www.teachaway.com");
        By teacherCertification = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[3]/span");
        driver.findElement(teacherCertification).click();
        By teacherCertificationGuide = By.xpath("//*[@id=\"tb-megamenu-column-11\"]/div/ul/li[2]/a");
        driver.findElement(teacherCertificationGuide).click();

        String expectedURL = "https://www.teachaway.com/courses/teacher-certification";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, currentURL);
    }

    @Test
    public void teacherCertificationSecondLayer3() {

        driver.get("https://www.teachaway.com");
        By hawaiiButton = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[3]/span");
        driver.findElement(hawaiiButton).click();
        By teacherCertificationGuide = By.xpath("//*[@id=\"tb-megamenu-column-11\"]/div/ul/li[3]/a");
        driver.findElement(teacherCertificationGuide).click();

        String expectedURL = "https://www.teachaway.com/courses/hawaii-teacher-certification";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, currentURL);
    }

    @Test
    public void teacherCertificationSecondLayer4() {

        driver.get("https://www.teachaway.com");
        By arizonaButton = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[3]/span");
        driver.findElement(arizonaButton).click();
        By teacherCertificationGuide = By.xpath("//*[@id=\"tb-megamenu-column-11\"]/div/ul/li[4]/a");
        driver.findElement(teacherCertificationGuide).click();

        String expectedURL = "https://www.teachaway.com/courses/az-teacher-certification";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, currentURL);
    }

    @Test
    public void coursesFirstLayer() {

        driver.get("https://www.teachaway.com");
        By coursesButton = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[4]/a");
        driver.findElement(coursesButton).click();

        String expectedURL = "https://www.teachaway.com/courses-and-certifications";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, currentURL);
    }

    @Test
    public void hireTeachersFirstLayer() {

        driver.get("https://www.teachaway.com");
        By hireTeachersButton = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[5]");
        driver.findElement(hireTeachersButton).click();

        String expectedURL = "https://www.teachaway.com/recruitment";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, currentURL);
    }
}
