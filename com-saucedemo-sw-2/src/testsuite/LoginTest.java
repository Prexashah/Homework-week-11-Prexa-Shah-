package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    //open the baseUrl first
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter Password

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //click on the login button
        driver.findElement(By.id("login-button")).click();

        //Verify the text
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class = 'title']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Enter Password

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //click on the login button
        driver.findElement(By.id("login-button")).click();

        //verify the title
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class = 'title']")).getText();
        Assert.assertEquals(expectedText, actualText);

        //Verify the six product on display page
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        Assert.assertTrue("Six products are not displayed on the page : ",products.size()==6);

    }
    @After
    public void tearDown() {
        closeBrowser();

    }
}
