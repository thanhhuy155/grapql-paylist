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
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AppiumController {
    public static OS executionOS = OS.ANDROID;

    public enum OS {
        ANDROID,
        IOS,
        ANDROID_BROWSERSTACK,
        IOS_BROWSERSTACK,
    }

    public static AppiumController instance = new AppiumController();
    public AppiumDriver driver;

    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (executionOS) {
            case ANDROID:
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app");
                File app = new File(appDir, "app-release.apk");
                capabilities.setCapability("platformName", "Android");
      /*          capabilities.setCapability("platformVersion", "8.1.0");
                capabilities.setCapability("deviceName", "HT72E0201037");*/
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
                app = new File(appDir, "phillydotcom.app");
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", "iPhone 7");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("automationName", "XCUITest");
                driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
                break;
            case ANDROID_BROWSERSTACK:
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("device", "Google Pixel");
                capabilities.setCapability("os_version", "7.1");
                capabilities.setCapability("appPackage", "com.ap.philly");
                capabilities.setCapability("appActivity", "com.ap.philly.Views.MainActivity");
                capabilities.setCapability("browserstack.debug", true);
                capabilities.setCapability("app", "bs://" + Constants.ANDROID_HASHED_APP_ID);
                driver = new AndroidDriver(new URL("https://" + Constants.BS_USERNAME + ":" + Constants.BS_ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
                break;
            case IOS_BROWSERSTACK:
                capabilities.setCapability("device", "iPhone 7 Plus");
                capabilities.setCapability("os_version", "10.3");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("browserstack.debug", true);
                capabilities.setCapability("app", "bs://" + Constants.IOS_HASHED_APP_ID);
                driver = new IOSDriver(new URL("https://" + Constants.BS_USERNAME + ":" + Constants.BS_ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
                break;
        }

        driver.manage().timeouts().implicitlyWait(Constants.TIME_OUT, TimeUnit.SECONDS);

        if (executionOS.equals(OS.IOS) || executionOS.equals(OS.IOS_BROWSERSTACK)) {
            // for click on dialog allow notification in iOS
            IOSElement textButton = (IOSElement) new WebDriverWait(driver, 30).until(
                    elementToBeClickable(MobileBy.AccessibilityId("Allow")));
            textButton.click();
        }
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
