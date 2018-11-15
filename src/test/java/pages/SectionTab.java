package pages;

import elements.ArticleDetailElements;
import elements.CommonElements;
import elements.FeedListElements;
import elements.SectionElements;
import io.appium.java_client.AppiumDriver;
import utils.Constants;
import utils.Utils;

public class SectionTab extends BasePage {
    private FeedListElements feedListElements;
    private SectionElements sectionElements;
    private ArticleDetailElements articleDetailElements;
    private CommonElements commonElements;

    public SectionTab(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        sectionElements = new SectionElements(driver);
        commonElements = new CommonElements(driver);
    }

    public void TestCaseNo2(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();

        sectionElements.clickEachSectionItem(appiumDriver);

    }

    public void TestCaseNo3() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        lockDevice();
        unLockDevice();
    }

    public void TestCaseNo4() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        sectionElements.sectionItemClick();
    }

    public void TestCaseNo6() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        sectionElements.sectionItemClick();
        String title;
        waitForVisibilityOf(feedListElements.feedItemTitle);
        if (Utils.isAndroidPlatform()) {
            title = feedListElements.getFeedItemTitle();
            feedListElements.feedItemTitle.click();
        } else {
            title = feedListElements.feedItemSectionTab.getText();
            feedListElements.feedItemSectionTab.click();
        }

        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());
    }

    public void TestCaseNo8() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        sectionElements.sectionItemClick();

        waitForVisibilityOf(feedListElements.feedItemTitle);
        String title = feedListElements.getFeedItemTitle();
        feedListElements.btnShareOnFeedArticle.click();

        if (Utils.isAndroidPlatform()) {
            if (commonElements.gmail.isDisplayed()==false){
                Utils.scrollScreen(appiumDriver, Utils.DIRECTION.RIGHT);
            }
            commonElements.selectGmail(Constants.GOOGLEACCOUNT_USERNAME,Constants.GOOGLEACCOUNT_PASSWORD);
            commonElements.assertTitleResult(title, sectionElements.getShareGmailTitle());
        } else {

        }
    }

    public void TestCaseNo11() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        sectionElements.sectionItemClick();
        articleDetailElements.back();
    }

    public void TestCaseNo12() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        sectionElements.sectionItemClick();


        lockDevice();
        unLockDevice();

        sectionElements.backToSections.click();

        commonElements.settingTabClick();
        commonElements.homeTabClick();
        commonElements.searchTabClick();
        commonElements.bookMarkTabClick();
    }

}
