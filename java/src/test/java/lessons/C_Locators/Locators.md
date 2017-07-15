## Lesson 3 - Locators
Arguably one of the most important skills when it comes to automating Web Applications is finding good realiable locators. I consider it a real skill.   


A locator is a query that results in 1-N elements being returned to you, majority of the time it'll be a single element. An element being a HTML element from the page such as a input field or an anchor. We can then do actions on the element in order to automate the behaviour we are trying to implement, such as clicking and populating fields.

Fortunately for us, Selenium provide us with many methods to find elements. I'm going to list them below in my personal order of preference.

### ID
This is my preferred approach. The reason being that IDs tend to be unique, meaning that your locator will be realiable, even if the site was redesigned or additional content added.  

The other benefit is that they're also easy to add if they're not present on your application. A quick request to a dev should be enough. I've even added them myself on some projects.
  
The easiest way to find out if an element has an ID is to use the developer tools in a browser, I use Chrome. Find the elment you want to interact with, right-click it and click inspect. This will open Chrome DevTools and take you to where that element is in the HTML. You're then looking for 'ID' attribute of the element. It will   look something like this:

```html
<form id="contactus"></form>
```

You can then use the value inside the ID attribute which in this case is 'contactus' and instruct WebDriver using the 'By.id' method to search for an element with that ID.

```java
Driver.findElement(By.id("contactus"));
```

### Name
Name works exactly like IDs, however name isn't used as much as IDs by developers. So you may not come across many sites that use the name attribute on elements.

But if you do, they tend to be unique and work exactly the same as ID. Find them by inspecting an element and seeing if the name attribute is used, and then use the By.name method.

```java
Driver.findElement(By.name("contactform"));
```

### Class
