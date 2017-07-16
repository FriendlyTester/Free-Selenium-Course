package lessons.C_Locators;

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
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators");

        //Find the Form using ID
        //The FindElement returns a WebElement object if it finds a match, we are assigning that to our own object called formById
        WebElement formById = Driver.findElement(By.id("contactus"));

        //Find the same Form using Name
        WebElement formByName = Driver.findElement(By.name("contactform"));

        //Find the Dropdown using it's class
        WebElement genderByClass = Driver.findElement(By.className("gender"));

        //Find the only anchor link on the page
        WebElement linkByTag = Driver.findElement(By.tagName("a"));

        //Find the first name input using an XPath from root
        WebElement firstNameFieldByFullXPath = Driver.findElement(By.xpath("/html/body/main/article[1]/div[1]/form[1]/div[1]/div[1]/label[1]/input"));

        //Find the first name input using an XPath starting at the most unique parent
        WebElement firstNameFieldByShortXPath = Driver.findElement(By.xpath("//*[@id=\"contactus\"]/div[1]/div[1]/label[1]/input"));

        //Find the anchor link using a CSS Selector
        WebElement linkUsingCSS = Driver.findElement(By.cssSelector("div a"));

        //Find the policy link by it's text
        WebElement linkUsingLinkText = Driver.findElement(By.linkText("Our Policy"));

        //Find the policy link using part of the links text
        WebElement linkByPartialText = Driver.findElement(By.partialLinkText("Policy"));

        Driver.quit();
    }

    /**
     * This is how you instruct WebDriver to find many elements from a single selector.
     * A use case for this could be to check how many links/inputs are on a page, be warned though it will return elements that are hidden
     */
    @Test
    public void MultipleElements()
    {
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators");

        //The find elements method on the Driver will return you a List of WebElements.
        //So we've created our own list called 'inputs' to assign the response from the Driver.
        List<WebElement> inputs = Driver.findElements(By.tagName("input"));

        //We can use all the locator methods above with FindElements.

        Driver.quit();
    }

    /**
     * A common error you'll experience when using WebDriver is NoSuchElementException.
     * Selenium throws this error when it doesn't match any elements based on the locator you provided
     */
    @Test
    public void NoSuchElementExceptionExample()
    {
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators");

        //So if you investigate the above page you'll see that there is no element with this ID, so it should throw an error
        WebElement ElementByID = Driver.findElement(By.id("loginBox"));

        //So if you run this test, you will see the following error in the console
        //org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"id","selector":"loginBox"}
        //It's very well written error, and obvious to us what has gone wrong.

        Driver.quit();
    }
}
