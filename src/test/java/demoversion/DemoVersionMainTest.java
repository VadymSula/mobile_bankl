package demoversion;

import core.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.demoversion.DemoVersionMainPage;

public class DemoVersionMainTest extends BaseTest {
    private final DemoVersionMainPage demoVersionMainPage = new DemoVersionMainPage(getAppiumDriver());

    @BeforeClass
    public void goToDemoVersion() {
        demoVersionMainPage
                .goToDemoVersion();
    }

    @Test(priority = 20)
    public void isDisplayedAlertAboutUnavailableInDemoVersion() {
        var actualResult = demoVersionMainPage.isExistAlertAboutNotAvailableInDemoVersion();

        Assert.assertTrue(actualResult);
    }
}
