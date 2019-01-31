package scenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AppiumController {
    public static OS executionOS = OS.ANDROID_BROWSERSTACK;

    public enum OS {
        ANDROID,
        IOS,
        ANDROID_BROWSERSTACK,
        IOS_BROWSERSTACK,
        IOS_Simulator,
        ANDROID_Emulator
    }

    public static AppiumController instance = new AppiumController();
    public AppiumDriver driver;

    public void start() throws MalformedURLException {
        if (driver != null) {
            System.out.print("driver: "+driver);
            return;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater2 = new SimpleDateFormat("ddMMyyyy");
        String androidBuild = "Android_SprintF_RegressionTest_"+formater2.format(calendar.getTime());
        //String androidBuild = "Android_SprintC_HotFixBuildRegressionTest_"+formater2.format(calendar.getTime());
        //String androidBuild = "Android_SprintC_RerunFailedTests_"+formater2.format(calendar.getTime());
//        String androidBuild = "AndroidLocalTestBuild";
//        String iOSBuild = "iOSLocalTestBuild";
        String iOSBuild = "iOS_SprintF_RegressionTest_"+formater2.format(calendar.getTime());

        switch (executionOS) {
            case ANDROID:
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app");
                File app = new File(appDir, "phillydotcom.apk");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "7.0");
                capabilities.setCapability("deviceName", "Galaxy J7 Prime");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("appPackage", "com.ap.philly");
                capabilities.setCapability("appActivity", "com.ap.philly.Views.MainActivity");
                driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
                break;
            case IOS:
                classpathRoot = new File(System.getProperty("user.dir"));
                appDir = new File(classpathRoot, "/app");
                app = new File(appDir, "PhillyDotCome.app");
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("platformVersion", "11.4");
                capabilities.setCapability("deviceName", "iPhone X");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("automationName", "XCUITest");
                driver = new IOSDriver(new URL("http://0.0.0.0:4724/wd/hub"), capabilities);
                break;
            case ANDROID_Emulator:
                classpathRoot = new File(System.getProperty("user.dir"));
                appDir = new File(classpathRoot, "/app");
                app = new File(appDir, "phillydotcom.apk");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "8.0");
                capabilities.setCapability("deviceName", "192.168.78.101:5555");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("appPackage", "com.ap.philly");
                capabilities.setCapability("appActivity", "com.ap.philly.Views.MainActivity");
                capabilities.setCapability("noReset", "false");
                capabilities.setCapability("fullReset", "true");
                driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
                break;
            case IOS_Simulator:
                classpathRoot = new File(System.getProperty("user.dir"));
                appDir = new File(classpathRoot, "/app");
                app = new File(appDir, "PhillyDotCom131.app");
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("deviceName", "iPhone 6s");
                capabilities.setCapability("platformVersion", "11.4");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("noReset","true");
                driver = new IOSDriver(new URL("http://0.0.0.0:4724/wd/hub"), capabilities);
                break;
            case ANDROID_BROWSERSTACK:
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("device", "Samsung Galaxy Note 9");
                capabilities.setCapability("os_version", "8.1");
                capabilities.setCapability("appPackage", "com.ap.philly");
                capabilities.setCapability("appActivity", "com.ap.philly.Views.MainActivity");
                capabilities.setCapability("browserstack.debug", true);
                capabilities.setCapability("app", "bs://" + Constants.ANDROID_HASHED_APP_ID);
//                capabilities.setCapability("noReset", "false");
//                capabilities.setCapability("fullReset", "true");
                capabilities.setCapability("build",androidBuild);
                capabilities.setCapability("name",Constants.EXECUTING_SUITE);
                driver = new AndroidDriver(new URL("https://" + Constants.BS_USERNAME + ":" + Constants.BS_ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
                break;
            case IOS_BROWSERSTACK:
                capabilities.setCapability("device", "iPhone 6S Plus");
                capabilities.setCapability("os_version", "11.4");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("browserstack.debug", true);
                capabilities.setCapability("app", "bs://" + Constants.IOS_HASHED_APP_ID);
//                capabilities.setCapability("noReset", "false");
//                capabilities.setCapability("fullReset", "true");
                capabilities.setCapability("build",iOSBuild);
                capabilities.setCapability("name",Constants.EXECUTING_SUITE);
                driver = new IOSDriver(new URL("https://" + Constants.BS_USERNAME + ":" + Constants.BS_ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
                break;
        }

        //driver.manage().timeouts().implicitlyWait(Constants.TIME_OUT, TimeUnit.SECONDS);

        if (executionOS.equals(OS.IOS) || executionOS.equals(OS.IOS_BROWSERSTACK)) {
            // for click on dialog allow notification in iOS
            IOSElement textButton = (IOSElement) new WebDriverWait(driver, 5).until(
                    elementToBeClickable(MobileBy.AccessibilityId("Allow")));
            textButton.click();
        }
        //System.out.print("driver: "+driver);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
