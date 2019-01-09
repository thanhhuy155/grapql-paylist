package pages;

import elements.ArticleDetailElements;
import elements.CommonElements;
import elements.ExploreElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class ExploreTab extends BasePage {
    private ExploreElements exploreElements;
    private CommonElements commonElements;
    private FeedListElements feedListElements;
    private ArticleDetailElements articleDetailElements;

    public ExploreTab(AppiumDriver driver) {
        super(driver);
        exploreElements = new ExploreElements(driver);
        commonElements = new CommonElements(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements =new ArticleDetailElements(driver);
    }

    public void TestCaseNo1() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.newsSection);
        exploreElements.newsSection.click();

        String newsSubsections[] = {"All News","Crime & Justice","Education","Weather","Philadelphia","New Jersey","Pennsylvania","Nation & World"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,newsSubsections, exploreElements.newsSection);
    }

    public void TestCaseNo2() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.sportsSection);
        exploreElements.sportsSection.click();

        String sportsSubsections[] = {"All Sports","Rally High School Sports","Eagles","Flyers","Phillies","Union","Sixers","College Sports"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,sportsSubsections, exploreElements.sportsSection);
    }

    public void TestCaseNo3(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.businessSection);
        exploreElements.businessSection.click();

        String businessSubsections[] = {"All Business","Jobs","Cars","Personal Finance","Health & Pharma","Energy","PhillyDeals","Retail","Small Business","Comcast"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,businessSubsections, exploreElements.businessSection);
    }

    public void TestCaseNo4(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.opinionSection);
        exploreElements.opinionSection.click();

        String opinionSubsections[] = {"All Opinion","Columnists","Editorials","Commentary","Cartoons"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,opinionSubsections, exploreElements.opinionSection);
    }

    public void TestCaseNo5(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.politicsSection);
        exploreElements.politicsSection.click();

        String politicsSubsections[] = {"All Politics","Pennsylvania Politics","New Jersey Politics","Elections"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,politicsSubsections, exploreElements.politicsSection);
    }

    public void TestCaseNo6(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.entertainmentSection);
        exploreElements.entertainmentSection.click();

        String entertainmentSubsections[] = {"All Entertainment","Arts & Culture","Horoscopes","Movies","Music","Television"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,entertainmentSubsections, exploreElements.entertainmentSection);
    }

    public void TestCaseNo7(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.foodSection);
        exploreElements.foodSection.click();

        String foodSubsections[] = {"All Food","Clean Plates","Drinks","Cooking","Craig LaBan","Michael Klein"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,foodSubsections, exploreElements.foodSection);
    }

    public void TestCaseNo8(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.healthSection);
        exploreElements.healthSection.click();

        String healthSubsections[] = {"All Health","Science","Climate News","Health Costs","The Opioid Crisis","Wellness"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,healthSubsections, exploreElements.healthSection);
    }

    public void TestCaseNo9(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.realEstateSection);
        exploreElements.realEstateSection.click();

        String realEstateSubsections[] = {"All Real Estate","Transportation","Residential","Commercial","Inga Saffron","Home"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,realEstateSubsections, exploreElements.realEstateSection);
    }

    public void TestCaseNo10(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.obituariesSection);
        exploreElements.obituariesSection.click();

        exploreElements.checkSectionHeader("Obituaries", exploreElements.feedSectionHeader.getText());
    }

    public void TestCaseNo11(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.jobsSection);
        exploreElements.jobsSection.click();

        exploreElements.checkSectionHeader("Jobs", exploreElements.feedSectionHeader.getText());
    }

    public void TestCaseNo12(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();


        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN,exploreElements.lifeSection);
        exploreElements.lifeSection.click();

        String lifeSubsections[] = {"All Life","Families","Style","Identity","Sex & Love","Things To Do at the Shore","Travel"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,lifeSubsections, exploreElements.lifeSection);
    }

    public void TestCaseNo13() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();
        lockDevice();
        unLockDevice();
    }

    public void TestCaseNo14() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();
        exploreElements.navigateToSubSection(appiumDriver, exploreElements.newsSection,"All News");

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

    public void TestCaseNo15() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();
        exploreElements.navigateToSubSection(appiumDriver, exploreElements.newsSection,"All News");

        waitForVisibilityOf(feedListElements.feedItemTitle);

        String title = feedListElements.getFeedItemTitle();
        feedListElements.btnShareOnFeedArticle.click();

        if (Utils.isAndroidPlatform()) {
            commonElements.shareArticleOn(appiumDriver, CommonElements.ShareOptions.GMAIL);
            Assert.assertTrue(commonElements.gmailSubject.getText().contains(title));
        } else {

        }

    }

    public void TestCaseNo16() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();
        exploreElements.navigateToSubSection(appiumDriver, exploreElements.newsSection,"All News");

        exploreElements.backButton.click();
    }

    public void TestCaseNo17() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();
        exploreElements.navigateToSubSection(appiumDriver, exploreElements.newsSection,"All News");

        lockDevice();
        unLockDevice();
        Utils.sleep(Constants.SHORTTIME);
        activateApp();

        exploreElements.backButton.click();

        commonElements.settingTabClick();
        commonElements.homeTabClick();
        commonElements.bookMarkTab.click();

    }

}
