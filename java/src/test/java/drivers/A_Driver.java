package drivers;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class A_Driver
{
    @Test
    public void a_CreateFirefoxDriverGeckoDriverOnPath()
    {
        //FirefoxDriver requires GeckoDriver, in order to allow Selenium to drive Firefox.
        //You'll need to download the GeckoDriver.
        //On a windows machine you'll need to add the path to the driver to your windows [PATH](https://stackoverflow.com/questions/44272416/how-to-add-a-folder-to-path-environment-variable-in-windows-10-with-screensho)
        WebDriver Driver = new FirefoxDriver();
        //Driver.quit();
    }

    @Test
    public void a_CreateFirefoxDriverGeckoDriverUsrLocalBin()
    {
        //I've made this test work by placing the GeckoDriver in to the /usr/local/bin folder.
        //This is also one of the places on a mac that Selenium will automatically look for it
        //Use this if you don't have access to /usr/bin
        WebDriver Driver = new FirefoxDriver();
        Driver.quit();
    }

    @Test
    public void a_CreateFirefoxDriverGeckoDriverPATH()
    {
        //On a windows machine we can add GeckoDriver to the environment PATH
        //The PATH is a place Selenium will automatically look for the drivers
        WebDriver Driver = new FirefoxDriver();
        Driver.quit();
    }

    @Test
    public void a_CreateFirefoxDriverGeckoDriverUsingSystemProperty()
    {
        //Instead of putting the driver in a place Selenium will look for it, we can specifically tell it where to look for the driver
        System.setProperty("webdriver.gecko.driver", "/Users/richard/Downloads/geckodriver");
        WebDriver Driver = new FirefoxDriver();
        Driver.quit();
    }

    @Test
    public void a_CreateChromeDriver()
    {
        //Just like with Firefox, you need a driver to make Chrome work with Selenium.
        //You can download it from here -
        //You can place ChromeDriver is all the same places as above to make it work with Selenium
        WebDriver Driver = new ChromeDriver();
        Driver.quit();
    }

    @Test
    public void a_CreateSafariDriver()
    {
        //Like Firefox and Chrome, Safari also requires a driver.
        //The Safari driver is shipped with MacOS.
        //If you look in /usr/bin you'll see the driver in there called safaridriver
        WebDriver Driver = new SafariDriver();
        Driver.quit();

        //https://webkit.org/blog/6900/webdriver-support-in-safari-10/
        //Talk about enabling these within Safari first
    }

    @Test
    public void a_CreateEdgeDriver()
    {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\IEUser\\Documents\\WebDriverWorkshopJava\\EdgeDriver.exe");
        WebDriver Driver = new EdgeDriver();
        Driver.quit();
    }
}
