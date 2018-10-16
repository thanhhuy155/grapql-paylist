package elements;

import actions.ISection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

public class SectionElements extends CommonElements implements ISection {

    public SectionElements(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "card_view_category")
    @iOSFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    public MobileElement sectionItem;

    @AndroidFindBy(id="Navigate up")
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
}
