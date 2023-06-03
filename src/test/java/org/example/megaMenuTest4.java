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

public class megaMenuTest4 {

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
    public void megaMenuThirdLayer1() {

        driver.get("https://www.teachaway.com");
        By jobsButton = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[1]/span");
        driver.findElement(jobsButton).click();
        By destionationsButton = By.xpath("//*[@id=\"tb-megamenu-column-1\"]/div/ul/li[2]/span");
        driver.findElement(destionationsButton).click();

        By thirdRow = By.cssSelector("div>div>div>div>div>div>div>nav>h2");
        List<String> thirdRowNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("Countries", "Regions");
        for (int i = 0; i < 2; i++) {
            thirdRowNames.add(driver.findElements(thirdRow).get(i).getText());
        }
        Assert.assertEquals(expectedNames, thirdRowNames);
    }

    @Test
    public void megaMenuThirdLayer2() {

        driver.get("https://www.teachaway.com");
        By jobsButton = By.xpath("//*[@id=\"block-mainnavigation-2\"]/div/div/div/ul/li[1]/span");
        driver.findElement(jobsButton).click();
        By destionationsButton = By.xpath("//*[@id=\"tb-megamenu-column-1\"]/div/ul/li[2]/span");
        driver.findElement(destionationsButton).click();

        By thirdRowTable = By.cssSelector("div>div>div>div>div>div>ul>li>div>div>div>div>div>ul>li>div[class='tb-megamenu-submenu menu--destinations dropdown-menu mega-dropdown-menu nav-child']>div>div>div>div>div>div>nav>ul>li");
        List<String> thirdTableNames = new ArrayList<>();
        List<String> expectedTableNames = Arrays.asList("Online", "China", "UAE", "Dubai", "Saudi Arabia", "Japan", "Qatar", "Abu Dhabi", "Kuwait", "South Korea", "Thailand", "Spain", "Taiwan", "Mexico", "USA", "VIEW ALL", "South America", "Central Asia", "East Asia", "South Asia", "Southeast Asia", "Europe", "North America", "Middle East", "Mexico and the Caribbean", "Australia and New Zealand", "Africa", "VIEW ALL");
        for (int i = 0; i < 28; i++) {
            thirdTableNames.add(driver.findElements(thirdRowTable).get(i).getText());
        }
        Assert.assertEquals(expectedTableNames, thirdTableNames);
    }


}
