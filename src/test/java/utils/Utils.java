package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import scenarios.AppiumController;

import java.util.HashMap;

public class Utils {
    public static boolean isAndroidPlatform() {
        if (AppiumController.executionOS == AppiumController.OS.ANDROID_BROWSERSTACK
                || AppiumController.executionOS == AppiumController.OS.ANDROID) {
            return true;
        }
        return false;
    }

    public static void iOSScrollToElement(AppiumDriver appiumDriver, MobileElement element, String label) {
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("element", elementID);

        scrollObject.put("predicateString", "label == '" + label + "'");
        appiumDriver.executeScript("mobile:scroll", scrollObject);
    }

    public static void androidScroll(AppiumDriver appiumDriver) {
        appiumDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollIntoView(" +
                        "new UiSelector().index(6))"));

    }
}
