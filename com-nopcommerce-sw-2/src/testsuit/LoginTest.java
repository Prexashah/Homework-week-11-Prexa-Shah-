package testsuit;

import browserfactory.BaseClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseClass {
    String baseUrl = "https://demo.nopcommerce.com/";

    //open the baseUrl first
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPAgeSuccessfully() {
        //Find the login link text
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        String expectedText = "Welcome, Please Sign In!";

        //Find the actual element and get the text from that element
        WebElement actualTextElement = driver.findElement(By.xpath("//h1"));
        String actualText = actualTextElement.getText();

        //Verify Actual and Expected text
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on the login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //Enter valid username
        WebElement emailField = driver.findElement(By.name("Email"));
        emailField.sendKeys("ltesting@gmail.com");

        //enter password in password field
        WebElement passwordField = driver.findElement(By.xpath("//input[@class = 'password']"));
        passwordField.sendKeys("abcd123");

        //find the login element and click
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
    }

    @Test
    public void verifyTheErrorMessage() {
        //click on the login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //Enter valid username
        WebElement emailField = driver.findElement(By.name("Email"));
        emailField.sendKeys("ltesting@gmail.com");

        //enter password in password field
        WebElement passwordField = driver.findElement(By.xpath("//input[@class = 'password']"));
        passwordField.sendKeys("abcd12345");

        //find the login element and click
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
    }


}

