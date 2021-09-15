package demoversion.accountAndDeposits;

import demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.demoversion.accountsAndDeposits.AccountRefillPage;

public class RefillAndRequestPaymentTest extends DemoVersionMainTest {
    private final AccountRefillPage accountRefillPage = new AccountRefillPage(getAppiumDriver());

    @Test
    public void refillAndRequestPayment() {
        var actualResult = accountRefillPage
                .goToAccountRefill()
                .tapOnRefillButton()
                .tapOnRequestPaymentButton()
                .isExistAlertAboutNotAvailableInDemoVersion();

        Assert.assertTrue(actualResult);
    }
}
