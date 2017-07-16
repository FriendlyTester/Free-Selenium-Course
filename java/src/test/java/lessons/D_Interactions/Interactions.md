## Lesson 4 - Interactions
Lets recap. We can now open a browser, navigate to our test site, and find elements on the page that we wish to interactive with. So what are these interactions, what can we do with WebDriver?

This lesson is going to cover the basics.

### click()
This method is as straight forward as it sounds, it will click on the element.  
Note though, WebDriver will only click on elements that are visible, and there is some rather complicated logic to determine if an element in visible. There is a [talk](https://www.youtube.com/watch?v=hTa1KI6fQpg) on this very topic by David Burns one of the selenium contributers.
 
### getText()
This method instructs WebDriver to return the text contained within an element.
```html
<div>
<p>I'm Richard</p>
<span>I created this course</span>
</div>
```

WebDriver will return all the text between the opening tag and the closing tag. So if we took the html above and the following code
```java
Driver.findElement(By.tagName("p")).getText();
```
it would return 'I'm Richard'. As that is all the text between \<p> and \</p>.  
Now if we asked WebDriver to return the text contained in the \<div>, we'd get the contents of the \<p> tag and the \<span>.  
So we'd get  
```text
I'm Richard
I created this course
```

### sendKeys()
The most common usage for SendKeys() is to populate text fields. We can instruct WebDriver to find an input and populate it with our required text.
```java
Driver.findElement(By.id("firstname")).sendKeys("richard");
```
This would result in WebDriver looking for an element with the ID of 'firstname' and if it finds it, it'll try and type 'richard' into it.

We can also use SendKeys() to send actually key presses. For example, if your site does some behaviour after populating some text in a field and pressing enter, we can simulate that with keys.
```java
Driver.findElement(By.id("firstname")).sendKeys(Keys.ENTER);
```

### getAttribute()
This is a fantastic method, even more so in recent years with the additional attributes introduced with HTML5.  
This methods allows you to ask WebDriver to return you the value of any attribute on an element.

The most common usage is probably 'value'. On a input field, this will return yout the text within the input.  
Other common usages are to read the placeholder text to validate a form, get the classes, ID, names of elements. Also as mentioned, to read data attributes which are becoming more common.
```java
Driver.findElement(By.id("firstname")).getAttribute("value");
```
This would look for an element with the id 'firstname', and return the value in the attribute input. Important to note that getText() won't have the same behaviour as this. getText() won't return you the value of an input field. Also, if you investigate this, you'll very rarely see 'value' as an attribute with inspecing some HTML, but trust me, it works.

### Driver Interactions
We also have a few ways in which we can interact with the Driver, or in other terms, the browser itself.  
Those are getTitle() and getCurrentUrl().  

getTitle() - Will return you the text in the tab.
getCurrentUrl() - Does what you're thinking it does, it returns you the URL in the address bar.