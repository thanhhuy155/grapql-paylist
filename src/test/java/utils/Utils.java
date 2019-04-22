package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;
import scenarios.AppiumController;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Utils {
    public static boolean isAndroidPlatform() {
        if (AppiumController.executionOS == AppiumController.OS.ANDROID_BROWSERSTACK
                || AppiumController.executionOS == AppiumController.OS.ANDROID_Emulator
                || AppiumController.executionOS == AppiumController.OS.ANDROID) {
            return true;
        }
        return false;
    }


    public static Boolean checkElementExist(MobileElement element) {
        Boolean x = false;
        try {
            x = element.isDisplayed();
        } finally {
            return x;
        }
    }

    //========================================================================================//
    //SCROLL ACTIONS
    public enum DIRECTION {
        DOWN, UP, LEFT, RIGHT
    }

    public static void iOSScrollToElement(AppiumDriver appiumDriver, MobileElement element, String label) {
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("element", elementID);

        scrollObject.put("predicateString", "label == '" + label + "'");
        appiumDriver.executeScript("mobile:scroll", scrollObject);
    }

    public static void androidScroll(AppiumDriver appiumDriver) {
        try {
            appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/cardList\").scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"com.ap.philly:id/card_view_article\").instance(1).index(3))"));
        } finally {
            System.out.print("Scroll to the end of article");
        }
    }

    public static void scrollToElement(AppiumDriver appiumDriver, DIRECTION direction, MobileElement element) {
        int count = 0;
        int maxLoop = 5;

        do {
            count++;
            scrollScreen(appiumDriver, direction);
        } while (count <= maxLoop && checkElementExist(element) == false);
    }

    public static void scrollScreen(AppiumDriver appiumDriver, DIRECTION direction) {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int fromX = 0;
        int fromY = 0;
        int endX = 0;
        int endY = 0;
        switch (direction) {
            case DOWN:
                endX = (dimension.getWidth()) / 2;
                endY = (dimension.getHeight()) / 5;
                fromX = (dimension.getWidth()) / 2;
                fromY = (dimension.getHeight()) - ((dimension.getHeight()) / 4);
                System.out.print("Scroll: " + fromX + "-" + fromY + ";" + endX + "-" + endY);
                (new TouchAction(appiumDriver))
                        .press(PointOption.point(fromX, fromY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform()

                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)));
//                sleep(1500);
                break;
            case UP:
                endX = (dimension.getWidth()) / 2;
                fromY = (dimension.getHeight()) / 5;
                fromX = (dimension.getWidth()) / 2;
                endY = (dimension.getHeight()) - fromY;
                System.out.print("Scroll: " + fromX + "-" + fromY + ";" + endX + "-" + endY);
                (new TouchAction(appiumDriver))
                        .press(PointOption.point(fromX, fromY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform()
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)));
//                sleep(1500);
                break;
            case RIGHT:
                fromX = (int) ((dimension.getWidth()) * 0.9);
                fromY = (dimension.getHeight()) / 2;
                endX = (int) ((dimension.getWidth()) * 0.05);
                endY = (dimension.getHeight()) / 2;
                System.out.print("Scroll: " + fromX + "-" + fromY + ";" + endX + "-" + endY);
                (new TouchAction(appiumDriver))
                        .press(PointOption.point(fromX, fromY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
                break;
            case LEFT:
                fromX = (int) ((dimension.getWidth()) * 0.05);
                fromY = (dimension.getHeight()) / 2;
                endX = (int) ((dimension.getWidth()) * 0.9);
                endY = (dimension.getHeight()) / 2;
                System.out.print("Scroll: " + fromX + "-" + fromY + ";" + endX + "-" + endY);
                (new TouchAction(appiumDriver))
                        .press(PointOption.point(fromX, fromY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
                break;
        }

    }

    public static void exampleScroll(AppiumDriver appiumDriver) {
        appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/cardList\")).scrollIntoView(new UiSelector().resourceId(\"com.ap.philly:id/card_view_article\").instance(1))"));
    }

    public static MobileElement scrollToElementexample(MobileElement ele, String elementText) {
        return ((AndroidElement) ele).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + elementText + "\").instance(0));");

    }

    public static void scrollBySwipe(AppiumDriver appiumDriver) {
        appiumDriver.findElements(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/frameLayout\")).setMaxSearchSwipes(3).scrollIntoView("
                + "new UiSelector().descriptionContains(\"Bookmark IC\"))"));
        //return ele;

    }
    //========================================================================================//

    public static void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ex);
        }
    }

    public static String getCurrentYear() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String yearInString = String.valueOf(year);
        return yearInString;
    }

    public static void waitForElementVisible(AppiumDriver appiumDriver, MobileElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, 30);
        webDriverWait.until(visibilityOf(element));
    }


    public static String getDeviceVersion(AppiumDriver appiumDriver) {

        //Get version when running on BrowserStack
        if (AppiumController.OS.ANDROID_BROWSERSTACK.equals(AppiumController.executionOS) ||
                AppiumController.OS.IOS_BROWSERSTACK.equals(AppiumController.executionOS)) {
            return appiumDriver.getCapabilities().getCapability("os_version").toString();

        } else {
            return appiumDriver.getCapabilities().getCapability("platformVersion").toString();
        }

    }

    /**
     * Launching Settings app
     *
     * @param appiumDriver
     */
    public static void launchSettingsApp(AppiumDriver appiumDriver) {
        String settingsAppPackageName = "com.android.settings";
        String settingsAppActivityName = "com.android.settings.Settings";

        String currentDeviceVersion = getDeviceVersion(appiumDriver);

        if (Constants.DEVICE_VERSION.GALAXY_S5_5_0.equals(currentDeviceVersion)) {
            settingsAppActivityName = "com.android.settings.GridSettings";

        } else if (Constants.DEVICE_VERSION.GALAXY_S8_8_0.equals(currentDeviceVersion)) {

        } else {
            //Swipe screen before launch Settings app
            scrollScreen(appiumDriver, DIRECTION.UP);
        }

        Activity activity = new Activity(settingsAppPackageName, settingsAppActivityName);
        activity.setStopApp(false);
        ((AndroidDriver<MobileElement>) appiumDriver).startActivity(activity);

        sleep(Constants.SHORTTIME);
    }


    public static String generateEmailAddress() {
        String emailAddress;
        String domainAndExtension = "@philly.com";
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";

        SecureRandom secureRnd = new SecureRandom();
        StringBuilder userNameSB = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            userNameSB.append(alphabetString.charAt(secureRnd.nextInt(alphabetString.length())));
        }
        emailAddress = userNameSB.toString() + domainAndExtension;

        return emailAddress;
    }


    /**
     * Set 'None' for 'Autofill service' in Settings app
     *
     * @param appiumDriver
     */
    public static void turnOffSamsungAutofillService( AppiumDriver appiumDriver){
        String xpathGeneralManagement = "//android.widget.TextView[@text = 'General management']";
        String xpathLanguageandinput = "//android.widget.TextView[@text='Language and input']";
        String xpathAutoFillService = "//android.widget.TextView[@text='Autofill service']";
        String xpathNoneAutoFillService = "(//android.widget.RadioButton)[1]";

        String currentDeviceVersion = Utils.getDeviceVersion(appiumDriver);

        if( !Constants.DEVICE_VERSION.GALAXY_S5_5_0.equals(currentDeviceVersion)) {
            ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
            appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //Launch Settings app
            launchSettingsApp(appiumDriver);
            appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //Set None for Autofill service
            scrollScreen(appiumDriver,DIRECTION.DOWN);
            MobileElement generalManagementElement =  ((AndroidDriver<MobileElement>)appiumDriver).findElement(By.xpath(xpathGeneralManagement));

            if(checkElementExist(generalManagementElement)==false) {
                scrollToElement(appiumDriver, DIRECTION.DOWN, generalManagementElement);
            }

            generalManagementElement.click();
            ((AndroidDriver<MobileElement>)appiumDriver).findElement(By.xpath(xpathLanguageandinput)).click();
            ((AndroidDriver<MobileElement>)appiumDriver).findElement(By.xpath(xpathAutoFillService)).click();
            ((AndroidDriver<MobileElement>)appiumDriver).findElement(By.xpath(xpathNoneAutoFillService)).click();
            ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
        }
    }


}
