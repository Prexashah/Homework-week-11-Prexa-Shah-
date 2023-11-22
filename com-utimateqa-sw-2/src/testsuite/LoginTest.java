package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";


    //open the baseUrl first
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Click on the sing in link
        driver.findElement(By.xpath("//li[@class = 'header__nav-item header__nav-sign-in']")).click();

        //Verify the text Welcome Back!
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class ='page__heading']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }
    @Test
    public void verifyTheErrorMessage(){
        //Click on the sing in link
        driver.findElement(By.xpath("//li[@class = 'header__nav-item header__nav-sign-in']")).click();

        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("ltester@gmail.com");

       //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("abc123");

        //click on login button
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();

        //Verify the message //li[@class = 'form-error__list-item']
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[contains(text(),'Invalid')]")).getText();
        Assert.assertEquals(expectedText, actualText);

    }



}
