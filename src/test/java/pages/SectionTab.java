package pages;

import elements.ArticleDetailElements;
import elements.BottomBarElements;
import elements.FeedListElements;
import elements.SectionElements;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import utils.Constants;
import utils.Utils;

import java.util.HashMap;

public class SectionTab extends BasePage {
    private BottomBarElements bottomBarElements;
    private FeedListElements feedListElements;
    private SectionElements sectionElements;
    private ArticleDetailElements articleDetailElements;

    public SectionTab(AppiumDriver driver) {
        super(driver);
        bottomBarElements = new BottomBarElements(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        sectionElements = new SectionElements(driver);
    }

    public void TestCaseNo3() {
        lauchApp();

        bottomBarElements.sectionTabClick();
        lockDevice();
        unLockDevice();

        closeApp();
    }

    public void TestCaseNo4() {
        lauchApp();

        bottomBarElements.sectionTabClick();
        sectionElements.sectionItemClick();

        closeApp();
    }

    public void TestCaseNo6() {
        lauchApp();

        bottomBarElements.sectionTabClick();
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

        bottomBarElements.sectionTabClick();
        sectionElements.sectionItemClick();

        String title = feedListElements.getFeedItemTitle();
        sectionElements.buttonShareClick();

        if (Utils.isAndroidPlatform()) {
            sectionElements.selectShareGmailItemClick();
            sectionElements.assertTitleResult(title, sectionElements.getShareGmailTitle());
        } else {

        }

        closeApp();
    }

    public void TestCaseNo11() {
        lauchApp();

        bottomBarElements.sectionTabClick();
        sectionElements.sectionItemClick();
        articleDetailElements.back();

        closeApp();
    }

    public void TestCaseNo12() {
        lauchApp();

        bottomBarElements.sectionTabClick();
        sectionElements.sectionItemClick();

        lockDevice();
        unLockDevice();

        bottomBarElements.settingTabClick();
        bottomBarElements.homeTabClick();
        bottomBarElements.searchTabClick();
        bottomBarElements.bookMarkTabClick();

        closeApp();
    }

}
