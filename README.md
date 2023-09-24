# amazon_automation
Amazon test automation assessment requested by Swivel Group

This project is created based on Selenium, Java, TestNG and Maven technologies.

##Project Structure
* Project framework is based on Page Object Model.
1. Page objects are stored in page folder. (CartPage, LandingPage, ProductPage)
2. Actual test files are stored in test folder.
3. Connection between page files and test files are handled by the function classes.
4. Additionally it has two utility classes.

###Utility classes
1. Background worker - This class holds the background logic of the application. 
   1. Loading the application based on the specified browser
   2. Calculating the product price in the backend
   3. Purpose of this class to reduce the workload of the other classes and handle the backend tasks separately.
2. Property file reader - This class contains methods to read data from external property files.
   1. Property files can be found under the resources folder.
      * config.properties - this file contains configurations related to the browser.
      * testdata.properties - this file contains configuration specified to the test cases.

###Test reports
1. Reports are getting handled by TestNG as default.
2. Emailable HTML report can be found at ./reports 
3. TestNG XML file is located at ./testng.XML


##How to run
1. Clone the application from the Github repository
2. Use IntelliJ idea if possible
3. Install all the maven dependencies
4. Invalidate cache and restart the IDE if it failed to download the dependencies.
5. Once all the dependencies have been downloaded properly, navigate to  /src/test/java/REG_TestAmazonWebApplication
6. The recommended browser for this application is Google Chrome
7. Run the file as a testNG suite

###Running with dynamic data
1. User can change the browser from config.properties file. Valid values are chrome, ie, edge, firefox
2. Apple Safari has been considered as out of the scope.
3. If the browser does not present on the system, then the application will not run.
4. User does not need to download and specify the driver location, it will get handled by the background worker automatically.
5. User can change the name of the book he searches, the quantity as per his wish. 

###Known issues
1. Since this is an ecommerce application, sometimes it might ask to enter a captcha when the page is loading. If that happens, please manually enter the captcha then it will continue the automation job run.
2. Due to microsoft restrictions, it does not allow to use the Microsoft Explorer on some devices. In those scenarios it will open Microsoft Edge instead of IE. So the application might not run as expected since Selenium is waiting for IE but Windows has opened Edge. This cannot be fixed unless we download and install IE driver for Selenium manually. 

###Challenges and issues faced
1. Selecting the checkboxes was an issue at the beginning, but I was able to overcome that with Mouse Actions.
2. Locating the elements and synchronizing the application with the automation tool was the major problem. I had to use some unconditional waits and conditional waits as well.
3. As mentioned earlier captcha was a big issue. But it required to be submitted only once, so currently the user has to enter the captcha manually if that screen appears.
