package pages;

import elements.ArticleDetailElements;
import elements.CommonElements;
import elements.FeedListElements;
import elements.SectionElements;
import io.appium.java_client.AppiumDriver;
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

    public void TestCaseNo3() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        lockDevice();
        unLockDevice();

        closeApp();
    }

    public void TestCaseNo4() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        sectionElements.sectionItemClick();

        closeApp();
    }

    public void TestCaseNo6() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        sectionElements.sectionItemClick();
        String title;
        if (Utils.isAndroidPlatform()) {
            title = feedListElements.getFeedItemTitle();
            feedListElements.feedItemClick();
        } else {
            title = feedListElements.feedItemSectionTab.getText();
            feedListElements.feedItemSectionTab.click();
        }

        articleDetailElements.assertTitleResult(title, articleDetailElements.getTitleArticleDetail());

        closeApp();
    }

    public void TestCaseNo8() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        sectionElements.sectionItemClick();

        String title = feedListElements.getFeedItemTitle();
        sectionElements.buttonShareClick();

        if (Utils.isAndroidPlatform()) {
            if (commonElements.gmailShareBox.isDisplayed()==false){
                Utils.scrollHorizontal(appiumDriver);
            }
            commonElements.selectShareGmailItemClick();
            commonElements.assertTitleResult(title, sectionElements.getShareGmailTitle());
        } else {

        }

        closeApp();
    }

    public void TestCaseNo11() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        sectionElements.sectionItemClick();
        articleDetailElements.back();

        closeApp();
    }

    public void TestCaseNo12() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.sectionTabClick();
        sectionElements.sectionItemClick();

        lockDevice();
        unLockDevice();

        commonElements.settingTabClick();
        commonElements.homeTabClick();
        commonElements.searchTabClick();
        commonElements.bookMarkTabClick();

        closeApp();
    }

}
