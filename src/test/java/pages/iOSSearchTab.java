package pages;

import elements.CommonElements;
import elements.SearchElements;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import utils.Utils;

import java.util.concurrent.TimeUnit;

public class iOSSearchTab extends BasePage {
    private SearchElements searchElements;
    private CommonElements commonElements;

    public iOSSearchTab(AppiumDriver driver) {
        super(driver);
        searchElements = new SearchElements(driver);
        commonElements = new CommonElements(driver);
    }

    public void S233_C20428_SET_001_VerifyLoadSearchScreen() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.searchTab.click();
        Assert.assertTrue(searchElements.searchTab.isDisplayed());
    }

    public void S233_C20429_SET_002_VerifyQuickSearch() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.searchTab.click();
        Utils.sleep(2000);
        Assert.assertTrue(searchElements.quickSearch.isDisplayed());
    }

    public void S233_C20430_SET_003_VerifyAutoSuggestSearch(){
        lauchApp();

        //Step: 1. Click on the "Enter search phrase" input
        waitForVisibilityOf(commonElements.bookMarkTab);
        commonElements.searchTab.click();

        //Step: 2. Begin to type any letter
        searchElements.searchBox.sendKeys("A");
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Step: 3. Observe the auto-suggest search terms drop down appear
        Assert.assertTrue(searchElements.autoSuggestedTable.isDisplayed());

        //Step: 4. Click any auto-suggested search term
//        searchElements.searchByAutoSuggested();
        searchElements.autoSuggestedTerm.click();

        Utils.sleep(1000);
        //Step: 5. Observe the auto-suggest term execute the search
        Assert.assertTrue(searchElements.newestSortOptionForSearchResult.isDisplayed());

        //Step: 6. Click back to return to search tab
        searchElements.clearSearchTextButton.click();
        Assert.assertTrue(searchElements.searchScreen.isDisplayed());
    }

    public void S233_C20431_SET_004_VerifySearchByTyping(){
        String searchTerm = "election";
        lauchApp();

        //Step: 1. Click on the "Enter search phrase" input
        waitForVisibilityOf(commonElements.bookMarkTab);
        commonElements.searchTab.click();

        //Step: 2. Begin to type any letter/word
        searchElements.searchBox.sendKeys(searchTerm);

        //Step: 3. Execute the search
        appiumDriver.getKeyboard().pressKey(Keys.ENTER);
        Utils.sleep(1000);

        //Verify point: Search takes search term
        Assert.assertEquals(searchTerm,searchElements.searchBox.getAttribute("value"));

        //Verify point: Search is executed and result returns
//        Assert.assertTrue(searchElements.newestSortOptionForSearchResult.isDisplayed());
    }

}
