package lessons;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class X_FluentWaits
{
    @Test
    public void g_FluentWaits()
    {
        //Start a Firefox Instance
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(Driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(new Function<WebDriver, String>() {
            public String apply(WebDriver driver) {
                return driver.findElement(By.id("foo")).getText();
            }
        });
    }
}
