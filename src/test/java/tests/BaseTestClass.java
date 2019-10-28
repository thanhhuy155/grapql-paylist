package tests;

import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;
import scenarios.AppiumBaseClass;
import scenarios.AppiumController;
import utils.Constants;
import utils.Utils;

import java.io.IOException;
import java.nio.file.Files;

public class BaseTestClass extends AppiumBaseClass {
    BasePage basePage;
    GeneralTest generalTest;
    iOSGeneral iOS_General;
    HomeTab homeTab;
    iOSHomeTab iOS_HomeTab;
    BookmarkTab bookmarkTab;
    iOSBookmarkTab iOS_BookmarkTab;
    SectionTab sectionTab;
    SettingTab settingTab;
    iOSSettingTab iOS_SettingTab;
    iOSSearchTab iOS_SearchTab;
    ArticlePage articlePage;
    iOSArticlePage iOS_ArticlePage;
    RatingModule ratingModule;
    ExploreTab exploreTab;
    LoginPage loginPage;

    iOSLoginPage iOS_LoginPage;
    ForgotEmailPage forgotEmailPage;
    iOSForgotEmailPage iOS_ForgotEmailPage;
    ForgotPasswordPage forgotPasswordPage;
    iOSForgotPasswordPage iOS_ForgotPasswordPage;
    SignUpPage signUpPage;
    iOSSignUpPage iOS_SignUpPage;
    CustomizationPage customizationPage;
    iOSCustomizationPage iOS_CustomizationPage;


    @BeforeTest
    public void setUp(ITestContext iTestContext) throws Exception {
        Constants.EXECUTING_SUITE = iTestContext.getCurrentXmlTest().getSuite().getName();
        System.out.print("class: " + Constants.EXECUTING_SUITE);

        instance.start();
        basePage = new BasePage(driver());
        generalTest = new GeneralTest(driver());
        homeTab = new HomeTab(driver());
        bookmarkTab = new BookmarkTab(driver());
        iOS_BookmarkTab = new iOSBookmarkTab(driver());
        sectionTab = new SectionTab(driver());
        settingTab = new SettingTab(driver());
        iOS_SearchTab = new iOSSearchTab(driver());
        articlePage = new ArticlePage(driver());
        iOS_ArticlePage = new iOSArticlePage(driver());
        ratingModule = new RatingModule(driver());
        exploreTab = new ExploreTab(driver());
        customizationPage = new CustomizationPage(driver());
        iOS_General = new iOSGeneral(driver());
        iOS_HomeTab = new iOSHomeTab(driver());
        iOS_CustomizationPage = new iOSCustomizationPage(driver());
        iOS_LoginPage = new iOSLoginPage(driver());
        iOS_ForgotEmailPage = new iOSForgotEmailPage(driver());
        iOS_ForgotPasswordPage = new iOSForgotPasswordPage(driver());
        iOS_SignUpPage  = new iOSSignUpPage(driver());

       // turnOffSAndroidService();

        loginPage = new LoginPage(driver());
        forgotEmailPage = new ForgotEmailPage(driver());
        forgotPasswordPage = new ForgotPasswordPage(driver());
        signUpPage  = new SignUpPage(driver());
    }


    public  void turnOffSAndroidService(){

        //Turn off Samsung Autofill Service in devices
        if(AppiumController.executionOS.equals(AppiumController.OS.ANDROID_BROWSERSTACK) ||
                AppiumController.executionOS.equals(AppiumController.OS.ANDROID)) {
            Utils.turnOffSamsungAutofillService(driver());
        }
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
