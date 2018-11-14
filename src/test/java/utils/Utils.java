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
import java.util.Calendar;
import java.util.HashMap;

public class Utils {
    public static boolean isAndroidPlatform() {
        if (AppiumController.executionOS == AppiumController.OS.ANDROID_BROWSERSTACK
                || AppiumController.executionOS == AppiumController.OS.ANDROID) {
            return true;
        }
        return false;
    }

    public static Boolean checkElementExist(MobileElement element){
        Boolean x = false;
        try{
            x = element.isDisplayed();
        }
        finally {
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
        try{
            appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/cardList\").scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"com.ap.philly:id/card_view_article\").instance(1).index(3))"));
        }
        finally {
            System.out.print("Scroll to the end of article");
        }
    }
    public static void scrollToElement(AppiumDriver appiumDriver, MobileElement element){
        do{
            scrollScreen(appiumDriver, DIRECTION.DOWN);
        }while (checkElementExist(element)==false);
    }
    public static void scrollScreen(AppiumDriver appiumDriver, DIRECTION direction ){
        Dimension dimension = appiumDriver.manage().window().getSize();
        int fromX = 0;
        int fromY = 0;
        int endX = 0;
        int endY = 0;
        switch (direction){
            case DOWN:
                endX = (dimension.getWidth())/2;
                endY = (dimension.getHeight())/5;
                fromX = (dimension.getWidth())/2;
                fromY = (dimension.getHeight())-((dimension.getHeight())/4);
                System.out.print("Scroll: "+fromX+"-"+fromY+";"+endX+"-"+endY);
                (new TouchAction(appiumDriver))
                        .press(PointOption.point(fromX,fromY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
                sleep(1500);
                break;
            case UP:
                endX = (dimension.getWidth())/2;
                fromY = (dimension.getHeight())/5;
                fromX = (dimension.getWidth())/2;
                endY = (dimension.getHeight())-fromY;
                System.out.print("Scroll: "+fromX+"-"+fromY+";"+endX+"-"+endY);
                (new TouchAction(appiumDriver))
                        .press(PointOption.point(fromX,fromY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
                sleep(1500);
                break;
            case RIGHT:
                fromX = (int)((dimension.getWidth())*0.9);
                fromY = (dimension.getHeight())/2;
                endX = (int)((dimension.getWidth())*0.05);
                endY = (dimension.getHeight())/2;
                System.out.print("Scroll: "+fromX+"-"+fromY+";"+endX+"-"+endY);
                (new TouchAction(appiumDriver))
                        .press(PointOption.point(fromX,fromY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
                break;
            case LEFT:
                fromX = (int)((dimension.getWidth())*0.05);
                fromY = (dimension.getHeight())/2;
                endX = (int)((dimension.getWidth())*0.9);
                endY = (dimension.getHeight())/2;
                System.out.print("Scroll: "+fromX+"-"+fromY+";"+endX+"-"+endY);
                (new TouchAction(appiumDriver))
                        .press(PointOption.point(fromX,fromY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
                break;
        }

    }
    public static void exampleScroll(AppiumDriver appiumDriver){
        appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/cardList\")).scrollIntoView(new UiSelector().resourceId(\"com.ap.philly:id/card_view_article\").instance(1))"));
    }
    public static MobileElement scrollToElementexample(MobileElement ele, String elementText){
        return ((AndroidElement)ele).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+elementText+"\").instance(0));");

    }
    public static void scrollBySwipe(AppiumDriver appiumDriver){
        appiumDriver.findElements(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ap.philly:id/frameLayout\")).setMaxSearchSwipes(3).scrollIntoView("
                + "new UiSelector().descriptionContains(\"Bookmark IC\"))"));
        //return ele;

    }
    //========================================================================================//

    public static void sleep(long milis){
        try{
            Thread.sleep(milis);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
            throw new RuntimeException(ex);
        }
    }
    public static String getCurrentYear(){
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String yearInString = String.valueOf(year);
        return yearInString;
    }
}
