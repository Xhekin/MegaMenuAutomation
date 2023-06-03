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

public class loginTests {
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
    public void succesfulLogin() {

        driver.get("https://www.teachaway.com");
        By loginBy = By.xpath("//*[@id=\"login\"]");
        driver.findElement(loginBy).click();

        By usernameBy = By.name("username");
        driver.findElement(usernameBy).sendKeys("TEST1@TEST.COM");
        By passwordBy = By.name("password");
        driver.findElement(passwordBy).sendKeys("1234Aa..");
        By loginButtonBy = By.xpath("//*[@id=\"login_action\"]");
        driver.findElement(loginButtonBy).click();

        String expectedURL = "https://www.teachaway.com/register/steps/welcome";
        wait.until(ExpectedConditions.urlToBe(expectedURL));
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, currentURL);


    }

    @Test
    public void unsuccessfulLogin() {

        driver.get("https://www.teachaway.com");
        By loginBy = By.xpath("//*[@id=\"login\"]");
        driver.findElement(loginBy).click();

        By usernameBy = By.name("username");
        driver.findElement(usernameBy).sendKeys("WrongUsername");
        By passwordBy = By.name("password");
        driver.findElement(passwordBy).sendKeys("WrongPassword");
        By loginButtonBy = By.xpath("//*[@id=\"login_action\"]");
        driver.findElement(loginButtonBy).click();

        By errorMessage = By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div");
        String expectedErrorMessage = "Sorry, unrecognized e-mail or password. Please try again.";
        wait.until(ExpectedConditions.textToBe(errorMessage, expectedErrorMessage));
        String actualErrorMessage = driver.findElement(errorMessage).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }


}

