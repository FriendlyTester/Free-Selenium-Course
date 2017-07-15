package lessons.C_Locators;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C_Locators
{
    /**
     * See if you can visit the URL below and understand why these selectors work.
     */
    @Test
    public void c_AllLocators()
    {
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators");

        //Find the Form using ID
        Driver.findElement(By.id("contactus"));

        //Find the same Form using Name
        Driver.findElement(By.name("contactform"));

        //Find the Dropdown using it's class
        Driver.findElement(By.className("gender"));

        //Find the only anchor link on the page
        Driver.findElement(By.tagName("a"));

        //Find the first name input using an XPath from root
        Driver.findElement(By.xpath("/html/body/main/article[1]/div[1]/form[1]/div[1]/div[1]/label[1]/input"));

        //Find the first name input using an XPath starting at the most unique parent
        Driver.findElement(By.xpath("//*[@id=\"contactus\"]/div[1]/div[1]/label[1]/input"));

        //Find the anchor link using a CSS Selector
        Driver.findElement(By.cssSelector("div a"));

        //Find the policy link by it's text
        Driver.findElement(By.linkText("Our Policy"));

        //Find the policy link using part of the links text
        Driver.findElement(By.partialLinkText("Policy"));

        Driver.quit();
    }
}
