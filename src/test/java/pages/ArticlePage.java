package pages;

import elements.ArticleDetailElements;
import elements.BottomBarElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;

public class ArticlePage extends BasePage {
    private ArticleDetailElements articleDetailElements;
    private FeedListElements feedListElements;
    private BottomBarElements bottomBarElements;

    public ArticlePage(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        bottomBarElements = new BottomBarElements(driver);
    }


    public void TestCaseNo1() {
        lauchApp();

        String title = feedListElements.getFeedItemTopStoryTitle();
        feedListElements.feedItemTopStoryClick();
        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());

        closeApp();
    }

    public void TestCaseNo5() {
        lauchApp();

        feedListElements.feedItemTopStoryClick();

        lockDevice();
        unLockDevice();
        articleDetailElements.back();

        bottomBarElements.settingTabClick();
        bottomBarElements.bookMarkTabClick();
        bottomBarElements.sectionTabClick();
        bottomBarElements.homeTabClick();

        closeApp();
    }

}
