package lessons.F_SelectElement;

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

        Select selGender = new Select(Driver.findElement(By.id("gender")));

        selGender.selectByVisibleText("My Business!");
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

        Select selGender = new Select(Driver.findElement(By.id("gender")));
        System.out.println(selGender.isMultiple());

        Select selContinent = new Select(Driver.findElement(By.id("continent")));
        System.out.println(selContinent.isMultiple());

        Driver.quit();
    }

    @Test
    public void f_SelectMultipleOptions() {
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators/");

        Select selContinent = new Select(Driver.findElement(By.id("continent")));

        selContinent.selectByVisibleText("Africa");
        selContinent.selectByVisibleText("Europe");

        List<WebElement> selectedOptions=  selContinent.getAllSelectedOptions();
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
        selContinent.selectByVisibleText("South America");

        List<WebElement> selectedOptions=  selContinent.getAllSelectedOptions();
        for (WebElement element : selectedOptions)
        {
            System.out.println(element.getText());
        }

        selContinent.deselectByVisibleText("Africa");
        selContinent.deselectByValue("north_america");

        List<WebElement> selectedOptionsNow =  selContinent.getAllSelectedOptions();
        for (WebElement element : selectedOptionsNow)
        {
            System.out.println(element.getText());
        }

        Driver.quit();
    }
}