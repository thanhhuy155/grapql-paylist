package actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public interface IExplore {
    void checkSectionHeader(String sectionTitle, String sectionHeader);

    void checkSubsectionsOpenProperly(AppiumDriver appiumDriver, String subsectionList[], MobileElement section);

    void navigateToSubSection(AppiumDriver appiumDriver, MobileElement section, String subsectionName);

    String getHeadingTitle();

    String getHeadingSubTitle();

    String getArticleTitle();
}
