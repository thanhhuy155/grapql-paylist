package scenarios;

import io.appium.java_client.AppiumDriver;

public class AppiumBaseClass {
    protected AppiumController instance = new AppiumController();

    protected AppiumDriver driver() {
        return instance.driver;
    }
}
