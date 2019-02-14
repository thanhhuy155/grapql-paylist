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

    public void TestCaseNo1() {
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

    public void TestCaseNo2() {
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

    public void TestCaseNo3() {
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

    public void TestCaseNo4() {
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

    public void TestCaseNo7() {
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

    public void TestCaseNo11() {
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
        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
    }

}
