# ShareElseWhere plugin for Android/Phonegap
By Shea Clare
Inspired by Share plugin by Kevin Schaul (his README.md is below)

## Using the plugin

### PhoneGap 1.0 and later

* Add the Java class ShareElseWhere.java to the project

* Add the following line to your plugins.xml file:

```xml
<plugin name="ShareElseWhere" value="plugins.shareElseWhere.ShareElseWhere"/>
```

* In the relevant section of Javascript code, invoke the plugin this way:

```javascript
window.plugins.shareElseWhere.show({
        subject: 'I miss EastBound and Down',
            text: 'http://www.youtube.com/watch?v=OFT8FPJOqA4'},
                function() {}, // Success function
                    function() {alert('Share failed')} // Failure function
                    );
```

## Release Notes:

### Initial Release: 23/06/2012

This was originally written for the [Wiktionary Android App](https://play.google.com/store/apps/details?id=org.wiktionary) in March of 2012, but we wound up going a different way. So I'm making it available to you to do with as you please.

## License Information


The MIT License

Copyright (c) 2011 Kevin Schaul

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.


---

***

---


The README.md from Kevin's plugin follows:

# Share plugin for Android/Phonegap
By Kevin Schaul - @foxyNinja7

## Using the plugin

### PhoneGap 1.0 and later

* Add java code to your project's build source

* Register the plugin in the plugins.xml file

```xml
<plugin name="Share" value="com.schaul.plugins.share.Share"/>
```

* Call the plugin, specifying subject, text, success function, and failure function

```javascript
window.plugins.share.show({
        subject: 'I like turtles',
            text: 'http://www.mndaily.com'},
                function() {}, // Success function
                    function() {alert('Share failed')} // Failure function
                    );
```

## Release notes

### 8/22/2011
* Updated for PhoneGap 1.0

### 7/11/2011
* Initial release

## License

The MIT License

Copyright (c) 2011 Kevin Schaul

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
