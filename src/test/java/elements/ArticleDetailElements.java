package elements;

import actions.IArticleDetail;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Utils;

public class ArticleDetailElements extends CommonElements implements IArticleDetail {

    public ArticleDetailElements(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "detailHeadline")
    @iOSFindBy(xpath = "//XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
    public MobileElement articleDetailTitle;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement backBtn;

    @AndroidFindBy(id = "com.ap.philly:id/bookmark")
    public MobileElement bookmark;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'READ NEXT')]")
    public MobileElement readNextLink;

    @Override
    public String getTitleArticleDetail() {
        return articleDetailTitle.getText();
    }

    @Override
    public void bookmarkClick() {
        bookmark.click();
        if (Utils.isAndroidPlatform()) {
            clickLogin();
        }
    }

    @Override
    public void assertTitleResult(String titleExpected, String titleActual) {
        Assert.assertEquals(titleExpected, titleActual);
    }

    @Override
    public void back() {
        backBtn.click();
    }
}
