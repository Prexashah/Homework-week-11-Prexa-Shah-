package testsuit;

import browserfactory.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseClass {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //click of computer tab
        driver.findElement(By.xpath("//a[@href = '/computers']")).click();

        //verify the text
        String expectedText = "Computers";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void userNavigateToElectronicPageSuccessfully() {
        //Click on Electronic page
        driver.findElement(By.xpath("//a[@href = '/electronics']")).click();
        //verify the text
        String expectedText = "Electronics";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void UserShouldNavigateToApparelPageSuccessfully() {
        //Click on Apparel page
        driver.findElement(By.xpath("//a[@href = '/apparel']")).click();
        //verify the text
        String expectedText = "Apparel";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        //Click on Digital Down page
        driver.findElement(By.xpath("//a[@href = '/digital-downloads']")).click();
        //verify the text
        String expectedText = "Digital downloads";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        //Click on Books page
        driver.findElement(By.xpath("//a[@href = '/books']")).click();
        //verify the text
        String expectedText = "Books";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        //Click on Jewelery page
        driver.findElement(By.xpath("//a[@href = '/gift-cards']")).click();
        //verify the text
        String expectedText = "Books";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        //Click on GiftCard page
        driver.findElement(By.xpath("//a[@href = '/jewelry']")).click();
        //verify the text
        String expectedText = "Gift Cards";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
