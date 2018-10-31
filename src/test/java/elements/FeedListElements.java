package elements;

import actions.IFeedList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import utils.Utils;

public class FeedListElements extends CommonElements implements IFeedList {

    public FeedListElements(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "card_view_article")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Philly.com\"]//XCUIElementTypeNavigationBar/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    public MobileElement feedItemTopStoryLayout;

    @AndroidFindBy(id = "cardLayoutArticle")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Philly.com\"]//XCUIElementTypeNavigationBar/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]")
    public MobileElement feedItemLayout;

    @AndroidFindBy(id = "headlineArticle")
    @iOSFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
    public MobileElement feedItemTitle;

    @AndroidFindBy(id = "tv_top_story_title")
    @iOSFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    public MobileElement feedItemTitleTopStory;

    @AndroidFindBy(id = "shareIC")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton[3]")
    public MobileElement btnShareOnFeedArticle;

    @AndroidFindBy(id = "bookmarkIC")
    @iOSFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]//XCUIElementTypeStaticText[contains(@name,'ago')]/following-sibling::XCUIElementTypeButton[1]")
    public MobileElement btnBookmarkOnFeedArticle;


    //========================================================================================//
    //Android element only
    @AndroidFindBy(id = "com.ap.philly:id/dateArticle")
    public MobileElement articleDate;

    @AndroidFindBy(id = "articleAuthor")
    public MobileElement articleAuthor;

    @AndroidFindBy (id = "cardList")
    public MobileElement feedList;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@resource-id='com.ap.philly:id/cardList']/android.widget.RelativeLayout")
    public MobileElement ratingModule;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@resource-id='com.ap.philly:id/cardList']/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.ap.philly:id/tv_positive']")
    public MobileElement positiveRating;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@resource-id='com.ap.philly:id/cardList']/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.ap.philly:id/tv_negative']")
    public MobileElement negativeRating;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[android.view.ViewGroup[android.widget.TextView[contains(@text,'Philly.com: Latest News')]]]")
    public MobileElement phillyInPlayStore;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Okay, thanks for using the Philly.com App!')]")
    public MobileElement thankForUsePhillyMessage;
    //========================================================================================//


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

    @Override
    public void buttonShareClick() {
        btnShareOnFeedArticle.click();
    }

    @Override
    public void buttonBookmarkClick() {

        btnBookmarkOnFeedArticle.click();
        if(Utils.checkElementExist(infoCheckingScreen)==true||Utils.checkElementExist(googleAccountTextBox)==true){
            signInToGoogleAccount(Constants.GOOGLEACCOUNT_USERNAME, Constants.GOOGLEACCOUNT_PASSWORD);
        }
        if(Utils.checkElementExist(googleClientLogin)==true){
            googleClientLogin.click();
        }
        Utils.sleep(1000);
    }
}
