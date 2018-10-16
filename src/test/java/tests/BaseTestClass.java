package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;
import scenarios.AppiumBaseClass;
import scenarios.AppiumController;

public class BaseTestClass extends AppiumBaseClass {
    BasePage basePage;
    GeneralTest generalTest;
    HomeTab homeTab;
    BookmarkTab bookmarkTab;
    SectionTab sectionTab;
    SettingTab settingTab;
    ArticlePage articlePage;
    SearchTab searchTab;
    RatingModule ratingModule;

    @BeforeTest
    public void setUp() throws Exception {
        AppiumController.instance.start();
        basePage = new BasePage(driver());
        generalTest = new GeneralTest(driver());
        homeTab = new HomeTab(driver());
        bookmarkTab = new BookmarkTab(driver());
        sectionTab = new SectionTab(driver());
        settingTab = new SettingTab(driver());
        searchTab = new SearchTab(driver());
        articlePage = new ArticlePage(driver());
        ratingModule = new RatingModule(driver());
    }

    @AfterTest
    public void tearDown() {
        basePage.resetApp();
        AppiumController.instance.stop();
    }

}
