package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //Enter Password

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //click on the login button
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();

        //Verify the text
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");

        //Enter Password

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //click on the login button
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();

        //Verify the text
        String expectedText = " Your username is invalid!";
        String actualText = driver.findElement(By.id("flash-messages")).getText();
        Assert.assertEquals(expectedText, actualText);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Enter username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //Enter Password

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        //click on the login button
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();

        //Verify the text
        String expectedText = "Your password is invalid!";
        String actualText = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(expectedText, actualText);


    }




}

