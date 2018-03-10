# How to run tests

From command line:
1. Unzip the file.
2. Open 'clearscore' folder in command line.
3. Run:
gradlew test

It will only work on Windows with Chrome installed.

Manually:
1. Unzip the file.
2. Import gradle project in IDE of your choice.
3. Open class 'RunTest' and run it as a junit test.

# Answers to questions

1. How would you integrate the tests you have written into a continuous integration environment?

I have decided to use Gradle, which is almost ready to be run on Jenkins. Currently I have only Windows laptop at home, I couldn't check it on Mac so this won't probably work on it.
Also I used Chromedriver, thus to make it work on Jenkins it would require Chrome to be installed and path to driver would need to be set differently.

2. How would you make your API test simulate being as realistic a user as possible?

I think using developers tools to record users behavior is a good option to see how endpoints are used during typical session. Becoming a user to understand user behavior makes all tests better, API as well.

3. How would you approach running the same tests across mobile devices and different browsers?

Probably I would look for a tool to handle it, like SauceLabs (https://saucelabs.com). It is compatible with Selenium and can run different browsers with different versions on Windows, Mac and Linux. Also it supports iOS and Android.
