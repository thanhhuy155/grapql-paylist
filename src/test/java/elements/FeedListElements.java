package elements;

import actions.IFeedList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class FeedListElements extends CommonElements implements IFeedList {

    public FeedListElements(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "card_view_article")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Philly.com\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    public MobileElement feedItemTopStoryLayout;

    @AndroidFindBy(id = "cardLayoutArticle")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
    public MobileElement feedItemLayout;

    @AndroidFindBy(id = "headlineArticle")
    @iOSFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
    public MobileElement feedItemTitle;

    @AndroidFindBy(id = "tv_top_story_title")
    @iOSFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    public MobileElement feedItemTitleTopStory;

    //========================================================================================//
    //iOS element only
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Philly.com\"]//XCUIElementTypeNavigationBar/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]")
    public  MobileElement firstFeedItemSection;

    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Philly.com\"]//XCUIElementTypeNavigationBar/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    public MobileElement firstTopStorySection;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Philly.com\"]//XCUIElementTypeStaticText/following-sibling::XCUIElementTypeOther/XCUIElementTypeImage")
    public MobileElement imageOfArticle;

    @iOSFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
    public MobileElement feedItemSectionTab;
    //========================================================================================//

    @AndroidFindBy(id = "com.ap.philly:id/dateArticle")
    public MobileElement articleDate;

    @AndroidFindBy(id = "articleAuthor")
    public MobileElement articleAuthor;

    @AndroidFindBy (id = "cardList")
    public MobileElement feedList;


    @Override
    public void feedItemClick() {
        feedItemLayout.click();
    }

    @Override
    public void feedItemTopStoryClick() {
        if(!Utils.isAndroidPlatform()){
            firstTopStorySection.click();
        }
        else {
            feedItemTopStoryLayout.click();
        }
    }

    @Override
    public void assetResult(String expected, String actual) {

    }

    @Override
    public String getFeedItemTitle() {
        return feedItemTitle.getText();
    }

    @Override
    public String getFeedItemTopStoryTitle() {
        return feedItemTitleTopStory.getText();
    }

    @Override
    public String getArticleAuthorOnFeedList() {
        return articleAuthor.getText();
    }

    @Override
    public String getArticleDateOnFeedList() {
        return articleDate.getText();
    }

    @Override
    public void bookmarkArticle(){
    }


}
