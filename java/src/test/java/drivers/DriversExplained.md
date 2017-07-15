All the browsers now require a driver in order to send and receive WebDriver commands.<br>
These are now all maintained by the browsers vendors (IE being the exception). <br>
You can find the drivers here:
 * [Chrome](https://sites.google.com/a/chromium.org/chromedriver/downloads)
 * [Firefox](https://github.com/mozilla/geckodriver/releases)
 * [Edge](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)
 * [SafariDriver](https://developer.apple.com/library/content/releasenotes/General/WhatsNewInSafari/Articles/Safari_10_0.html#//apple_ref/doc/uid/TP40014305-CH11-SW31)
 * [IEDriver](https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver)

 We have to instruct WebDriver of the locations of these drivers on our machine, we have several options to do this:
 * [PATH](https://stackoverflow.com/questions/44272416/how-to-add-a-folder-to-path-environment-variable-in-windows-10-with-screensho) - On windows we can add the location of each driver to the PATH
 * On A MacOS we can put the driver executable in /usr/bin or /usr/local/bin
 * In Java we can set a system porperty to the driver location
 * We can also use Driver Options, which we'll cover at a later date.
 
 Examples of all of the above can be found in the [A_Driver](https://github.com/FriendlyTester/Selenium-WebDriver-Examples/blob/master/java/src/test/java/drivers/A_Driver.java) class.