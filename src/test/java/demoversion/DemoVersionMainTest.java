package demoversion;

import core.InitialDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.demoversion.DemoVersionMainPage;

public class DemoVersionMainTest {
    private final DemoVersionMainPage demoVersionMainPage = new DemoVersionMainPage(InitialDriver.getDriver());

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
