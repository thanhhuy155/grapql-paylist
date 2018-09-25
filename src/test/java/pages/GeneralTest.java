package pages;

import elements.ArticleDetailElements;
import elements.BottomBarElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;
import utils.Utils;

public class GeneralTest extends BasePage {
    private BottomBarElements bottomBarElements;
    private FeedListElements feedListElements;
    private ArticleDetailElements articleDetailElements;

    public GeneralTest(AppiumDriver driver) {
        super(driver);
        bottomBarElements = new BottomBarElements(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
    }

    public void TestCaseNo1() {
        turnOffWifi();
        turnOnCellularConnection();
        lauchApp();

        bottomBarElements.settingTabClick();
        bottomBarElements.sectionTabClick();
        bottomBarElements.bookMarkTabClick();

        closeApp();
        turnOnWifi();
    }

    public void TestCaseNo2() {
        turnOffWifi();
        turnOffCellularConnection();
        lauchApp();

        bottomBarElements.settingTabClick();
        bottomBarElements.sectionTabClick();
        bottomBarElements.bookMarkTabClick();

        closeApp();
        turnOnWifi();
    }

    public void TestCaseNo3() {
        turnOffWifi();
        turnOffCellularConnection();
        resetApp();
        lauchApp();

        bottomBarElements.settingTabClick();
        bottomBarElements.sectionTabClick();
        bottomBarElements.bookMarkTabClick();

        closeApp();
        turnOnWifi();
    }


    public void TestCaseNo4() {
        lauchApp();

        bottomBarElements.sectionTabClick();
        bottomBarElements.settingTabClick();
        bottomBarElements.homeTabClick();

        if(!Utils.isAndroidPlatform()){
            bottomBarElements.searchTabClick();
        }
        bottomBarElements.bookMarkTabClick();
        closeApp();
    }

    public void TestCaseNo7() {
        lauchApp();

        lockDevice();
        unLockDevice();

        bottomBarElements.sectionTabClick();
        bottomBarElements.homeTabClick();
        bottomBarElements.settingTabClick();
        bottomBarElements.bookMarkTabClick();

        closeApp();
    }

    public void TestCaseNo11() {
        lauchApp();

        openArticle();
        articleDetailElements.back();

        openArticle();
        articleDetailElements.back();

        openArticle();
        articleDetailElements.back();

        closeApp();
    }

    private void openArticle() {
        String title = feedListElements.getFeedItemTopStoryTitle();
        feedListElements.feedItemTopStoryClick();
        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
    }

}
