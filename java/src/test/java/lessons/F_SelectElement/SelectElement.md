### Select Elements TEST

[**Full Code Examples**](../F_SelectElement/F_SelectElement.java)

As many of you will be aware, they are numerous controls out there on the internet these days. By controls I mean things like Select Elements, Radio Buttons, Mutli Select Elements and many many more. Far too many for WebDriver to offer easy support for. However they have made it easy for us to interact with Select elements. Or Dropdowns as I prefer to call them. 

They've made it easy for us by creating a class representation of a dropdown. We can initiate one like this
```java
Select selGender = new Select(Driver.findElement(By.id("gender")));
``` 
The object created for us by Selenium is called Select. So we're making a our own instance of it, and calling it selGender. This is my preferred naming convention.

We then instruct java to create a new Select object. You'll see that the Select object takes a parameter, that parameter is  WebElement. We've covered those in the Locator lessons.

So we need to tell WebDriver how to find our Select element on the page. In the instance above I'm using an ID. But you can use any of the locator strategies we covered in the the Locators lesson.

We can now take advantage of all the methods the Selenium team have created for us.

### getFirstSelectedOption()
This will return the first selected option in the dropdown. In most cases your select is probably single select, so this will return the selected option to you.

### selectByVisibleText()
If you're not familiar with Selects in HTML, they have two values. The first value tends to be used by the application, and the second value is what the user sees on the screen. A common pattern and a good example of this is language dropdowns. The value will be something like 'en-GB' but the text will be 'British'.

```html
        <select id="language" class="gender">
          <option value="en-gb">British</option>
          <option value="en-us">American English</option>
          <option value="fr">French</option>
        </select>
```
So in this code example we could select British by using the following code
```java
selGender.selectByVisibleText("British");
```
This is the most common method I use to select values though, as this is what the user will be seeing.

### selectByValue()
Take the same code above, we could select British by using
```java
selGender.selectByValue("en-gb");
```

### selectByIndex()
You can instruct WebDriver to select the 2nd item in the Dropbox. Could be useful for checking the order of values in the dropdown.
```java
selGender.selectByIndex(2);
```

### getOptions
This is a nice method. It will return you a list of all the options in the dropdown. Again could for testing all the options that should be there, are indeed there.  
It returns you a list of WebElements, so behaves the same as FindElements() from our lesson on Locators.

```java
List<WebElements> genderOptions = selGender.getOptions();
```

### getAllSelectionOptions
Behaves exactly like the method above, but if the Select was a multi-select it would return you all the selected options.

### isMultiple
This will return you a True or False, based on whether the dropdown is multi-select or not.

### deselectByVisibleText
This will do what it says, I've only ever need to use this on multi-selects.

### deselectAll, deselectByIndex, deselectByValue
This again will do what they same, follow the same pattern as the select examples above. 
