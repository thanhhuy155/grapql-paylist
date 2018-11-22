package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import scenarios.AppiumController;
import utils.Constants;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

//import org.aspectj.util.FileUtil;

public class BasePage {
    protected AppiumDriver appiumDriver;

    public BasePage(AppiumDriver driver) {
        this.appiumDriver = driver;
    }

    public void addScreenshotToAllureReport(ITestResult testResult){
        Allure.addAttachment("My attachment", "My attachment content");

        //Path content = Paths.get("path-to-my-attachment-contnet");
        try (InputStream is = Files.newInputStream(takeScreenshotOnFailure(testResult).toPath())) {
            Allure.addAttachment("My attachment", is);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public File takeScreenshotOnFailure(ITestResult testResult){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        SimpleDateFormat formater2 = new SimpleDateFormat("ddMMyyyy");

        if(!(testResult.getStatus()==ITestResult.SUCCESS)){
            String directory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports/Screenshots_"+formater2.format(calendar.getTime());
            //Path screenshotFolder1 = Paths.get(directory);
            File screenshotFolder = new File(directory);
            if(!screenshotFolder.exists()){
                screenshotFolder.mkdir();
            }
            File srcFile = ((TakesScreenshot)appiumDriver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(directory+"/"+testResult.getName()+"_"+formater.format(calendar.getTime())+".png");
            try{
                FileUtils.copyFile(srcFile, destFile);
            }catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print(destFile);
            return destFile;
        }
        return null;
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

    public void lauchApp() {
        appiumDriver.launchApp();
    }

    public void activateApp(){
//        Map<String, Object> params = new HashMap<>();
//        params.put("bundleId", "com.ap.philly");
//        appiumDriver.executeScript("mobile: activateApp", params);
//        String a = appiumDriver.getRemoteAddress().toString();
//        System.out.print("RemoteURL: "+a);
//        appiumDriver.activateApp(a);
        try {
            appiumDriver.runAppInBackground(Duration.ofSeconds(1));
        }catch (Exception e){

        }
        Utils.sleep((Constants.SHORTTIME)*2);
    }

    public void closeApp() {
        appiumDriver.closeApp();
    }

    public void resetApp() {
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
            case IOS_Simulator:
                appiumDriver.runAppInBackground(Duration.ofSeconds(-1));
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
