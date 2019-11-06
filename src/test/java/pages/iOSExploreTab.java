package pages;

import elements.ArticleDetailElements;
import elements.CommonElements;
import elements.ExploreElements;
import elements.FeedListElements;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Utils;

public class iOSExploreTab extends BasePage {
    private ExploreElements exploreElements;
    private CommonElements commonElements;
    private FeedListElements feedListElements;
    private ArticleDetailElements articleDetailElements;

    public iOSExploreTab(AppiumDriver driver) {
        super(driver);
        exploreElements = new ExploreElements(driver);
        commonElements = new CommonElements(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements =new ArticleDetailElements(driver);
    }

    public void S266_C22279_ET_001_01_VerifyNewsSections() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.newsSection);
        exploreElements.newsSection.click();

        //Production
        String newsSubsections[] = {"All News","Crime & Justice","Education","Weather","Philadelphia","New Jersey","Pennsylvania","Nation & World"};

        //Dev
       // String newsSubsections[] = {"All News","Politics", "Crime & Justice","Education","Weather","Philadelphia","New Jersey","Pennsylvania","Nation & World News"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,newsSubsections, exploreElements.newsSection);
    }

    public void S266_C22280_ET_001_02_VerifySportsSections() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.sportsSection);
        exploreElements.sportsSection.click();

        String sportsSubsections[] = {"All Sports","Eagles","Flyers","Rally High School Sports","Phillies","Union","Sixers","College Sports"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,sportsSubsections, exploreElements.sportsSection);
    }

    public void S266_C22281_ET_001_03_VerifyBusinessSections(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.businessSection);
        exploreElements.businessSection.click();

        //Production
        String businessSubsections[] = {"All Business","Jobs","Cars","Consumer","Health & Pharma","Energy","PhillyDeals","Retail","Small Business","Marijuana","Comcast","Economy"};
        exploreElements.checkSubsectionsOpenProperly(appiumDriver,businessSubsections, exploreElements.businessSection);

        //Dev: Business has no sub section
       // exploreElements.checkSectionHeader("Business", exploreElements.feedSectionHeader.getText());
    }

    public void S266_C22282_ET_001_04_VerifyOpinionSections(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.opinionSection);
        exploreElements.opinionSection.click();

        String opinionSubsections[] = {"All Opinion","Columnists","Editorials","Commentary","Letters","Cartoons"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,opinionSubsections, exploreElements.opinionSection);
    }

    public void S266_C22283_ET_001_05_VerifyPoliticsSections(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.politicsSection);
        exploreElements.politicsSection.click();

        //Production
        String politicsSubsections[] = {"All Politics","Pennsylvania Politics","New Jersey Politics","National Polictices", "Elections"};

        //Dev : Politics has no sub section
        //String politicsSubsections[] = {};
        exploreElements.checkSubsectionsOpenProperly(appiumDriver,politicsSubsections, exploreElements.politicsSection);
    }

    public void S266_C22284_ET_001_06_VerifyEntertainmentsSections(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.entertainmentSection);
        exploreElements.entertainmentSection.click();

       // String entertainmentSubsections[] = {"All Entertainment","Arts & Culture","Horoscopes","Movies","Music","Television"};

        //Production
        String entertainmentSubsections[] = {"All Entertainment","Things To Do", "Arts & Culture","Horoscopes","Movies","Music","Television","Celebrity"};

        //Dev:
        //String entertainmentSubsections[] = {"All Entertainment", "PMN Events", "Arts & Culture","Horoscopes","Movies","Music","Television"};
        exploreElements.checkSubsectionsOpenProperly(appiumDriver,entertainmentSubsections, exploreElements.entertainmentSection);
    }

    public void S266_C22285_ET_001_07_VerifyFoodSections(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.foodSection);
        exploreElements.foodSection.click();

        //Production
        String foodSubsections[] = {"All Food","Clean Plates","Drinks","Cooking","Craig LaBan","Michael Klein"};

        //Dev
        //String foodSubsections[] = {"All Food","Drinks" ,"Clean Plates", "Craig LaBan","Michael Klein"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,foodSubsections, exploreElements.foodSection);
    }

    public void S266_C22286_ET_001_08_VerifyHealthAndWellnessSections(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.healthSection);
        exploreElements.healthSection.click();

        //Production
        String healthSubsections[] = {"All Health","Science","Climate News","Health Costs","The Opioid Crisis","Wellness", "Expert Opinions"};

        //Dev
      //  String healthSubsections[] = {"All Health & Wellness","Science","Climate News","Health Costs","The Opioid Crisis","Wellness"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,healthSubsections, exploreElements.healthSection);
    }

    public void S266_C22287_ET_001_09_VerifyRealEstateSections(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.realEstateSection);
        exploreElements.realEstateSection.click();

        //Production
        String realEstateSubsections[] = {"All Real Estate","Transportation","Residential","Commercial","Inga Saffron","Home"};

        //Dev
//        String realEstateSubsections[] = {"All Real Estate","Transportation","Residential","Commercial","Home", "Inga Saffron"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,realEstateSubsections, exploreElements.realEstateSection);
    }

    public void S266_C22288_ET_001_10_VerifyObituariesSections(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.obituariesSection);
        exploreElements.obituariesSection.click();

        exploreElements.checkSectionHeader("Obituaries", exploreElements.feedSectionHeader.getText());
    }

    public void S266_C22289_ET_001_11_VerifyJobsSections(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();

        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, exploreElements.jobsSection);
        exploreElements.jobsSection.click();

        exploreElements.checkSectionHeader("Jobs", exploreElements.feedSectionHeader.getText());
    }

    public void S266_C22290_ET_001_12_VerifyLifeSections(){
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();


        Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN,exploreElements.lifeSection);
        exploreElements.lifeSection.click();

        //Production
        String lifeSubsections[] = {"All Life","Families","Style","Sex & Love","Things To Do at the Shore","Travel"};

        //Dev
//        String lifeSubsections[] = {"All Life","Families","Fashion & Style", "Identity","Love", "Travel"};

        exploreElements.checkSubsectionsOpenProperly(appiumDriver,lifeSubsections, exploreElements.lifeSection);
    }


    public void S266_C22291_ET_003_VerifyArticlePageWhenClickingFeedArticle() {
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

    public void S266_C22292_ET_005_VerifyArticlePageWhenSwitchingFeedArticle() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();
        exploreElements.navigateToSubSection(appiumDriver, exploreElements.newsSection,"All News");

        exploreElements.backButton.click();
    }


    //C8822
    public void S266_C24250_ET_007_VerifyMyMostReadSections() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.exploreTab.click();
        Assert.assertEquals("MY MOST READ SECTIONS",exploreElements.readSection.getAttribute("value"));
    }

}