package elements;

import actions.IBookMark;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.aspectj.lang.annotation.AdviceName;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BookMarkElements extends CommonElements implements IBookMark {

    public BookMarkElements(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "bookmark_title")
    @iOSFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeTextView[1]")
    public MobileElement bookmarkTitle;

    @AndroidFindBy(id = "action_edit")
    public MobileElement actionEdit;

    @AndroidFindBy(id = "bookmark_checkbox")
    public MobileElement bookmarkCheckbox;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]")
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
}
