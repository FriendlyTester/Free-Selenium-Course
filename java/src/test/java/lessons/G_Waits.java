package lessons;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class G_Waits
{
    /**
     * This is bad. You want to do all you can to avoid this.
     * This is our first example if an implicit wait coded by us.
     * Here we are basically just telling Java to do absolutely nothing for 5 seconds.
     * However, we know what we are waiting for, or we should, so we should instead instruct Java on what to wait for.
     * But if you do ever want to tell Java to stop everything and do nothing for a period of time, this is how.
     */
    @Test
    public void g_ImplicitWait() throws InterruptedException {
        //First think you will see is the InterruptedException. We have to add this, as Thread.sleep() has the potential to throw this exception.
        //Therefore we need to handle it, or instruct our own code to throw the exception if it indeed happens.

        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators");

        //As mentioned above, this doesn't what you think. It sends your code to sleep for the provided value.
        //The value is in milliseconds. So 5000, is 5 seconds.
        Thread.sleep(5000);

        Driver.quit();
    }

    /**
     * This isn't as bad, but it can be as bad. Just don't increase that 10 too high.
     * This is the overruling wait for WebDriver. WebDiver will continue to try each command to the server for this given time.
     * So in this check, we are going to the page and looking for an element I know doesn't exist on this page.
     * WebDriver will continue to look for it, for the provided time.
     */
    @Test
    public void g_ImplicitWaitDriverTimeout() throws InterruptedException {

        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators");

        //This tell WebDriver how long to keep trying a command for, until it gets a successful response.
        Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Driver.findElement(By.id("ThisIsNotReal"));
        Driver.quit();
    }

    /**
     * This is good. We like this.
     * This is an example of an Explicit Wait.
     * Which in other terms means, I'm willing to wait for this amount of time for the given command to be successful.
     * The moment the command is successful the check will progress.
     * The reason why this is preferred over implicit, is explicit waits are contextual. We can set different length waits depending on the apps behaviour
     */
    @Test
    public void g_ExplicitWaits()
    {
        //Start a Firefox Instance
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators");

        //Selenium provide us with an object call WebDriverWait.
        //This object takes a Driver, and an int. That int is the amount of time to wait in seconds.
        WebDriverWait wait = new WebDriverWait(Driver, 5);

        //We can set how often we want WebDriver to check if our condition is met
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);

        //We can add a custom message. WebDriver will show this message if the wait times out.
        //A good contextual message here can really aid with debugging
        wait.withMessage("Timed out waiting for the password field");

        //So this check will eventually timeout. It will timeout after spending 5 seconds looking for an element with the ID of password.
        //The Selenium team have provided us with a huge range of ExpectedConditions.
        //If you type ExepectionConditions followed by a . intelliSense will show you all the options
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        Driver.quit();
    }

    /**
     * Now if we were to run this example, it would actually take 10 seconds to fail, even though our ExplicitWait is 5 seconds.
     * That's because we've set an ImplicitWait of 10 seconds.
     * This is why it's important to keep that global implicit wait, ideally at 0, but certainly no more than 2-3 seconds.
     * Now if the ExplicitWait was higher than the ImplicitWait, WebDriver would wait for the amount of time in the ExplicitWait.
     */
    @Test
    public void g_ExplicitWaitsWithImplicitWaits()
    {
        //Start a Firefox Instance
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators");

        Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(Driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        Driver.quit();
    }
}
