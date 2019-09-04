package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import utils.Constants;
import utils.Utils;

public class LoginElements extends BasePage {

    public LoginElements(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Philly.com']")
    public MobileElement phillyApp;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText)[2]")
    @AndroidFindBy(id = "actionBarTitle")
    public MobileElement actionBarTitle;

    @iOSFindBy(id =  "Reset Password")
    public MobileElement resetPasswordTitle;

    @iOSFindBy(id =  "Sign Up")
    public MobileElement signUpTitle;

    @iOSFindBy(id =  "Cancel")
    @AndroidFindBy(id = "actionBarBtnClose")
    public MobileElement closeActionButton;


    @iOSFindBy(id =  "Call")
    public MobileElement callButton;


    @iOSFindBy(id =  "Cancel")
    public MobileElement cancelButton;


    @iOSFindBy(id =  "End")
    public MobileElement endCallButton;


    @iOSFindBy(id =  "OK")
    public MobileElement OKButton;


    @iOSFindBy(xpath = "//XCUIElementTypeButton[contains(@label, 'arrowBackOnLight')]")
    public MobileElement backButton;


    @iOSFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "emailEdt")
    public MobileElement email;


    @iOSFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "textinput_error")
    public MobileElement messageEmail;


    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Please enter a valid email address.')]")
    public MobileElement messageEmailForInvalid;


    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[1]")
    @AndroidFindBy(id = "passwordEdt")
    public MobileElement password;


    @iOSFindBy(xpath = "//XCUIElementTypeTextField[2]")
   // @iOSFindBy(xpath = "//XCUIElementTypeTextField[contains(@value,'Test!1234')]")
    public MobileElement passwordValue;


    @iOSFindBy(xpath = "//XCUIElementTypeTextField[1]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Please enter your password.')]")
    public MobileElement messagePassword;


    @iOSFindBy(id= "invisibilityShow")
    @AndroidFindBy(id = "text_input_password_toggle")
    public MobileElement showOrHidePasswordIcon;


    @iOSFindBy(xpath = "(//XCUIElementTypeButton)[3]")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton)[1]")
    public MobileElement signUpShowOrHiddenPasswordIcon;


    @iOSFindBy(xpath = "(//XCUIElementTypeButton)[5]")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton)[2]")
    public MobileElement signUpShowOrHiddenConfirmPasswordIcon;


    @iOSFindBy(id=  "LOG IN")
    @AndroidFindBy(id = "loginBtn")
    public MobileElement logInButton;


    @iOSFindBy(id = "Log In.")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Already have an account? Log In.')]")
    public MobileElement logInLink;


    @iOSFindBy(id=  "Forgot password?")
    @AndroidFindBy(id = "forgotPassword")
    public MobileElement forgotPasswordLink;


    @iOSFindBy(id = Constants.LOGIN.FORGOT_PASSWORD_MESSAGE)
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.ap.philly.test:id/layout_reset_password_item']/android.widget.LinearLayout[@resource-id='com.ap.philly.test:id/container']/android.widget.TextView")
    public MobileElement forgotPasswordMessage;


    @iOSFindBy(id = "SEND EMAIL")
    @AndroidFindBy(id = "sendEmailBtn")
    public MobileElement sendEmailButton;


    @iOSFindBy(id = "passwordSuccess")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.ImageView")
    public MobileElement successImage;


    @iOSFindBy(id = Constants.LOGIN.SEND_EMAIL_SUCCESS_MESSAGE)
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView")
    public MobileElement successMessage;


    @iOSFindBy(id=  "Forgot email?")
    @AndroidFindBy(id = "forgotEmail")
    public MobileElement forgotEmailLink;


    @iOSFindBy(id = "Sign Up.")
    @AndroidFindBy(id = "signUp")
    public MobileElement signUpLink;


    @iOSFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]")
    @AndroidFindBy(id = "validate_layout")
    public MobileElement validatePassword;


    @iOSFindBy(id = "At least 8 characters")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='At least 8 characters']")
    public MobileElement validateMinCharacters;


    @iOSFindBy(id = "Lower case letters")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lower case letters']")
    public MobileElement validateLowercase;


    @iOSFindBy(id = "Upper case letters")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Upper case letters']")
    public MobileElement validateUppercase;


    @iOSFindBy(id = "Numbers")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Numbers']")
    public MobileElement validateNumber;


    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[2]")
    @AndroidFindBy(id = "confirmPasswordEdt")
    public MobileElement confirmPassword;

    @iOSFindBy(xpath = "//XCUIElementTypeTextField[3]")
    public MobileElement confirmPasswordValue;

    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[2]")
    @AndroidFindBy(id = "textinput_error")
    public MobileElement messageConfirmPassword;


    @iOSFindBy(id = "SIGN UP")
    @AndroidFindBy(id = "signUpBtn")
    public MobileElement signUpButton;


    @iOSFindBy(xpath = " //XCUIElementTypeTextView")
    @AndroidFindBy(id = "termAndPolicy")
    public MobileElement termAndPolicy;


    @AndroidFindBy(id = "dialog_title")
    public MobileElement dialogTitle;


    @iOSFindBy(id = "The email and password you entered don't match.")
    @AndroidFindBy(id = "dialog_message")
    public MobileElement dialogMessage;


    @iOSFindBy(id=  "TRY AGAIN")
    @AndroidFindBy(id = "btnOK")
    public MobileElement tryAgainDialogButton;


    @iOSFindBy(xpath = "//XCUIElementTypeTextView")
    @AndroidFindBy(id = "resetEmail")
    public MobileElement forgotEmailMessage;


    @iOSFindBy(id = "closeOnLight")
    @AndroidFindBy(id = "exitResetEmail")
    public MobileElement exitResetEmailButton;


    @AndroidFindBy(id = "dialpad_search_frame")
    public MobileElement dialerWindow;


    @iOSFindBy(xpath = "//XCUIElementTypeLink")
    @AndroidFindBy(id = "digits")
    public MobileElement customerServiceNumber;


    @AndroidFindBy (xpath = "//android.view.View[contains(@text,'Privacy Policy & Terms of Use')]")
    public MobileElement termsOfService;


    @AndroidFindBy (xpath = "//android.view.View[contains(@text,'PRIVACY POLICY')]")
    public MobileElement privacyPolicy;

    public static void assertValue(MobileElement element, String expectedValue){
        String actualValue = element.getText().trim();
        Assert.assertEquals(actualValue,expectedValue);
    }


    public static void setValue(MobileElement element, String value){
        element.clear();
        element.setValue(value);
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

    /**
     * Click on Sign Up link inside in Text View at bottom
     * @param appiumDriver
     * @param element
     */
    public static void clickSignUpLink(AppiumDriver appiumDriver, MobileElement element) {
        TouchAction touchAction = new TouchAction(appiumDriver);
        Point point = element.getCenter();

        int pointX= (element.getLocation().getX()+ element.getSize().getWidth())*9/10;
        int pointY= point.getY();

        touchAction.tap(PointOption.point(pointX,pointY)).perform();
    }

    /**
     * Click on Customer Service Number link inside in Text View
     * @param appiumDriver
     * @param element
     */
    public static void clickCustomerServiceNumber(AppiumDriver appiumDriver, MobileElement element) {
        TouchAction touchAction = new TouchAction(appiumDriver);
        Point point = element.getLocation();
        int pointX= point.x + (int)(0.2 * element.getSize().width);
        int pointY= point.y + element.getSize().height/2;

        touchAction.tap(PointOption.point(pointX,pointY)).perform();
    }

    /**
     * Click outside field to hidden keyboard
     * @param appiumDriver
     * @param element
     */
    public void hiddenKeyboard(AppiumDriver appiumDriver, MobileElement element){
        Point keyboardPoint = element.getLocation();
        TouchAction touchAction = new TouchAction(appiumDriver);
        int pointX= keyboardPoint.getX() +2;
        int pointY= keyboardPoint.getY() -2;
        touchAction.tap(PointOption.point(pointX,pointY)).perform();
    }


    /**
     * Click on Sign Up link inside in Text View at bottom
     * @param appiumDriver
     * @param element
     */
    public static void clickTermOfUseLink(AppiumDriver appiumDriver, MobileElement element) {
        TouchAction touchAction = new TouchAction(appiumDriver);
        Point point1 = element.getLocation();
        System.out.println("x: "+ point1.getX()+", y: "+point1.getY());
        System.out.println("height: "+ element.getSize().height+", width: "+ element.getSize().width);

        int x1 = point1.x - (int)(1.3*element.getSize().height);
        int y1 = point1.y /2;

        System.out.println("x1: "+ x1+", y1: "+y1);

        touchAction.tap(PointOption.point(x1, y1)).perform();

    }


    /**
     * Click on Sign Up link inside in Text View at bottom
     * @param appiumDriver
     * @param element
     */
    public static void clickPrivacyPolicyLink(AppiumDriver appiumDriver, MobileElement element) {
        TouchAction touchAction = new TouchAction(appiumDriver);
        Point point = element.getCenter();
        int pointX= (element.getLocation().getX()+ element.getSize().getWidth())*9/10;
        int pointY= point.getY();

        touchAction.tap(PointOption.point(pointX,pointY)).perform();
    }
}