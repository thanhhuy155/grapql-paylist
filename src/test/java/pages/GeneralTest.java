package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GeneralTest extends BasePage {
    private CommonElements commonElements;
    private FeedListElements feedListElements;
    private ArticleDetailElements articleDetailElements;
    private SettingElements settingElements;
    private ExploreElements exploreElements;

    public GeneralTest(AppiumDriver driver) {
        super(driver);
        commonElements = new CommonElements(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        settingElements = new SettingElements(driver);
        exploreElements = new ExploreElements(driver);
    }

    public void S228_C20166_GN_LA_001_VerifyAppBeAbleToLaunchOnCellConnection() {
        turnOffWifi();
        turnOnCellularConnection();
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTabClick();
        waitForVisibilityOf(settingElements.settingsHeading);
        Assert.assertTrue(Utils.checkElementExist(settingElements.settingsHeading));

        commonElements.sectionTabClick();
        waitForVisibilityOf(exploreElements.headingTitle);
        Assert.assertTrue(Utils.checkElementExist(exploreElements.headingTitle));

        commonElements.bookMarkTab.click();
        Utils.sleep(Constants.SHORTTIME);

        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));

        turnOnWifi();
    }

    public void S228_C20167_GN_LA_002_VerifyAppBeAbleToLaunchWithoutConnectivity() {
        turnOffWifi();
        turnOffCellularConnection();
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTabClick();
        waitForVisibilityOf(settingElements.settingsHeading);
        Assert.assertTrue(Utils.checkElementExist(settingElements.settingsHeading));

        commonElements.sectionTabClick();
        waitForVisibilityOf(exploreElements.headingTitle);
        Assert.assertTrue(Utils.checkElementExist(exploreElements.headingTitle));

        commonElements.bookMarkTab.click();
        Utils.sleep(Constants.SHORTTIME);

        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));

        turnOnWifi();
    }

    public void S228_C20168_GN_LA_003_VerifyAppBeAbleToLaunchWithoutConnectivityAndNoCache() {
        turnOffWifi();
        turnOffCellularConnection();
        resetApp();
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.settingTabClick();
        waitForVisibilityOf(settingElements.settingsHeading);
        Assert.assertTrue(Utils.checkElementExist(settingElements.settingsHeading));

        commonElements.sectionTabClick();
        waitForVisibilityOf(exploreElements.headingTitle);
        Assert.assertTrue(Utils.checkElementExist(exploreElements.headingTitle));

        commonElements.bookMarkTab.click();
        Utils.sleep(Constants.SHORTTIME);

        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));

        turnOnWifi();
    }

    public void S228_C20169_GN_LA_004_VerifyAppBeAbleToLaunchOnWifi() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        waitForVisibilityOf(exploreElements.headingTitle);
        Assert.assertTrue(Utils.checkElementExist(exploreElements.headingTitle));

        commonElements.settingTabClick();
        waitForVisibilityOf(settingElements.settingsHeading);
        Assert.assertTrue(Utils.checkElementExist(settingElements.settingsHeading));

        commonElements.homeTabClick();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        Assert.assertTrue(Utils.checkElementExist(feedListElements.feedItemTitleTopStory));

        if(!Utils.isAndroidPlatform()){
            commonElements.searchTabClick();
        }
        commonElements.bookMarkTab.click();
        Utils.sleep(Constants.SHORTTIME);

        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
    }

    public void S228_C20170_GN_LA_005_VerifyAppBeAbleToLOpenViaComingOutOfSleepMode() {
        lauchApp();

        lockDevice();
        unLockDevice();
        activateApp();

        waitForVisibilityOf(feedListElements.bottomTab);
        commonElements.sectionTabClick();
        waitForVisibilityOf(exploreElements.headingTitle);
        Assert.assertTrue(Utils.checkElementExist(exploreElements.headingTitle));

        commonElements.homeTabClick();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);
        Assert.assertTrue(Utils.checkElementExist(feedListElements.feedItemTitleTopStory));

        commonElements.settingTabClick();
        waitForVisibilityOf(settingElements.settingsHeading);
        Assert.assertTrue(Utils.checkElementExist(settingElements.settingsHeading));

        commonElements.bookMarkTab.click();
        Utils.sleep(Constants.SHORTTIME);

        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.HOME));
    }

    public void _VerifyAppWorksFineWhenClickingOnArticle() {
        lauchApp();
        Utils.sleep(Constants.SHORTTIME);
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        openArticle();
        articleDetailElements.back();

        openArticle();
        articleDetailElements.back();

        openArticle();
        articleDetailElements.back();
    }

    private void openArticle() {
        String title = feedListElements.getFeedItemTopStoryTitle();
        feedListElements.feedItemTopStoryClick();

        if (Utils.isAndroidPlatform()){
            articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
        }else{
            articleDetailElements.assertTitleResult(title, "Article " + articleDetailElements.getTitleArticleDetail());
        }
    }

}
