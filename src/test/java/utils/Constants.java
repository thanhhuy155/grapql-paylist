package utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    //Browserstack setup
    public static final String BS_USERNAME = "perriduncan1";
    public static final String BS_ACCESSKEY = "FXQUqgscz3gX5NzxH61k";
    public static final String IOS_HASHED_APP_ID = "050d52cac01da8a38bf3230d82ea82640afcb3dd";
    public static final String ANDROID_HASHED_APP_ID = "bb7af7284d8ae7ab311972ea7495472d0ccde081";

    public static final int TIME_OUT = 5;

    public static final String GOOGLEACCOUNT_USERNAME = "testphilly453";
    public static final String GOOGLEACCOUNT_PASSWORD = "testtesttest91";

    public static final String LOGIN_EMAIL = "empphilly01@gmail.com";
    public static final String LOGIN_PASSWORD = "Test!1234";


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
        public static final String VIEW_ACCOUNT_DETAILS = "View Account Details";
    }

    public static class APP_VERSION {
        public static final String ANDROID = "4.1.0 (62)";
        public static final String IOS = "4.1.0 (143)";
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

        //Reset Password screen
        public  static final String FORGOT_EMAIL_ADDRESS_MESSAGE= "If you don’t remember the email address you signed up with, you can call our customer service at 800-222-2765 and we’ll help you recover it.";

        //Forgot Password
        public  static final String FORGOT_PASSWORD_MESSAGE = "Please enter your email address. We will send you an email to reset your password.";

        public  static final String SEND_EMAIL_SUCCESS_MESSAGE = "If the email you entered is registered, we’ve sent you an email to reset your password.";
    }



}
