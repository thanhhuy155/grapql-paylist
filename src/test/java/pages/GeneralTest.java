package pages;

import elements.ArticleDetailElements;
import elements.CommonElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;
import utils.Utils;

public class GeneralTest extends BasePage {
    private CommonElements commonElements;
    private FeedListElements feedListElements;
    private ArticleDetailElements articleDetailElements;

    public GeneralTest(AppiumDriver driver) {
        super(driver);
        commonElements = new CommonElements(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
    }

    public void TestCaseNo1() {
        turnOffWifi();
        turnOnCellularConnection();
        lauchApp();

        commonElements.settingTabClick();
        commonElements.sectionTabClick();
        commonElements.bookMarkTab.click();

        turnOnWifi();
        closeApp();
    }

    public void TestCaseNo2() {
        turnOffWifi();
        turnOffCellularConnection();
        lauchApp();

        commonElements.settingTabClick();
        commonElements.sectionTabClick();
        commonElements.bookMarkTab.click();

        turnOnWifi();
    }

    public void TestCaseNo3() {
        turnOffWifi();
        turnOffCellularConnection();
        resetApp();
        lauchApp();

        commonElements.settingTabClick();
        commonElements.sectionTabClick();
        commonElements.bookMarkTab.click();

        turnOnWifi();
    }

    public void TestCaseNo4() {
        lauchApp();

        commonElements.sectionTabClick();
        commonElements.settingTabClick();
        commonElements.homeTabClick();

        if(!Utils.isAndroidPlatform()){
            commonElements.searchTabClick();
        }
        commonElements.bookMarkTab.click();
    }

    public void TestCaseNo7() {
        lauchApp();

        lockDevice();
        unLockDevice();
        activateApp();

        waitForVisibilityOf(feedListElements.bottomTab);
        commonElements.sectionTabClick();
        commonElements.homeTabClick();
        commonElements.settingTabClick();
        commonElements.bookMarkTab.click();
    }

    public void TestCaseNo11() {
        lauchApp();

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
