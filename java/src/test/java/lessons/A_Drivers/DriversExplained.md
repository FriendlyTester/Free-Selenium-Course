## Drivers Lesson

All the browsers now require a driver in order to send and receive WebDriver commands.  
These are now all maintained by the browsers vendors (IE being the exception).

Examples of all of the above can be found in the [A_Driver](https://github.com/FriendlyTester/Selenium-WebDriver-Examples/blob/master/java/src/test/java/lessons/A_Drivers/A_Drivers.java) class.

### Setting up Drivers
Before I tell you where to find all the drivers you'll need, I want to tell you how you use them.
There are many ways to inform Selenium on the location of the drivers. Choose the one that works best for you.

* [PATH](https://stackoverflow.com/questions/44272416/how-to-add-a-folder-to-path-environment-variable-in-windows-10-with-screensho), on a windows machine we can add the full path to the ChromeDriver.exe to our environment variables PATH.
* Bin folders. On a Mac we can add the Drivers to either /usr/bin or /usr/bin/local.
* Specific to Java, we can also set system properties to instruct Selenium on the path of the driver
* You can also you Driver options, we're going to look at them in another lesson.

### Chrome
We'll start with Chrome, as that is currently my default browser.  
In order to automate Chrome you need to download [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads).  
Make sure you download the correct version for your machine.

If you're going to use the system property approach the key is called '_webdriver.chrome.driver_'.

### Firefox
In order to automate Firefox you need the [GeckoDriver](https://github.com/mozilla/geckodriver/releases).

If you're going to use the system property approach the key is called '_webdriver.gecko.driver_'.


### SafariDriver
In order to automate Safari you don't need to download a driver! It's already included in MacOS. But you do need to enable some settings, I've listed those [here](https://github.com/FriendlyTester/Selenium-WebDriver-Examples/blob/master/java/src/test/java/drivers/SafariDriver.md).

### Edge
To automate EDGE, firstly you need to be on a Windows 10 machine, and download the [EDGEDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)

If you're going to use the system property approach the key is called '_webdriver.edge.driver_'.

### Internet Explorer
To automate IE, you firstly have to say a huge thanks to [Jim Evans](https://twitter.com/jimevansmusic)!  
You then need to download the [IEDriver](https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver).

If you're going to use the system property approach the key is called '_webdriver.ie.driver_'.