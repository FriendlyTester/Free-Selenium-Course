package lessons;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class E_Screenshots
{

    @Test
    public void e_TakeAScreenshot() throws IOException
    {
        WebDriver Driver = new ChromeDriver();
        Driver.manage().window().maximize();
        Driver.navigate().to("https://thefriendlytester.co.uk/selenium/locators");

        //This code may look complicated, and based on what we've done so far, it is. But let's walk over it.
        //We start by creating a File object. This is object from the Java library. Basically a class representation of a file on your disk
        //We are then 'casting' our Driver on to the TakesScreenshot 'interface', which gives our Driver access to the getScreenshotAs() method
        //You can just accept this codes works, but I encourage you to explore casting and interfaces.
        File scrFile = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);

        //We now have a file on our machine, but it will be in some crazy place, you can do scrFile.getAbsolutePath() to find out where, but it doesn't really matter to us
        //What we'll do instead is make a copy of the file, and put in a directory we want it to be, along with a contextual name.

        //Here is how we do this on a Windows machine. We have to escape the \ by using \\
        //FileUtils.copyFile(scrFile, new File("C:\\Users\\IEUser\\Desktop\\locator_form.jpg"));

        //Mac
        FileUtils.copyFile(scrFile, new File("/Users/richard/Desktop/locator_form_firefox.jpg"));

        Driver.quit();
    }
}