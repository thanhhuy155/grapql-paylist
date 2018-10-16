package pages;

import elements.*;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class SearchTab extends BasePage {
    private FeedListElements feedListElements;
    private SearchElements searchElements;
    private ArticleDetailElements articleDetailElements;
    private CommonElements commonElements;

    public SearchTab(AppiumDriver driver) {
        super(driver);
        feedListElements = new FeedListElements(driver);
        articleDetailElements = new ArticleDetailElements(driver);
        searchElements = new SearchElements(driver);
        commonElements = new CommonElements(driver);
    }

    public void TestCaseNo1() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.searchTab.click();
        Assert.assertTrue(searchElements.searchScreen.isDisplayed());
    }

    public void TestCaseNo2() {
        lauchApp();

        waitForVisibilityOf(commonElements.bottomTab);
        commonElements.searchTab.click();
        Assert.assertTrue(searchElements.quickSearch.isDisplayed());
    }

    public void TestCaseNo4(){
        lauchApp();

        //Step: 1. Click on the "Enter search phrase" input
        waitForVisibilityOf(commonElements.bookMarkTab);
        commonElements.searchTab.click();

        //Step: 2. Begin to type any letter
        searchElements.searchBox.sendKeys("A");

        //Step: 3. Observe the auto-suggest search terms drop down appear
        Assert.assertTrue(searchElements.autoSuggestedTable.isDisplayed());

        //Step: 4. Click any auto-suggested search term
        searchElements.autoSuggestedTerm.click();

        //Step: 5. Observe the auto-suggest term execute the search
        Assert.assertTrue(searchElements.newestSortOptionForSearchResult.isDisplayed());

        //Step: 6. Click back to return to search tab
        searchElements.clearSearchTextButton.click();
        Assert.assertTrue(searchElements.searchScreen.isDisplayed());
    }


}
