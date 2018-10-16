package pages;

import elements.ArticleDetailElements;
import elements.CommonElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Utils;

public class RatingModule extends BasePage{

    private ArticleDetailElements articleDetailElements;
    private FeedListElements feedListElements;
    private CommonElements commonElements;

    public RatingModule(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        commonElements = new CommonElements(driver);
    }

    public void TestCaseNo1(){
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step: Go to article detail page
        feedListElements.feedItemClick();

        //Step: Scroll through 100 articles
        for(int right=1; right<=50; right++){
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.RIGHT);
        }
        for(int left=1; left<=50; left++){
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.LEFT);
        }

        //Step: Back to Home tab/Feed list
        articleDetailElements.backBtn.click();

        //Step: Scroll up screen and check the Rating Module appears
        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
        Utils.checkElementExist(feedListElements.ratingModule);
    }

    public void TestCaseNo2(){
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step: Go to article detail page
        feedListElements.feedItemClick();

        //Step: Scroll through 100 articles
        for(int right=1; right<=50; right++){
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.RIGHT);
        }
        for(int left=1; left<=50; left++){
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.LEFT);
        }

        //Step: Back to Homepage/Feed list and select positive rating - Yes
        articleDetailElements.backBtn.click();
        Utils.sleep(1000);
        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
        Utils.sleep(2000);
        feedListElements.positiveRating.click();

        //Step: Select positive rating - Yes -  to rate on Play Store
        feedListElements.positiveRating.click();

        //Step: Check play store open to rate
        Assert.assertTrue(Utils.checkElementExist(feedListElements.phillyInPlayStore));
    }

    public void TestCaseNo3(){
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step: Go to article detail page
        feedListElements.feedItemClick();

        //Step: Scroll through 100 articles
        for (int right = 1; right <= 50; right++) {
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.RIGHT);
        }
        for (int left = 1; left <= 50; left++) {
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.LEFT);
        }

        //Step: Back to Homepage/Feed list and select positive rating - Yes
        articleDetailElements.backBtn.click();
        Utils.sleep(1000);
        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
        Utils.sleep(2000);
        feedListElements.positiveRating.click();

        //Step: Select negative rating - No - to NOT rate on Play Store
        feedListElements.negativeRating.click();

        //Step: Check play store not appear and thank you message appears on Feed list
        Assert.assertTrue(Utils.checkElementExist(feedListElements.thankForUsePhillyMessage));
        Assert.assertFalse(Utils.checkElementExist(feedListElements.phillyInPlayStore));
    }

    public void TestCaseNo4() {
        lauchApp();
        waitForVisibilityOf(feedListElements.feedItemTitleTopStory);

        //Step: Go to article detail page
        feedListElements.feedItemClick();

        //Step: Scroll through 100 articles
        for (int right = 1; right <= 50; right++) {
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.RIGHT);
        }
        for (int left = 1; left <= 50; left++) {
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.LEFT);
        }

        //Step: Back to Homepage/Feed list and select negative rating - No
        articleDetailElements.backBtn.click();
        Utils.sleep(1000);
        Utils.scrollScreen(appiumDriver, Utils.DIRECTION.UP);
        Utils.sleep(2000);
        feedListElements.negativeRating.click();

        //Step: Select negative rating - No - to NOT rate on Play Store
        feedListElements.negativeRating.click();

        //Step: Check play store not appear
        //Assert.assertTrue(Utils.checkElementExist(feedListElements.thankForUsePhillyMessage));
        Assert.assertFalse(Utils.checkElementExist(feedListElements.phillyInPlayStore));
    }
}
