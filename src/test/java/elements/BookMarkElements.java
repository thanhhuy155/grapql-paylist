package elements;

import actions.IBookMark;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BookMarkElements extends CommonElements implements IBookMark {

    public BookMarkElements(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView//android.widget.TextView[@resource-id='com.ap.philly:id/bookmark_title']")
    @iOSFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeTextView[1]")
    public MobileElement bookmarkTitle;

    @AndroidFindBy(xpath = "//android.support.v7.widget.LinearLayoutCompat[android.widget.TextView[@resource-id='com.ap.philly:id/action_edit']]")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit\"]")
    public MobileElement actionEdit;

    @AndroidFindBy(id = "bookmark_checkbox")
    public MobileElement bookmarkCheckbox;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView//android.widget.TextView[@resource-id='com.ap.philly:id/bookmark_title']")
    @iOSFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeTextView")
    public List<MobileElement> bookmarkTitleList;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.ap.philly:id/action_mode_bar']/android.widget.ImageView[@resource-id='com.ap.philly:id/action_mode_close_button']")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    public MobileElement backBtn;

    @Override
    public void bookMarkItemClick() {
        bookmarkTitle.click();
    }

    @Override
    public void assertTitleResult(String expected, String actual) {
        Assert.assertEquals(expected, actual);
    }

    @Override
    public void actionEditClick() {
        actionEdit.click();
    }

    @Override
    public void bookmarkCheckboxClick() {
        bookmarkCheckbox.click();
    }

    @Override
    public void back() {
        backBtn.click();
    }

    @Override
    public String getBookMarkTitle() {
        return bookmarkTitle.getText();
    }

    @Override
    public String clickAndGetArticleTitle(){
        String title;
        title = getBookMarkTitle();
        bookMarkItemClick();
        return title;
    }

    @Override
    public List<String> getBookmarkedTitles(){
        List<String> titleList = new ArrayList<>();
        for (MobileElement element: bookmarkTitleList) {
            titleList.add(element.getText());
        }
        return titleList;
    }
}
