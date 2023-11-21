package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseurl = " https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.partialLinkText("Sign In")).click();
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]")).getText();
        Assert.assertEquals("User was not navigated to login page.", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.partialLinkText("Sign In")).click();
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("abcdef@gmail.com");
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("Test123456");
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        String expectedmessage = "Invalid email or password.";
        String actualmessage = driver.findElement(By.xpath("//div[@id='notice']")).getText();
        Assert.assertEquals("Error Message was not displayed.", expectedmessage, actualmessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
