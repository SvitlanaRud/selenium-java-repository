package ua.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Set;

public class AlertsWindowsAndFrames extends TestBase{

    @Test
    public void verifyLinksOpenInNewWindow(){
        loginToAdminPanel();
        driver.navigate().to("http://localhost/litecard/admin/?app=countries&doc=countries");
        driver.findElement(By.className("button")).click();
        List<WebElement> externalLinks = driver.findElements(By.cssSelector("[class$=fa-external-link]"));
        String mainWindow = driver.getWindowHandle();
        Set<String> existingWindows = driver.getWindowHandles();
        for (WebElement link : externalLinks){
            link.click();
            String newWindow = wait.until(anyWindowOtherThan(existingWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }

}
