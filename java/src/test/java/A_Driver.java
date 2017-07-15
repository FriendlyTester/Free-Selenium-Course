import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class A_Driver
{
    /**
     * All the browsers now require a driver in order to send and receive WebDriver commands.
     * These are now all maintained by the browsers vendors. (IE being the exception)
     * Chrome - https://sites.google.com/a/chromium.org/chromedriver/downloads
     * Firefox - https://github.com/mozilla/geckodriver
     * Edge - https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
     * SafariDriver - https://developer.apple.com/library/content/releasenotes/General/WhatsNewInSafari/Articles/Safari_10_0.html#//apple_ref/doc/uid/TP40014305-CH11-SW31

     * We have to instruct WebDriver of the locations of these drivers on our machine, we have several options to do this:
     * <ul>
     *     <li>PATH - On windows we can add the location of each driver to the PATH</li>
     *     <li>On A MacOS we can put the driver executable in /usr/bin or /usr/local/bin</li>
     *     <li>In Java we can set a system porperty to the driver location</li>
     *     <li>We can pass the location direct to the Driver instance</li>
     * </ul>
     * Examples of all of the above can be found below
     */

    //

    @Test
    public void a_CreateFirefoxDriverGeckoDriverOnPath()
    {
        //FirefoxDriver requires GeckoDriver, in order to allow Selenium to drive Firefox.
        //I've made this test work by placing the GeckoDriver in to the /usr/bin folder. This is one of the places on a mac that Selenium will automatically look for it
        //You'll need to download the latest GeckoDriver from here
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
