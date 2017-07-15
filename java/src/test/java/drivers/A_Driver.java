package drivers;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class A_Driver
{
    /**
     * If you run this test, after putting GeckoDriver in one of the locations mentioned, you should see Firefox open and close again
     */
    @Test
    public void a_CreateFirefoxDriverGeckoDriverOnPath()
    {
        //FirefoxDriver requires GeckoDriver, in order to allow Selenium to drive Firefox.
        //You'll need to download the GeckoDriver.
        //Selenium will automatically look for GeckoDriver in the following locations
        //On a windows machine you'll need to add the path to the driver to your windows environment PATH
        //On a mac you can copy the executable to /usr/bin or /usr/bin/local folder

        //This line will then create you a new Firefox Driver instance
        WebDriver Driver = new FirefoxDriver();
        //This instructs Selenium to close the browser and kill the driver.
        Driver.quit();
    }

    /**
     * Another option with Java is to set a system property to define where the Driver is.
     * Selenium will then automatically look to see if this is set.
     * The predefined format for these properties is 'webdriver.{{driver name}}.driver
     * So in the case of Firefox we need to set GeckoDriver.
     * On my machine I've download GeckoDriver to my downloads folder
     * Again if you run this test, Firefox will just open and close.
     */
    @Test
    public void a_CreateFirefoxDriverGeckoDriverUsingSystemProperty()
    {
        //This sets the property along with the specified value
        System.setProperty("webdriver.gecko.driver", "/Users/richard/Downloads/geckodriver");
        WebDriver Driver = new FirefoxDriver();
        Driver.quit();
    }

    /**
     * The same applies to Chrome. Download ChromeDriver (location is in the readme)
     * Then do one of the above methods, add it to your PATH, a bin folder or set the system property using 'webdriver.chrome.driver'
     *
     * If you run this test, after putting ChromeDriver in one of the locations mentioned, you should see Chrome open and close again
     */
    @Test
    public void a_CreateChromeDriver()
    {
        //This line will create you a new instance of the ChromeDriver.
        WebDriver Driver = new ChromeDriver();
        Driver.quit();
    }

    /**
     * The official Safari Driver only works on a Mac and from Safari 10+
     * You need to
     */
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
