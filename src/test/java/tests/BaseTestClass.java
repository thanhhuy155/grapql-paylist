package tests;

import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;
import scenarios.AppiumBaseClass;
import utils.Constants;

import java.io.IOException;
import java.nio.file.Files;

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
    ExploreTab exploreTab;
    LoginPage loginPage;
    ForgotEmailPage forgotEmailPage;
    iOSLoginPage iOS_LoginPage;
    iOSForgotEmailPage iOS_ForgotEmailPage;
    ForgotPasswordPage forgotPasswordPage;
    iOSForgotPasswordPage iOS_ForgotPasswordPage;
    SignUpPage signUpPage;

    @BeforeTest
    public void setUp(ITestContext iTestContext) throws Exception {
        Constants.EXECUTING_SUITE = iTestContext.getCurrentXmlTest().getSuite().getName();
        System.out.print("class: " + Constants.EXECUTING_SUITE);

        instance.start();
        basePage = new BasePage(driver());
        generalTest = new GeneralTest(driver());
        homeTab = new HomeTab(driver());
        bookmarkTab = new BookmarkTab(driver());
        sectionTab = new SectionTab(driver());
        settingTab = new SettingTab(driver());
        searchTab = new SearchTab(driver());
        articlePage = new ArticlePage(driver());
        ratingModule = new RatingModule(driver());
        exploreTab = new ExploreTab(driver());
        loginPage = new LoginPage(driver());
        iOS_LoginPage = new iOSLoginPage(driver());
        forgotEmailPage = new ForgotEmailPage(driver());
        iOS_ForgotEmailPage = new iOSForgotEmailPage(driver());
        forgotPasswordPage = new ForgotPasswordPage(driver());
        iOS_ForgotPasswordPage = new iOSForgotPasswordPage(driver());
        signUpPage  = new SignUpPage(driver());

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] convertScreenshotFileToByte(ITestResult testResult){
        byte[] content =null;
        try{
            content = Files.readAllBytes(basePage.takeScreenshotOnFailure(testResult).toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
        return content;
    }

    @AfterMethod
    public void runAfterMethod(ITestResult result){
        try{
            convertScreenshotFileToByte(result);
        }catch (Exception i) {
            i.printStackTrace();
        }
        basePage.closeApp();
    }

    @AfterTest
    public void tearDown() {
        instance.stop();
    }

}
