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
Classes are commonly not unique on a page, but sometimes they are, so, it's a useful option to understand. By.class will search all the elements on the page and return you the first one that has the value provided in the class attribute. 
An important thing to mention with By.class is that you can only ever provide a single class.

```html
<div class="awesomeness"></div>
<div class="very awesome"></div>
<div class="super awesome"></div>
<div class="awesome"></div> 
```

If we take the above HTML, and we want to match the second div, we need to use
```java
Driver.findElement(By.class("very"));
```
If we entered 'very awesome', WebDriver would not find a match, but there is no single class with that value. 'very awesome' is two classes.

If we wanted to get the 4th div, we'd be unable to find is using the By.class method. This is because the 2nd and 3rd div also have the class 'awesome', and WebDriver will return the first match going top down in in the page. So we'd actually get returned the 2nd div.

### TagName
I very rarely use TagName, but it's very straight forward. This will return your the first element in the page that is of the type you specify. So by TagName we mean the type of element, such as div, p, a, input, form etc.

```html
<div>
<form>
<p>Awesome stuff, followed my more stuff</p>
<p>This is awesome, for more awesome click <a href="#">here</a></p>
</form>
</div>
```

So if the above code snippet was my whole page and I want to interact with the form, I could use
```java
Driver.findElement(By.tagName("form"));
```
as it's the only form on the page, means I'll get the correct one. As mentioned though, I use this very rarely, sometimes if a page only has one button I'll use it.

### CSS Selector
