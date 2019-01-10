package elements;

import actions.IExplore;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Utils;

import java.util.List;

public class ExploreElements extends CommonElements implements IExplore {

    public ExploreElements(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/heading']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Explore\"]")
    public MobileElement headingTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/title_header'][@text='ALL SECTIONS']")
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name=\"ALL SECTIONS\"]")
    public MobileElement allSectionsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/tv_category'][@text='News']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ALL SECTIONS')]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'News')]")
    public MobileElement newsSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/tv_category'][@text='Sports']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ALL SECTIONS')]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'Sports')]")
    public MobileElement sportsSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/tv_category'][@text='Business']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ALL SECTIONS')]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'Business')]")
    public MobileElement businessSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/tv_category'][@text='Opinion']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ALL SECTIONS')]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'Opinion')]")
    public MobileElement opinionSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/tv_category'][@text='Entertainment']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ALL SECTIONS')]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'Entertainment')]")
    public MobileElement entertainmentSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/tv_category'][@text='Food']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ALL SECTIONS')]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'Food')]")
    public MobileElement foodSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/tv_category'][@text='Politics']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ALL SECTIONS')]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'Politics')]")
    public MobileElement politicsSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/tv_category'][@text='Health']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ALL SECTIONS')]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'Health')]")
    public MobileElement healthSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/tv_category'][@text='Real Estate']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ALL SECTIONS')]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'Real Estate')]")
    public MobileElement realEstateSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/tv_category'][@text='Obituaries']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ALL SECTIONS')]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'Obituaries')]")
    public MobileElement obituariesSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/tv_category'][@text='Jobs']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ALL SECTIONS')]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'Jobs')]")
    public MobileElement jobsSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/tv_category'][@text='Life']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ALL SECTIONS')]/../following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'Life')]")
    public MobileElement lifeSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ap.philly:id/category_title']")
    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton/following-sibling::XCUIElementTypeOther")
    public MobileElement feedSectionHeader;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.ap.philly:id/child_container']")
    @iOSFindBy(xpath = "//XCUIElementTypeCell[XCUIElementTypeStaticText[@name=\"ALL SECTIONS\"]]/following-sibling::XCUIElementTypeCell/XCUIElementTypeOther/following-sibling::XCUIElementTypeStaticText")
    public List<MobileElement> listSubSections;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'')]")
    @iOSFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell")
    public List<MobileElement> listSubTitleSections;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.TextView[@resource-id='com.ap.philly:id/detailHeadline']")
    @iOSFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell")
    public MobileElement detailHeadline;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.ap.philly:id/category_toolbar']/android.widget.ImageButton")
    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement backButton;


    @Override
    public void checkSubsectionsOpenProperly(AppiumDriver appiumDriver, String subsectionList[], MobileElement section){
        String dynamicXpath = "//android.widget.TextView[contains(@text,'{0}')]";
        for(int i = 0; i<subsectionList.length; i++){
            String subsectionXpath = dynamicXpath.replace("{0}",subsectionList[i]);
            MobileElement element;
            if (Utils.isAndroidPlatform()){
                try{
                    element = ((AndroidDriver<MobileElement>)appiumDriver).findElement(By.xpath(subsectionXpath)) ;
                }catch(Exception e){
                    Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN,section );
                    element = ((AndroidDriver<MobileElement>)appiumDriver).findElement(By.xpath(subsectionXpath)) ;
                }
            }else {
                try{
                    element = ((IOSDriver<MobileElement>)appiumDriver).findElement(By.xpath(subsectionXpath));
                }catch(Exception e){
                    Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN,section );
                    element = ((IOSDriver<MobileElement>)appiumDriver).findElement(By.xpath(subsectionXpath));
                }
            }
            if(subsectionList[i]=="All Life"||subsectionList[i]=="Families"){
                Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);
            }
            if(!Utils.checkElementExist(element)){
                Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN, element);
            }
            element.click();
            checkSectionHeader(subsectionList[i],feedSectionHeader.getText());
            backButton.click();
        }

    }

    @Override
    public void checkSectionHeader(String sectionTitle, String sectionHeader) {
        Assert.assertTrue(sectionTitle.contains(sectionHeader));
    }

    @Override
    public void navigateToSubSection(AppiumDriver appiumDriver, MobileElement section, String subsectionName) {
        String dynamicXpath = "//android.widget.TextView[contains(@text,'{0}')]";
        String subsectionXpath = dynamicXpath.replace("{0}",subsectionName);

        MobileElement element;
        if(!Utils.checkElementExist(section)){
            Utils.scrollToElement(appiumDriver, Utils.DIRECTION.DOWN,section );
        }
        section.click();
        if (Utils.isAndroidPlatform()){
            element = ((AndroidDriver<MobileElement>)appiumDriver).findElement(By.xpath(subsectionXpath)) ;
        }else {
            element = ((IOSDriver<MobileElement>)appiumDriver).findElement(By.xpath(subsectionXpath));
        }
        element.click();
    }

    @Override
    public String getHeadingTitle() {
        return headingTitle.getText();
    }

    @Override
    public String getHeadingSubTitle() {
        return feedSectionHeader.getText();
    }

    @Override
    public String getArticleTitle() {
        return detailHeadline.getText();
    }
}
