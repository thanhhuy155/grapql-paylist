package elements;

import actions.ISection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import utils.Utils;

import java.util.List;

public class SectionElements extends CommonElements implements ISection {

    public SectionElements(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "card_view_category")
    @iOSFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    public MobileElement sectionItem;

    @AndroidFindBy(id = "card_view_category")
    @iOSFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell")
    public List<MobileElement> listSectionItem;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.ap.philly:id/category_toolbar']/android.widget.ImageButton")
    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement backButton;

    @AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public MobileElement backToSections;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[android.widget.RelativeLayout[android.widget.TextView[@text='News']]]")
    public  MobileElement newsSection;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[android.widget.RelativeLayout[android.widget.TextView[@text='Eagles']]]")
    public MobileElement eaglesSection;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[android.widget.RelativeLayout[android.widget.TextView[@text='Flyers']]]")
    public MobileElement flyersSection;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[android.widget.RelativeLayout[android.widget.TextView[@text='Phillies']]]")
    public MobileElement philliesSection;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[android.widget.RelativeLayout[android.widget.TextView[@text='Sixers']]]")
    public MobileElement sixersSection;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[android.widget.RelativeLayout[android.widget.TextView[@text='Sports']]]")
    public MobileElement sportsSection;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[android.widget.RelativeLayout[android.widget.TextView[@text='Business']]]")
    public MobileElement businessSection;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[android.widget.RelativeLayout[android.widget.TextView[@text='Opinion']]]")
    public MobileElement opinionSection;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[android.widget.RelativeLayout[android.widget.TextView[@text='Entertainment']]]")
    public MobileElement entertainmentSection;



    @Override
    public void sectionItemClick() {
        sectionItem.click();
    }

    @Override
    public void clickEachSectionItem(AppiumDriver appiumDriver){
        int numberOfItemInList;
        if(Utils.isAndroidPlatform()){
            numberOfItemInList=listSectionItem.size();
            if(numberOfItemInList==16){
                for(int i=0; i<15; i++){
                    listSectionItem.get(i).click();
                    backButton.click();
                }
            }
            else {
                for(int i=0; i<5; i++){
                    listSectionItem.get(i).click();
                    backButton.click();
                }
                Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);
                Utils.sleep(Constants.SHORTTIME);
                for(int i=0; i<11; i++){
                    listSectionItem.get(i).click();
                    backButton.click();
                }
            }

        }
        else {
            numberOfItemInList=listSectionItem.size();
            for(int i=0; i<(numberOfItemInList-4); i++){
                listSectionItem.get(i).click();
                backButton.click();
            }
            Utils.sleep(Constants.SHORTTIME);
            Utils.scrollScreen(appiumDriver, Utils.DIRECTION.DOWN);
            numberOfItemInList=listSectionItem.size();
            for(int i=0; i<numberOfItemInList; i++){
                listSectionItem.get(i).click();
                backButton.click();
            }
        }
    }
}
