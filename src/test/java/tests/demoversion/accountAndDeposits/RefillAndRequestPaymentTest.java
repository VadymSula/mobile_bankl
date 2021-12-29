package tests.demoversion.accountAndDeposits;

import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefillAndRequestPaymentTest extends DemoVersionMainTest {

    @Test
    public void refillAndRequestPayment() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnRefillButton()
                .tapOnRequestPaymentButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
