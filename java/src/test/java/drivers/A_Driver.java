package drivers;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class A_Driver
{
    /**
     * If you run this test, after putting GeckoDriver in one of the locations mentioned, you should see Firefox open and close again.
     */
    @Test
    public void a_CreateFirefoxDriverGeckoDriverOnPath()
    {
        //FirefoxDriver requires GeckoDriver, in order to allow Selenium to drive Firefox.
        //You'll need to download the GeckoDriver.
        //Selenium will automatically look for GeckoDriver in the following locations.
        //On a windows machine you'll need to add the path to the driver to your windows environment PATH.
        //On a mac you can copy the executable to /usr/bin or /usr/bin/local folder.

        //This line will then create you a new Firefox Driver instance.
        WebDriver Driver = new FirefoxDriver();
        //This instructs Selenium to close the browser and kill the driver.
        Driver.quit();
    }

    /**
     * Another option with Java is to set a system property to define where the Driver is.
     * Selenium will then automatically look to see if this is set.
     * The predefined format for these properties is 'webdriver.{{driver name}}.driver'.
     * So in the case of Firefox we need to set GeckoDriver.
     * On my machine I've download GeckoDriver to my downloads folder.
     * Again if you run this test, Firefox will just open and close.
     */
    @Test
    public void a_CreateFirefoxDriverGeckoDriverUsingSystemProperty()
    {
        //This sets the property along with the specified value, change this for where you've put the driver
        System.setProperty("webdriver.gecko.driver", "/Users/richard/Downloads/geckodriver");
        WebDriver Driver = new FirefoxDriver();
        Driver.quit();
    }

    /**
     * The same applies to Chrome. Download ChromeDriver (location is in the readme).
     * Then do one of the above methods, add it to your PATH, a bin folder or set the system property using 'webdriver.chrome.driver'.
     *
     * If you run this test, after putting ChromeDriver in one of the locations mentioned, you should see Chrome open and close again.
     */
    @Test
    public void a_CreateChromeDriver()
    {
        //This line will create you a new instance of the ChromeDriver.
        WebDriver Driver = new ChromeDriver();
        Driver.quit();
    }

    /**
     * The official Safari Driver only works on a Mac and from Safari 10+.
     * You need to configure a few things, I've listed those in SafariDriver.md.
     * If you go to /usr/bin in Finder, you see Safari works the same way as the other drivers, Apple has provided safaridriver in there.
     *
     * If you run this, you should see Safari open.
     */
    @Test
    public void a_CreateSafariDriver()
    {
        WebDriver Driver = new SafariDriver();
        Driver.quit();
    }

    /**
     * EdgeDriver will only work on Windows as EDGE is only currently available on Windows.
     * As mentioned above you need to download the EDGEDriver from Microsoft and add to PATH or set the property
     */
    @Test
    public void a_CreateEdgeDriver()
    {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Richard\\Documents\\WebDriver\\EdgeDriver.exe");
        WebDriver Driver = new EdgeDriver();
        Driver.quit();
    }

    /**
     * For those of you who still have to contend with IE, you'll need IEDriver.
     * As mentioned above you need to download the IEDriver from Selenium and add to PATH or set the property
     */
    @Test
    public void a_CreateIEDriver()
    {
        System.setProperty("webdriver.ie.driver", "C:\\Users\\Richard\\Documents\\WebDriver\\IEDriverService.exe");
        WebDriver Driver = new InternetExplorerDriver();
        Driver.quit();
    }
}
