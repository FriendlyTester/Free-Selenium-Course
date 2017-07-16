package lessons.B_Navigation;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class B_Navigation
{
    @Test
    public void b_navigation() throws InterruptedException { //Explain InterruptedException
        //Start a new instance of Chrome
        WebDriver Driver = new ChromeDriver();

        //We're going to look at manage() later in the course, but for now this line will maximise the browser window
        Driver.manage().window().maximize();

        //Navigate to an awesome blog
        Driver.navigate().to("https://www.thefriendlytester.co.uk");
        //We're using implicitWaits here just too help us see the navigation, please don't use these :D
        //We'll learn more about waits in later lessons
        Thread.sleep(2500);
        //Asking WebDriver to navigate to a different URL
        Driver.navigate().to("https://thefriendlytester.co.uk/about");
        Thread.sleep(2500);
        //Asking WebDriver to press the back button on the browser
        Driver.navigate().back();
        Thread.sleep(2500);
        //Asking WebDriver to press the forward button on the browser
        Driver.navigate().forward();
        Thread.sleep(2500);
        //Asking WebDriver to refresh the current page
        Driver.navigate().refresh();

        Driver.quit();
    }
}