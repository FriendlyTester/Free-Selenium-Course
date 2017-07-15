## Lesson 2 - Navigation
So we can open all the popular browsers, now we need to go the websites we are trying to automate.

WebDriver provides us with all the common navigation methods we associate with browsers.  
We can find them on the navigate class, Driver.navigate().

### To
This is used to navigate to a website, pass in the URL you want to navigate to.

```java
Driver.navigate().to("http://google.com");
```

### Back
I rarely use this, but it will act as if you've pressed back on the browser.
```java
Driver.navigate().back();
```

### Forward
I rarely use this, but it will act as if you've pressed forward on the browser.
```java
Driver.navigate().forward();
```

### Refresh
I rarely use this, but it will act as if you've pressed back on the browser.
```java
Driver.navigate().refresh();
```

See [B_Navigation](https://github.com/FriendlyTester/Selenium-WebDriver-Examples/blob/master/java/src/test/java/lessons/B_Navigation/B_Navigation.java) class for a test showing all these methods in action.