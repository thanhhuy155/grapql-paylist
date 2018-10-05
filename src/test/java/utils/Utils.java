package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import scenarios.AppiumController;

import java.time.Duration;
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

        try{
            appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/cardList\").scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"com.ap.philly:id/card_view_article\").instance(1).index(3))"));
        }
        finally {
            System.out.print("Scroll to the end of article");
        }

        //appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/card_view_article\").instance(0)).scrollIntoView(new UiSelector().index(6))"));
        //appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/card_view_article\").instance(1)).scrollIntoView(new UiSelector().index(3))"));

         //"new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/card_view_article\").instance(8)).getChildByDescription(new UiSelector().className(\"android.widget.ImageView\"), \""+elementText+"\")"));

        //"new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/cardLayoutArticle\").getChildByText(new UiSelector().className(\"android.widget.TextView\"), \""+elementText+"\")"));

        //"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains("+elementText+").instance(0));"
        //"new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollIntoView(new UiSelector().index(6))"));

        //String findPlaylistScript = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+ playlist + "\").instance(0));";
        //return Wait.getInstance().untilPresenceOfElementByAndroidScript(findPlaylistScript, Constant.TIMEOUT_5_SECONDS);

    }
//    public void scroll(AppiumDriver appiumDriver) {
//        Dimension dimensions = appiumDriver.manage().window().getSize();
//        int Startpoint = (int) (dimensions.getHeight() * 0.5);
//        int scrollEnd = (int) (dimensions.getHeight() * 0.5);
//        appiumDriver.swipe(200, Startpoint,200,scrollEnd,2000);
//    }
    public static void scrollByTouchAction(AppiumDriver appiumDriver){
        Dimension dimension = appiumDriver.manage().window().getSize();
        int fromX = (dimension.getWidth())/2;
        int fromY = (dimension.getHeight())-700;
        int endX = (dimension.getWidth())/2;
        int endY = 100;
        System.out.print("Scroll: "+fromX+"-"+fromY+";"+endX+"-"+endY);
        (new TouchAction(appiumDriver))
                .press(PointOption.point(fromX,fromY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();

    }
    public static void scrollHorizontal(AppiumDriver appiumDriver){
        Dimension dimension = appiumDriver.manage().window().getSize();
        int fromX = (dimension.getWidth())/2;
        int fromY = (dimension.getHeight())-200;
        int endX = 0;
        int endY = (dimension.getHeight())-200;
        System.out.print("Scroll: "+fromX+"-"+fromY+";"+endX+"-"+endY);
        (new TouchAction(appiumDriver))
                .press(PointOption.point(fromX,fromY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }
    public static void exampleScroll(AppiumDriver appiumDriver){
        appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/cardList\")).scrollIntoView(new UiSelector().resourceId(\"com.ap.philly:id/card_view_article\").instance(1))"));
    }
    public static MobileElement scrollToElement(MobileElement ele, String elementText){
        return ((AndroidElement)ele).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+elementText+"\").instance(0));");

    }
    public static void scrollBySwipe(AppiumDriver appiumDriver){
        appiumDriver.findElements(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/frameLayout\")).setMaxSearchSwipes(3).scrollIntoView("
                + "new UiSelector().descriptionContains(\"Bookmark IC\"))"));
        //return ele;

    }
}
