package testsuit;

import browserfactory.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseClass {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //find and click on register link
        driver.findElement(By.xpath("//a")).click();
        //verify the text
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on reg link
        driver.findElement(By.xpath("//a")).click();

        //Select Gender radio button
        driver.findElement(By.xpath("//input[@id = 'gender-female']")).click();

        //Enter the first name
        driver.findElement(By.name("FirstName")).sendKeys("Maria");

        //Enter last name
        driver.findElement(By.name("LastName")).sendKeys("Roshan");

        //Select Day
        Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        day.selectByVisibleText("5");

        //select Month
        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByVisibleText("August");

        //select Year
        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByVisibleText("1982");

        //Enter email address
        driver.findElement(By.id("Email")).sendKeys("ltester@gmail.com");

        //Enter password
        driver.findElement(By.name("Password")).sendKeys("abc123");

        //confirm password
        driver.findElement(By.name("ConfirmPassword")).sendKeys("abc123");

        //Click on Register button
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();

        //message on completion
        System.out.println("Your registration completed");
    }

    @After
    public void tearDown() {
        closeBrowser();


    }
}