package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.openqa.selenium.support.ui.WebDriverWait;
import scenarios.AppiumController;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePage {
    protected AppiumDriver appiumDriver;

    public BasePage(AppiumDriver driver) {
        this.appiumDriver = driver;
    }

    protected void waitForVisibilityOf(MobileElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, 30);
        webDriverWait.until(visibilityOf(element));
    }

    protected void printLog(String message) {
        System.out.println(message);
    }

    protected void lockDevice() {
        switch (AppiumController.executionOS) {
            case ANDROID:
            case ANDROID_BROWSERSTACK:
                ((AndroidDriver) appiumDriver).lockDevice();
                break;
            case IOS_BROWSERSTACK:
            case IOS:
                //todo
                break;
        }

    }

    protected void unLockDevice() {
        switch (AppiumController.executionOS) {
            case ANDROID:
            case ANDROID_BROWSERSTACK:
                ((AndroidDriver) appiumDriver).unlockDevice();
                break;
            case IOS_BROWSERSTACK:
            case IOS:
                //todo
                break;
        }
    }

    protected void lauchApp() {
        appiumDriver.launchApp();
    }

    protected void closeApp() {
        appiumDriver.closeApp();
    }

    protected void resetApp() {
        appiumDriver.resetApp();
    }


    protected void turnOnWifi() {
        switch (AppiumController.executionOS) {
            case IOS:
            case IOS_BROWSERSTACK:
                //todo
                break;
            case ANDROID_BROWSERSTACK:
            case ANDROID:
                ((AndroidDriver) appiumDriver).setConnection(new ConnectionStateBuilder()
                        .withWiFiEnabled()
                        .build());
                break;
        }
    }

    protected void turnOffWifi() {
        switch (AppiumController.executionOS) {
            case IOS:
            case IOS_BROWSERSTACK:
                //todo
                break;
            case ANDROID_BROWSERSTACK:
            case ANDROID:
                ((AndroidDriver) appiumDriver).setConnection(new ConnectionStateBuilder()
                        .withWiFiDisabled()
                        .build());
                break;
        }
    }

    protected void turnOffCellularConnection() {
        switch (AppiumController.executionOS) {
            case IOS:
            case IOS_BROWSERSTACK:
                //todo
                break;
            case ANDROID_BROWSERSTACK:
            case ANDROID:
                ((AndroidDriver) appiumDriver).setConnection(new ConnectionStateBuilder()
                        .withDataDisabled()
                        .build());
                break;
        }
    }

    protected void turnOnCellularConnection() {
        switch (AppiumController.executionOS) {
            case IOS:
            case IOS_BROWSERSTACK:
                //todo
                break;
            case ANDROID_BROWSERSTACK:
            case ANDROID:
                ((AndroidDriver) appiumDriver).setConnection(new ConnectionStateBuilder()
                        .withDataEnabled()
                        .build());
                break;
        }
    }
}
