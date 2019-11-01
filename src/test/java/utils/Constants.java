package utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    //Browserstack setup
    public static final String BS_USERNAME = "perriduncan1";
    public static final String BS_ACCESSKEY = "FXQUqgscz3gX5NzxH61k";

    public static final String IOS_HASHED_APP_ID = "f50b9c084cccdbbc37fa4934b24e20f9b715f24f";
    public static final String ANDROID_HASHED_APP_ID = "8937bc32baade2ca799e84a62936fcdf975a17cd";

    public static final String APP_PACKAGE = "com.ap.philly.test";
    public static final String APP_ACTIVITY = "com.ap.philly.Views.MainActivity";

    public static final int TIME_OUT = 5;

    public static final String GOOGLEACCOUNT_USERNAME = "testphilly453";
    public static final String GOOGLEACCOUNT_PASSWORD = "testtesttest91";

    public static final String LOGIN_EMAIL = "empphilly01@gmail.com";
    public static final String LOGIN_PASSWORD = "Test!1234";

    public static final String SIGN_UP_EMAIL = "SEMP01@gmail.com";

    public static final String SIGN_UP_PASSWORD = "Test1234";


    public static String EXECUTING_SUITE = new String();
    public static int SHORTTIME = 1000;
    public static int MAXNUMBEROPENARTICLE = 100;
    public static int NUMBEROPENARTICLE = (MAXNUMBEROPENARTICLE/2)+1;

    public static final List<String> selectedArticleTitleOnBookmark = new ArrayList<>();

    public static class SETTING_TITLE {
        public static final String TERMS_OF_USE = "Terms of Use";
        public static final String PRIVACY_POLICY = "Privacy Policy";
        public static final String ABOUT_PHILADELPHIA_MEDIA_NETWORK = "About Philadelphia Media Network";

        public static final String THE_PHILADELPHIA_INQUIRER = "The Philadelphia Inquirer";
        public static final String PHILLY_SPORTS_NEWS = "Philly Sports Now: Sports News";
        public static final String THE_PHILADELPHIA_INQUIRER_REPLICA = "The Philadelphia Inquirer Replica";
        public static final String THE_PHILADELPHIA_INQUIRER_REPLICA_NJ_EDITION = "The Philadelphia Inquirer Replica - NJ Edition";
        public static final String THE_PHILADELPHIA_DAILY_NEWS_REPLICA = "The Philadelphia Daily News Replica";
        public static final String VIEW_ACCOUNT_DETAILS = "View Account Settings";
    }

    public static class APP_VERSION {
        public static final String ANDROID = "4.2 (104)";
        public static final String IOS = "4.2 (12)";
    }

    public static class LABLE {
        public static final String IOS_BOOKMARK_LB = "bookmark feedIcon";
        public static final String IOS_SHARE_LB = " share feedIcon";

    }

    public static class LOGIN{
        public  static final String LOG_IN_TITLE = "Log In";
        public  static final String LOG_IN_OR_SIGN_UP = "Log In or Sign Up";
        public  static final String INVALID_EMAIL_ERROR_MESSAGE = "Please enter a valid email address.";
        public  static final String BLANK_EMAIL_ERROR_MESSAGE = "Please enter your email address.";
        public  static final String BLANK_PASSWORD_ERROR_MESSAGE = "Please enter your password.";
        public  static final String ACCOUNT_ERROR_MESSAGE = "The email and password you entered don't match.";
        public  static final String SIGN_UP = "Don’t have an account? Sign up.";

        public  static final String NETWORK_ERROR_TITLE = "Network Error";
        public  static final String NETWORK_ERROR_MESSAGE = "We’re unable to process your request. Please check your connection and try again.";

        public  static final String UNMATCHED_ACCOUNT_DIALOG_MESSAGE= "The email and password you entered don't match.";
        public  static final String TRY_AGAIN_DIALOG_BUTTON= "TRY AGAIN";

        //For got email
        public  static final String FORGOT_EMAIL_MESSAGE = "Please call our customer service at 800-222-2765 and we’ll help you recover your login email address.";
        public  static final String CUSTOMER_SERVICE_NUMBER = "+1 800-222-2765";
        public  static final String CUSTOMER_SERVICE_NUMBER_GALAXY_S8 = "+18002222765";

        //Reset Password screen
        public  static final String FORGOT_EMAIL_ADDRESS_MESSAGE= "If you don’t remember the email address you signed up with, you can call our customer service at 800-222-2765 and we’ll help you recover it.";

        //Forgot Password
        public  static final String FORGOT_PASSWORD_MESSAGE = "Please enter your email address. We will send you an email to reset your password.";

        public  static final String SEND_EMAIL_SUCCESS_MESSAGE = "If the email you entered is registered, we’ve sent you an email to reset your password.";

        //Sign Up
        public  static final String SIGN_UP_TERM_AND_POLICY = "By signing up you indicate that you have read and agree to the Terms of Use and Privacy Policy.";
        public  static final String SIGN_UP_TITLE = "Sign Up";
        public  static  final  String SIGN_UP_EMAIL_ERROR_MESSAGE = "The email address is already registered.";
        public  static  final  String SIGN_UP_PASSWORD_ERROR_MESSAGE = "Passwords don’t match.";
        public  static  final  String SIGN_UP_CONFIRM_PASSWORD_ERROR_MESSAGE = "Please confirm your password.";
    }

    public static class DEVICE_VERSION{
        public  static final String GALAXY_S5_5_0= "5.0";
        public  static final String GALAXY_S8_8_0 = "8.0.0";
        public  static final String GALAXY_NOTE9_8_1 = "8.1";
    }

    public static class CUSTOMIZATION{
        public  static final String BANNER_MESSAGE_ANDROID= "Customize your news feed according to your interests.";
        public  static final String BANNER_MESSAGE_IOS = "Customize your news feed according to your interests →";
    }
}
