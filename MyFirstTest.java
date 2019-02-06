package ua.stqa.training.selenium;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);

    }

    @Test
    public void myFirstTest(){
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        wait.until(visibilityOfElementLocated(By.name("btnK")));
        driver.findElement(By.name("btnK")).click();
        wait.until(titleIs("webdriver - Пошук Google"));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
