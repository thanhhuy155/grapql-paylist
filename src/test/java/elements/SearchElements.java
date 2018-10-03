package elements;

import actions.ISearch;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.PageFactory;

public class SearchElements extends CommonElements implements ISearch {

    public SearchElements(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Quick Search\"]")
    public MobileElement quickSearch;

    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"PhillyDotCom2.SearchContainerView\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public  MobileElement searchScreen;

    @iOSFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Enter search phrase\"]")
    public MobileElement searchBox;

    @iOSFindBy(xpath = "//XCUIElementTypeTable")
    public MobileElement autoSuggestedTable;

    @iOSFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]")
    public  MobileElement autoSuggestedTerm;

    @iOSFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeOther/XCUIElementTypeButton[@name=\"Newest\"]")
    public MobileElement newestSortOptionForSearchResult;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Clear text\"]")
    public MobileElement clearSearchTextButton;

}
