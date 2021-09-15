package demoversion.accountAndDeposits;

import demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefillAndRequestPaymentTest extends DemoVersionMainTest {

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
