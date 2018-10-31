package scenarios;

import io.appium.java_client.AppiumDriver;

public class AppiumBaseClass {
    public static AppiumDriver driver() {
        return AppiumController.instance.driver;
    }
}
