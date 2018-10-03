package pages;

import elements.ArticleDetailElements;
import elements.CommonElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;

public class ArticlePage extends BasePage {
    private ArticleDetailElements articleDetailElements;
    private FeedListElements feedListElements;
    private CommonElements commonElements;

    public ArticlePage(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        commonElements = new CommonElements(driver);
    }


    public void TestCaseNo1() {
        lauchApp();

        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        String title = feedListElements.getFeedItemTitle();
        feedListElements.firstFeedItemSection.click();

        //feedListElements.feedItemTopStoryClick();
        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());

        closeApp();
    }

    public void TestCaseNo5() {
        lauchApp();

        feedListElements.feedItemTopStoryClick();

        lockDevice();
        unLockDevice();
        articleDetailElements.back();

        commonElements.settingTabClick();
        commonElements.sectionTabClick();
        commonElements.homeTabClick();
        commonElements.bookMarkTabClick();

        closeApp();
    }

}
