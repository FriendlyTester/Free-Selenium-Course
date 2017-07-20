package lessons.F_SelectElement;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class F_SelectElement
{

    @Test
    public void f_SelectElementExamples() {
        WebDriver Driver = new ChromeDriver();
        Driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

        Select selDay = new Select(Driver.findElement(By.id("dropdown")));
        selDay.selectByVisibleText("Option 2");
        System.out.println(selDay.getFirstSelectedOption().getText());

        Driver.quit();
    }
}
