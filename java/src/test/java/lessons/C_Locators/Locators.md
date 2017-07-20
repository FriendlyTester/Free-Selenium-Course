## Lesson 3 - Locators

[**Full Code Examples**](../C_Locators/C_Locators.java)

Arguably one of the most important skills when it comes to automating Web Applications is finding good realiable locators. I consider it a real skill.   

A locator is a query that results in 1-N elements being returned to you, majority of the time it'll be a single element. An element being a HTML element from the page such as a input field or an anchor. We can then do actions on the element in order to automate the behaviour we are trying to implement, such as clicking and populating fields.

Fortunately for us, Selenium provide us with many methods to find elements. I'm going to list them below in my personal order of preference. Working code examples can be found [here](https://github.com/FriendlyTester/Selenium-WebDriver-Examples/blob/master/java/src/test/java/lessons/C_Locators/C_Locators.java).

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

### CSS Selector
This is the first that is slightly different from the other selectors. CSS Selectors allow us to send a query to WebDriver. So instead of saying find an element by ID, we can be very specific, or instruct WebDriver to follow a pattern. If I can't find an element directly with something unique I'll always turn to a CSS Selector. There isn't an element I can't find with CSS Selectors.

So lets look at an example, as I feel it'll be a lot clearer than me trying to explain. 
```html
<form id="awesomeform">
<p class="firstparagraph">Awesome stuff, followed my more stuff</p>
<p>This is awesome, for more awesome click <a href="#">here</a></p>
</form>
</div>
<div>
<p>This is awesome, for more awesome click <a href="#">here</a></p>
```
So lets say the above code is our page, and I want to click the first link. It has no ID, no name, no class, there is another link on the page so I can't use tagname, so I turn to CSS Selector.

A good heuristic in this situation is to ask the question, 'does my parent have anything unique?', and keep asking your self this until the answer is YES! Once you have a yes, you can create your query starting there.  
So in the case of our code above, the parent of our anchor is a P, but it has nothing unique. Our next parent is a form, which again has nothing unique. Above that though we have a div that has a class.

So we can construct a CSS Selector stating there, it would like this
```java
Driver.findElement(By.cssSelector("#awesomeform p a"));
```
So lets see what this actually means. The first part is the syntax needed to match by ID, so we are saying find an element with the ID of 'awesomeform', which know is our form. Then look at the children of that form for a P element. That's what the space means, it means look at my children. Then from the P I'm looking for a anchor.  

We could also use
```java
Driver.findElement(By.cssSelector("#awesomeform a"));
```
this is where in my opinion CSS Selectors have the advantage over XPaths. This locator would also return the anchor. This is because CSS Selectors will look at all the children looking for a match, not just the immediate child.
  
CSS Selectors are awesome, and very powerful. There is too much for me to list in this post, I may add a more in depth post in the future, but for now here is an awesome game you can play to master CSS Selectors, it's called [FlukeOut](http://flukeout.github.io/).

A nice tip when creating CSS Selectors is to try them out within Chrome DevTools, you can do this in the console window with the following format
```jshint
$('#awesomediv form p a');
```

### ClassName
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
Driver.findElement(By.className("very"));
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

### LinkText
This does pretty much exactly what it says, it will look at all the anchor tags on the a page and see if the text of them matches your query.
```html
<a href="#">here</a>
```
```java
Driver.findElement(By.linkText("here"));
```
It wll return the first one that matches the text. I have actually used this a fair amount, mostly on navigation menus.

### PartialLinkText
This does pretty much exactly what it says, it will look at all the anchor tags on the a page and see if the text of them partially matches your query.
```html
<a href="#">Your Profile</a>
```
```java
Driver.findElement(By.partialLinkText("profile"));
```
It wll return the first one that matches the text. 

### XPath
Why is XPath at the bottom Richard! XPaths are strict. You have to specify each node in the tree, which makes it very fragile, especially in a fast paced product. On the plus side XPaths do allow us to send a query to WebDriver.

Lets take the same example from above 
```html
<div id="awesomediv">
<form>
<p class="firstparagraph">Awesome stuff, followed my more stuff</p>
<p>This is awesome, for more awesome click <a href="#">here</a></p>
</form>
</div>
<div>
<p>This is awesome, for more awesome click <a href="#">here</a></p>
</div>
```
My XPath for this would be
```java
Driver.findElement(By.XPath("//*[@id="divprofile"]/form[1]/p[2]/a"));
```
First thing to point out, it's proper ugly! But it does exactly the same thing. However it's behaviour is somewhat different. You'll notice the numbers after each element. That numbers represents which child it is.  
So if we added another P element to the code above the current two Ps, the XPath would break. Because now the P we require is now number 3. This wouldn't break the CSS locator.

XPaths grew to be very popular because they were commonly used with Selenium IDE and also most browsers have an option on an inspected element to 'Copy XPath'. Now sure this is nice and quick, but it's very important to understand the locator, and make a judgement on it's liklihood to be impacted by the rest of the page. If it's a really long XPath query on a page which sees a lot of change, XPath would not be a good choice. 