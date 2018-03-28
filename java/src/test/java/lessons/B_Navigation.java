package lessons;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class B_Navigation
{
    @Test
    public void b_navigation() throws InterruptedException { //Explain InterruptedException
        //Start a new instance of Chrome
        WebDriver driver = new ChromeDriver();

        //We're going to look at manage() later in the course, but for now this line will maximise the browser window
        driver.manage().window().maximize();

        //Navigate to an awesome blog
        driver.navigate().to("https://www.thefriendlytester.co.uk");
        //We're using implicitWaits here just too help us see the navigation, please don't use these :D
        //We'll learn more about waits in later lessons
        Thread.sleep(2500);
        //Asking WebDriver to navigate to a different URL
        driver.navigate().to("https://thefriendlytester.co.uk/about");
        Thread.sleep(2500);
        //Asking WebDriver to press the back button on the browser
        driver.navigate().back();
        Thread.sleep(2500);
        //Asking WebDriver to press the forward button on the browser
        driver.navigate().forward();
        Thread.sleep(2500);
        //Asking WebDriver to refresh the current page
        driver.navigate().refresh();

        driver.quit();
    }
}