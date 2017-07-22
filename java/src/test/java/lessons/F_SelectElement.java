package lessons;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class F_SelectElement
{

    @Test
    public void f_SelectSingleOptionByText() {
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators/");

        //Create a new Select object called SelGender, we have to pass in a WebElement as a parameter.
        //We know from lesson 3 that findElement() returns a WebElement object, so we can pass that call as the parameter
        Select selGender = new Select(Driver.findElement(By.id("gender")));

        //Ask WebDriver to see if there is an option with the text of 'My Business!'
        selGender.selectByVisibleText("My Business!");

        //Ask WebDriver to gather the text of the firsted selected option in the dropdown.
        //We know this select is NOT a multiple, so there will only be one selected, therefore it will return us the selected option.
        System.out.println(selGender.getFirstSelectedOption().getText());

        Driver.quit();
    }

    @Test
    public void f_SelectSingleOptionByValue() {
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators/");

        Select selGender = new Select(Driver.findElement(By.id("gender")));

        selGender.selectByValue("my_business");
        System.out.println(selGender.getFirstSelectedOption().getText());

        Driver.quit();
    }

    @Test
    public void f_IsMultiple()
    {
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators/");

        //If we visit the site above we can inspect the Gender dropdown and see it's not a multi-select
        //So we'll see false here
        Select selGender = new Select(Driver.findElement(By.id("gender")));
        System.out.println(selGender.isMultiple());

        //If you visit the site above and inspect the continent dropdown, you'll see it is a multi-select
        //So we'll see true here.
        Select selContinent = new Select(Driver.findElement(By.id("continent")));
        System.out.println(selContinent.isMultiple());

        Driver.quit();
    }

    @Test
    public void f_SelectMultipleOptions() {
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators/");

        Select selContinent = new Select(Driver.findElement(By.id("continent")));

        //As we can see in the above check, we know continent is a multi-select, so let's select two options
        selContinent.selectByVisibleText("Africa");
        selContinent.selectByVisibleText("Europe");

        //As per the text guide for lesson, we know this will return all the selected option as WebElements
        //So we've created a List of WebElements and assigned the response to our list
        List<WebElement> selectedOptions=  selContinent.getAllSelectedOptions();

        //This is a simple for loop in Java.
        //It basically means, for every WebElement in the list, execute this block of code.
        //First is the type, we then declare a name, the : means 'in', then our list.
        //So we are saying, for every selected option, get me the text.
        for (WebElement element : selectedOptions)
        {
            System.out.println(element.getText());
        }

        Driver.quit();
    }

    @Test
    public void f_SelectMultipleOptionsDeselectSome() {
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators/");

        Select selContinent = new Select(Driver.findElement(By.id("continent")));

        selContinent.selectByVisibleText("Africa");
        selContinent.selectByVisibleText("Europe");
        selContinent.selectByVisibleText("North America");

        //Select an option using it's value, not the visible text
        selContinent.selectByValue("south_america");

        //We've selected the above four options, so we should see those get printed to the console
        List<WebElement> selectedOptions=  selContinent.getAllSelectedOptions();
        for (WebElement element : selectedOptions)
        {
            System.out.println(element.getText());
        }

        //Deselect an option using the visible text
        selContinent.deselectByVisibleText("Africa");
        //Deselect an option using the value
        selContinent.deselectByValue("north_america");

        //We should now see four results printed out
        List<WebElement> selectedOptionsNow =  selContinent.getAllSelectedOptions();
        for (WebElement element : selectedOptionsNow)
        {
            System.out.println(element.getText());
        }

        Driver.quit();
    }
}