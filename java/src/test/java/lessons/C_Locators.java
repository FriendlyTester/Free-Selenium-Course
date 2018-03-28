package lessons;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class C_Locators
{
    /**
     * See if you can visit the URL below and understand why these selectors work.
     * This is how you find a single element.
     */
    @Test
    public void c_SingleElementAllLocators()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationintesting.com/selenium/testpage");

        //Find the Form using ID
        //The FindElement returns a WebElement object if it finds a match, we are assigning that to our own object called formById
        WebElement formById = driver.findElement(By.id("contactus"));

        //Find the same Form using Name
        WebElement formByName = driver.findElement(By.name("contactform"));

        //Find the Dropdown using it's class
        WebElement genderByClass = driver.findElement(By.className("gender"));

        //Find the only anchor link on the page
        WebElement linkByTag = driver.findElement(By.tagName("a"));

        //Find the first name input using an XPath from root
        WebElement firstNameFieldByFullXPath = driver.findElement(By.xpath("/html/body/main/article[1]/div[1]/form[1]/div[1]/div[1]/label[1]/input"));

        //Find the first name input using an XPath starting at the most unique parent
        WebElement firstNameFieldByShortXPath = driver.findElement(By.xpath("//*[@id=\"contactus\"]/div[1]/div[1]/label[1]/input"));

        //Find the anchor link using a CSS Selector
        WebElement linkUsingCSS = driver.findElement(By.cssSelector("div a"));

        //Find the policy link by it's text
        WebElement linkUsingLinkText = driver.findElement(By.linkText("Our Policy"));

        //Find the policy link using part of the links text
        WebElement linkByPartialText = driver.findElement(By.partialLinkText("Policy"));

        driver.quit();
    }

    /**
     * This is how you instruct WebDriver to find many elements from a single selector.
     * A use case for this could be to check how many links/inputs are on a page, be warned though it will return elements that are hidden
     */
    @Test
    public void MultipleElements()
    {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://automationintesting.com/selenium/testpage");

        //The find elements method on the driver will return you a List of WebElements.
        //So we've created our own list called 'inputs' to assign the response from the driver.
        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        //We can use all the locator methods above with FindElements.

        driver.quit();
    }

    /**
     * A common error you'll experience when using WebDriver is NoSuchElementException.
     * Selenium throws this error when it doesn't match any elements based on the locator you provided
     */
    @Test
    public void NoSuchElementExceptionExample()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationintesting.com/selenium/testpage");

        //So if you investigate the above page you'll see that there is no element with this ID, so it should throw an error
        WebElement ElementByID = driver.findElement(By.id("loginBox"));

        //So if you run this test, you will see the following error in the console
        //org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"id","selector":"loginBox"}
        //It's very well written error, and obvious to us what has gone wrong.

        driver.quit();
    }
}
