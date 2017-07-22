package lessons;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class A_Drivers
{
    /**
     * If you run this test, after putting GeckoDriver in one of the locations mentioned, you should see Firefox open and close again.
     */
    @Test
    public void a_CreateFirefoxDriverGeckoDriverOnPath()
    {
        //This line will then create you a new Firefox Driver instance.
        WebDriver Driver = new FirefoxDriver();
        //This instructs Selenium to close the browser and kill the driver.
        Driver.quit();
    }

    /**
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
     * If you run this, you should see Safari open.
     */
    @Test
    public void a_CreateSafariDriver()
    {
        WebDriver Driver = new SafariDriver();
        Driver.quit();
    }

    /**
     * If you run this test, after putting MicrosoftWebDriver in one of the locations mentioned, you should see EDGE open and close again.
     */
    @Test
    public void a_CreateEdgeDriver()
    {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Richard\\Documents\\WebDriver\\MicrosoftWebDriver.exe");
        WebDriver Driver = new EdgeDriver();
        Driver.quit();
    }

    /**
     * If you run this test, after putting IEDriverServer.exe in one of the locations mentioned, you should see IE open and close again.
     */
    @Test
    public void a_CreateIEDriver()
    {
        System.setProperty("webdriver.ie.driver", "C:\\Users\\Richard\\Documents\\WebDriver\\IEDriverService.exe");
        WebDriver Driver = new InternetExplorerDriver();
        Driver.quit();
    }
}