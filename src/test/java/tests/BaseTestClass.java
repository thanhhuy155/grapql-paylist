package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
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
    @BeforeMethod
    public void runBeforeMethod(){
        basePage.lauchApp();
    }

//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] convertScreenshotFiletoByte(ITestResult testResult){
//        byte[] content =null;
//        try{
//            content = Files.readAllBytes(basePage.takeScreenshotOnFailure(testResult).toPath());
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return content;
//    }

    @AfterMethod
    public void runAfterMethod(ITestResult result){
        //convertScreenshotFiletoByte(result);
        basePage.takeScreenshotOnFailure(result);
        basePage.resetApp();
    }

    @AfterTest
    public void tearDown() {
        basePage.resetApp();
        AppiumController.instance.stop();
    }

}
