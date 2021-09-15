package demoversion;

import core.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.demoversion.accountsAndDeposits.AccountRefillPage;

public class DemoVersionMainTest extends BaseTest {
    protected final AccountRefillPage accountRefillPage = new AccountRefillPage(getAppiumDriver());

    @BeforeClass
    public void goToDemoVersion() {
        accountRefillPage
                .goToDemoVersion();
    }

    @Test(priority = 20)
    public void isDisplayedAlertAboutUnavailableInDemoVersion() {
        var actualResult = accountRefillPage.isExistAlertAboutNotAvailableInDemoVersion();

        Assert.assertTrue(actualResult);
    }
}
