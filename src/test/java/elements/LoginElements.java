package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
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



    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/actionBarTitle']")
    public MobileElement loginTopTitle;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.ap.philly:id/actionBarBtnClose']")
    public MobileElement closeAction;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.ap.philly:id/emailEdt']")
    public MobileElement email;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/textinput_error']")
    public MobileElement messageEmail;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.ap.philly:id/passwordEdt']")
    public MobileElement password;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.ap.philly:id/passwordEdt']")
    public MobileElement showHidePassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Please enter your password.')]")
    public MobileElement messagePassword;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.ap.philly:id/text_input_password_toggle']")
    public MobileElement showOrHidePasswordIcon;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.ap.philly:id/loginBtn']")
    public MobileElement logInButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/forgotPassword']")
    public MobileElement forgotPasswordLink;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/forgotEmail']")
    public MobileElement forgotEmailLink;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/signUp']")
    public MobileElement signUpLink;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/heading']")
    public MobileElement userLogin;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/heading']")
    public MobileElement networkErrorAlertTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/heading']")
    public MobileElement networkErrorAlertMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/heading']")
    public MobileElement networkErrorAlertOKButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/dialog_message']")
    public MobileElement dialogMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/btnOK']")
    public MobileElement tryAgaindialogButton;


    public static void assertValue(MobileElement element, String expectedValue){
        String actualValue = element.getText().trim();
        Assert.assertEquals(expectedValue,actualValue);
    }


    public static void setValue(MobileElement element, String value){
        element.sendKeys(value);
    }

    public void assertVisible(AppiumDriver appiumDriver, MobileElement element, boolean isVisible){
        boolean isPresent = isElementVisible(appiumDriver, element.getAttribute("xpath") );
        Assert.assertEquals(isVisible, isPresent, "Check element is visible");
    }

    public static void assertFocused(MobileElement element, String trueOrfalse){
        Assert.assertEquals(trueOrfalse, element.getAttribute("focused"), "Check "+element.getText()+" is focused");
    }



    public  boolean isElementVisible(AppiumDriver appiumDriver, String xpath){

        boolean present;
        try {
            appiumDriver.findElement(By.xpath(xpath));
            present = true;
        } catch (Exception e) {
            present = false;
        }
        return  present;
    }
}
