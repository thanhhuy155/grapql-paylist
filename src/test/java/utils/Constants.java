package utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    //Browserstack setup
    public static final String BS_USERNAME = "perriduncan1";
    public static final String BS_ACCESSKEY = "FXQUqgscz3gX5NzxH61k";
    public static final String IOS_HASHED_APP_ID = "e6325a17213d93e920744ee5bd547d40aa8cfe08";
    public static final String ANDROID_HASHED_APP_ID = "63d939ec548d53280a35b43e999f3e03e4ac3776";

    public static final int TIME_OUT = 5;

    public static final String GOOGLEACCOUNT_USERNAME = "testphilly453";
    public static final String GOOGLEACCOUNT_PASSWORD = "testtesttest91";

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
    }

    public static class APP_VERSION {
        public static final String ANDROID = "4.0.1 (58)";
        public static final String IOS = "4.1.0 (139)";
    }

    public static class LABLE {
        public static final String IOS_BOOKMARK_LB = "bookmark feedIcon";
        public static final String IOS_SHARE_LB = " share feedIcon";

    }

}
