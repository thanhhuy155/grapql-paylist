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

    @Override
    public void sectionItemClick() {
        sectionItem.click();
    }
}
