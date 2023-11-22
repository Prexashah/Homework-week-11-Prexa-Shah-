package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    //open the baseUrl first
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Admin");

        //Enter password
        driver.findElement(By.name("password")).sendKeys("admin123");

        //click on login button
        driver.findElement(By.xpath("//button")).click();

        //verify the dashboard text
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//h6")).getText();
        Assert.assertEquals(expectedText, actualText);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
