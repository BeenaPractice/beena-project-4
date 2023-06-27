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
@Before
    // browser setup
    public void browserSetUp() {
        openBrowser(baseUrl);
    }
@Test
    //userShouldLoginSuccessfullyWithValid Credentials
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //  Enter “standard_user” username
    driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
    // Enter “secret_sauce” password
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
    // Click on ‘LOGIN’ button
    driver.findElement(By.xpath("//input[@id='login-button']")).click();
    // Verify the text “PRODUCTS”
    String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
    String expectedText = "Products";
    Assert.assertEquals("failed!",expectedText,actualText);
    }

    // verifyThatSixProductsAreDisplayedOnPage
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        //  Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // Verify that six products are displayed on page

        List<WebElement> image = driver.findElements(By.className("inventory_item"));
        System.out.println("The number of image is" + image.size());
        int  expectedImage = 6;
        int actualImage = image.size();
        Assert.assertEquals("",expectedImage,actualImage);

    }
    @After
    public void tearDown(){
    closeBrowser();
    }
}