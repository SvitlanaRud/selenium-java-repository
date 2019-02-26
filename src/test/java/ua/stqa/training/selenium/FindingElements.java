package ua.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindingElements extends TestBase {

    @Test
    public void verifyAllSectionsOfAdminPanel() {
        //This test goes through all sections and subsections of admin panel menu and verifies the presence of headers
        loginToAdminPanel();
        List<WebElement> menuItems = driver.findElements(By.cssSelector("#app-"));
        for (int i=0; i<menuItems.size(); i++) {
            menuItems.get(i).click();
            if (isElementPresent(By.xpath("//li[starts-with(@id,'doc-')]"))) {
                List<WebElement> subItems = driver.findElements(By.xpath("//li[starts-with(@id,'doc-')]"));
                for (int j=0; j< subItems.size(); j++) {
                    subItems.get(j).click();
                    Assert.assertTrue(isElementPresent(By.tagName("h1")));
                    subItems = driver.findElements(By.xpath("//li[starts-with(@id,'doc-')]"));
                }

            }
            Assert.assertTrue(isElementPresent(By.tagName("h1")));
            menuItems = driver.findElements(By.cssSelector("#app-"));
        }
    }
}

