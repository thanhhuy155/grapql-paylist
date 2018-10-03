package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;
import scenarios.AppiumBaseClass;
import scenarios.AppiumController;

public class BaseTestClass extends AppiumBaseClass {
    GeneralTest generalTest;
    HomeTab homeTab;
    BookmarkTab bookmarkTab;
    SectionTab sectionTab;
    SettingTab settingTab;
    ArticlePage articlePage;
    SearchTab searchTab;

    @BeforeTest
    public void setUp() throws Exception {
        AppiumController.instance.start();
        generalTest = new GeneralTest(driver());
        homeTab = new HomeTab(driver());
        bookmarkTab = new BookmarkTab(driver());
        sectionTab = new SectionTab(driver());
        settingTab = new SettingTab(driver());
        searchTab = new SearchTab(driver());
        articlePage = new ArticlePage(driver());
    }

    @AfterTest
    public void tearDown() {
        AppiumController.instance.stop();
    }

}
