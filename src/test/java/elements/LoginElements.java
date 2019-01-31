package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import utils.Utils;

public class LoginElements extends BasePage {

    public LoginElements(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/actionBarTitle']")
    public MobileElement actionBarTitle;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.ap.philly:id/actionBarBtnClose']")
    public MobileElement closeActionButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.ap.philly:id/emailEdt']")
    public MobileElement email;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/textinput_error']")
    public MobileElement messageEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Please enter your email address.')]")
    public MobileElement messageEmailForBlank;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Please enter a valid email address.')]")
    public MobileElement messageEmailForInvalid;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.ap.philly:id/passwordEdt']")
    public MobileElement password;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Please enter your password.')]")
    public MobileElement messagePassword;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.ap.philly:id/text_input_password_toggle']")
    public MobileElement showOrHidePasswordIcon;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.ap.philly:id/loginBtn']")
    public MobileElement logInButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Already have an account? Log In.')]")
    public MobileElement logInLink;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/forgotPassword']")
    public MobileElement forgotPasswordLink;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/forgotEmail']")
    public MobileElement forgotEmailLink;

    @AndroidFindBy(xpath = "//android.widget.TextView[(@resource-id='com.ap.philly:id/signUp')]")
    public MobileElement signUpLink;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/heading']")
    public MobileElement userLogin;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/dialog_title']")
    public MobileElement dialogTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/dialog_message']")
    public MobileElement dialogMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/btnOK']")
    public MobileElement tryAgainDialogButton;

    // Reset Password screen
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Please enter your email address. We will send you an email to reset your password.')]")
    public MobileElement informationMessage;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.ap.philly:id/sendEmailBtn']")
    public MobileElement sendEmailButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/resetEmail']")
    public MobileElement resetEmail;


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/resetEmail']")
    public MobileElement forgotEmailMessage;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.ap.philly:id/exitResetEmail']")
    public MobileElement exitResetEmailButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button_once']")
    public MobileElement callJustOnceButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button_always']")
    public MobileElement alwaysButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.android.contacts:id/dialpad_search_frame']")
    public MobileElement dialerWindow;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.android.contacts:id/digits']")
    public MobileElement customerServiceNumber;

    public static void assertValue(MobileElement element, String expectedValue){
        String actualValue = element.getText().trim();
        Assert.assertEquals(actualValue,expectedValue);
    }


    public static void setValue(MobileElement element, String value){
        element.sendKeys(value);
    }

    public void assertVisible(MobileElement element, boolean isVisible){
        boolean actualStatus= Utils.checkElementExist(element);
        Assert.assertEquals(actualStatus,isVisible, "Check element is visible");
    }

    public static void assertFocused(MobileElement element, String trueOrfalse){
        Assert.assertEquals(trueOrfalse, element.getAttribute("focused"), "Check "+element.getText()+" is focused");
    }


    public static void assertShowPasswordIconSelected(MobileElement element, String trueOrFalse){
        String getShowPasswordIconStatus= element.getAttribute("checked");
        Assert.assertEquals(trueOrFalse, getShowPasswordIconStatus, "Check "+ element.getText()+ "is selected");
    }

    /* Use to click Text inside TextView
      Example: Click Sign Up link
      * */
    public static void clickSignUpLink(AppiumDriver appiumDriver, MobileElement element) {
        TouchAction touchAction = new TouchAction(appiumDriver);
        Point point = element.getCenter();
        int pointX= (element.getLocation().getX()+ element.getSize().getWidth())*9/10;
        int pointY= point.getY();

        touchAction.tap(PointOption.point(pointX,pointY)).perform();
    }

    public static void clickCustomerServiceNumber(AppiumDriver appiumDriver, MobileElement element) {
        TouchAction touchAction = new TouchAction(appiumDriver);
        Point point = element.getLocation();
        int pointX= point.x + (int)(0.2 * element.getSize().width);
        int pointY= point.y + element.getSize().height/2;

        touchAction.tap(PointOption.point(pointX,pointY)).perform();
    }
}
